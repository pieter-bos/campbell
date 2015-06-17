import Text.ParserCombinators.Parsec hiding (tab, space)
import Control.Applicative ((<*))

data Expression
    = BinaryExpression Expression BinaryOp Expression
    | UnaryExpression UnaryOp Expression
    | IdentifierExpression String
    | FunctionCallExpression Expression [Expression]
    | BoolExpression Bool
    | IntExpression Integer
    deriving (Show, Eq)

data BinaryOp
    = Plus
    | Minus
    | Times
    | Divide
    | Modulo
    deriving (Show, Eq)

data UnaryOp
    = Negate
    deriving (Show, Eq)

data Declaration
    = Declaration ClassName String
    deriving (Show, Eq)

data ClassName
    = ClassName String [String]
    deriving (Show, Eq)

data Statement
    = Fun String ClassName [Declaration]
    | AssignDecl Declaration Expression
    | Assign Expression Expression
    | While Expression
    | If Expression
    | Else
    | Impl ClassName [String]
    | Trait ClassName [String]
    | Class ClassName
    | Return Expression
    | Expr Expression
    | Unsafe
    | Decl Declaration
    deriving (Show, Eq)

program :: Parser [(Int, Statement)]
program = do
    lines <- many1 line
    eof
    return lines

line :: Parser (Int, Statement)
line = do
    tabs <- many tab
    stat <- statement
    space
    eol
    return (length tabs, stat)

tab :: Parser ()
tab =  (char '\t' >> return ()) 
   <|> (char ' ' >> char ' ' >> char ' ' >> char ' ' >> return ())

eol :: Parser ()
eol =  (char '\r' >> char '\n' >> return ())
   <|> (char '\n' >> return ())

statement :: Parser Statement
statement = fun <|> unsafe <|> while <|> ruleIf <|> ruleElse <|> impl <|> trait <|> ruleClass <|> ruleReturn <|> (expr >>= (return . Expr)) <|> (decl >>= (return . Decl)) <|> assign

fun :: Parser Statement
fun = do
    string "fun"
    t <- className
    name <- identifier
    space
    char '('
    space
    args <- sepBy decl (char ',')
    char ')'
    space
    return (Fun name t args)

assign :: Parser Statement
assign = 
    do {
        dec <- decl;
        space;
        string "=";
        space;
        exp <- expr;
        return $ AssignDecl dec exp
    } <|> do {
        exp1 <- expr;
        space;
        string "=";
        space;
        exp2 <- expr;
        return $ Assign exp1 exp2
    }

while :: Parser Statement
while = string "while" >> expr >>= (return . While)

ruleIf :: Parser Statement
ruleIf = string "if" >> expr >>= (return . If)

ruleElse :: Parser Statement
ruleElse = string "else" >> (return Else)

typeList :: Parser [String]
typeList = do
    string "<"
    space
    ids <- sepBy identifier (char ',')
    string ">"
    return ids

classList :: Parser [String]
classList = fmap (:[]) identifier
     <|> do {
        space;
        string "(";
        space;
        id1 <- identifier;
        string ",";
        id2 <- identifier;
        ids <- many (char ',' >> identifier);
        ids <- return (id1:id2:ids);
        string ")";
        space;
        return ids
    }

className :: Parser ClassName
className = 
        do {
            id <- identifier;
            return $ ClassName id []
        } <|> do {
            id <- identifier;
            list <- typeList;
            space;
            return $ ClassName id list
        }

impl :: Parser Statement
impl =
    do {
         string "impl";
         name <- className;
         return $ Impl name []
} <|> do {
    string "impl";
    name <- className;
    string "of";
    list <- classList;
    return $ Impl name list
}

trait :: Parser Statement
trait = 
    do {
        string "trait";
        name <- className;
        return $ Trait name []
} <|> do {
    string "trait";
    name <- className;
    string "of";
    list <- classList;
    return $ Trait name list
}

ruleClass :: Parser Statement
ruleClass = string "class" >> className >>= (return . Class)

ruleReturn :: Parser Statement
ruleReturn = string "return" >> expr >>= (return . Return)

unsafe :: Parser Statement
unsafe = string "unsafe" >> return Unsafe

decl :: Parser Declaration
decl = do {
    name <- className;
    id <- identifier;
    return $ Declaration name id
}

expr :: Parser Expression
expr = do {
    left <- expr;
    string "+";
    right <- factor;
    return $ BinaryExpression left Plus right
} <|> do {
    left <- expr;
    string "-";
    right <- factor;
    return $ BinaryExpression left Minus right
} <|> factor

factor :: Parser Expression
factor = do {
    left <- factor;
    char '*';
    right <- primary;
    return $ BinaryExpression left Times right
} <|> do {
    left <- factor;
    char '/';
    right <- primary;
    return $ BinaryExpression left Divide right
} <|> do {
    left <- factor;
    char '%';
    right <- primary;
    return $ BinaryExpression left Modulo right
} <|> primary

primary :: Parser Expression
primary = functionCall <|> int <|> bool <|> (fmap IdentifierExpression identifier) <|> (space >> char '(' >> expr <* char ')' <* space)

functionCall :: Parser Expression
functionCall = do 
    func <- expr
    char '('
    args <- sepBy expr (char ',')
    char ')'
    return $ FunctionCallExpression func []

identifier :: Parser String
identifier = do
    space
    c <- oneOf "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_$"
    cs <- many $ oneOf "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_$0123456789"
    space
    return (c:cs)

bool :: Parser Expression
bool = (space >> string "true" >> space >> return (BoolExpression True)) <|> (space >> string "false" >> space >> return (BoolExpression False))

int :: Parser Expression
int = do
    space
    i <- oneOf "123456789"
    is <- many $ oneOf "0123456789"
    space
    return $ IntExpression (read (i:is) :: Integer)

space :: Parser ()
space = (many $ oneOf " \t") >> return ()
     <?> "whitespace"

-- klad
--program         : line+ eof

--line            : tabs statement eol
--                | eol

--statement       : fun
--                | assign
--                | while
--                | if
--                | else
--                | impl
--                | trait
--                | class
--                | return
--                | expr
--                | unsafe
--                | decl

--arguments       : decl (COMMA decl)*

--fun             : FUN identifier PAREN_OPEN arguments PAREN_CLOSE

--assign          : decl ASSIGN expr
--                | expr ASSIGN expr

--while           : WHILE expr

--if              : IF expr

--else            : ELSE

--typeList        : BROKET_OPEN identifier (COMMA identifier)* BROKET_CLOSE

--classList       : identifier
--                | PAREN_OPEN identifier COMMA identifier (COMMA identifier)* PAREN_CLOSE

--className       : identifier
--                | identifier typeList

--impl            : IMPL className
--                | IMPL className OF classList

--trait           : TRAIT className
--                | TRAIT className OF classList

--class           : CLASS className

--return          : RETURN expr

--unsafe          : UNSAFE

--decl            : className identifier

--expr            : expr PLUS factor
--                | expr MINUS factor
--                | factor

--factor          : factor STAR primary
--                | factor SLASH primary
--                | factor PERCENT primary
--                | primary

--primary         : functionCall
--                | int
--                | bool
--                | identifier
--                | PAREN_OPEN expr PAREN_CLOSE

--functionCall    : identifier PAREN_OPEN args PAREN_CLOSE

--args            : expr (COMMA expr)*

--identifier      : [$a-zA-Z_][$a-zA-Z_0-9]*

--int             : 0 
--                | [1-9][0-9]*

--bool            : "true"
--                | "false"