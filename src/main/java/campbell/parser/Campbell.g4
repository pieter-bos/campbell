grammar Campbell;
import CampbellTokens;

program
    : statement+ EOF
    ;

statement
    : fun
    | unsafe
    | whileNode
    | ifNode
    | impl
    | trait
    | returnNode
    | expr
    | decl
    | assign
    | classNode
    | forNode
    ;

fun
    : FUN className IDENTIFIER PAREN_OPEN (decl (COMMA decl)*)? PAREN_CLOSE block?
    ;

unsafe
    : UNSAFE block
    ;

whileNode
    : WHILE expr block
    ;

ifNode
    : IF expr block (ELSE block)?
    ;

impl
    : IMPL className (OF classList)? block
    ;

trait
    : TRAIT className (OF classList)? block
    ;

returnNode
    : RETURN expr
    ;

decl
    : className IDENTIFIER
    ;

assign
    : expr EQUALS expr
    | decl EQUALS expr
    ;

classNode
    : CLASS className block
    ;

forNode
    : FOR expr IN expr block
    ;

expr
    : expr1 LTE expr1 # lte
    | expr1 GTE expr1 # gte
    | expr1 BROKET_OPEN expr1 # lt
    | expr1 BROKET_CLOSE expr1 # gt
    | expr1 # simpleExpr
    ;

expr1
    : expr1 PLUS expr2 # add
    | expr1 MINUS expr2 # subtract
    | expr2 # simpleExpr1
    ;

expr2
    : expr2 STAR expr3 # multiply
    | expr2 SLASH expr3 # divide
    | expr2 PERCENT expr3 # modulo
    | expr3 # simpleExpr2
    ;

expr3
    : MINUS expr # negate
    | expr4 # simpleExpr3
    ;

expr4
    : INT exprAddon* # int
    | bool exprAddon* # boolExpr
    | IDENTIFIER exprAddon* # id
    | PAREN_OPEN expr PAREN_CLOSE exprAddon* # paren
    ;

block
    : OPEN_BLOCK statement+ CLOSE_BLOCK
    ;

className
    : IDENTIFIER (BROKET_OPEN className (COMMA className)* BROKET_CLOSE)?
    ;

classList
    : className
    | PAREN_OPEN className COMMA className (COMMA className)* PAREN_CLOSE
    ;

exprAddon
    : PAREN_OPEN (expr (COMMA expr)*)? PAREN_CLOSE # call
    | DOT IDENTIFIER # get
    ;

bool
    : TRUE # true
    | FALSE # false
    ;