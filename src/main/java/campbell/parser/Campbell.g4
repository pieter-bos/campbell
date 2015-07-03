grammar Campbell;
import CampbellTokens;

program
    : statement+ EOF
    ;

statement
    : haskell
    | fun
    | unsafe
    | whileNode
    | ifNode
    | impl
    | trait
    | returnNode
    | decl
    | assign
    | classNode
    | forNode
    | expr
    ;

haskell
    : HASKELL
    ;

fun
    : FUN className IDENTIFIER PAREN_OPEN
      (decl (COMMA decl)*)? PAREN_CLOSE block?
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
    : expr AND expr0 # and
    | expr OR expr0 # or
    | expr XOR expr0 # xor
    | expr0 # superExpr
    ;

expr0
    : expr0 LTE expr1 # lte
    | expr0 GTE expr1 # gte
    | expr0 EQ expr1 # eq
    | expr0 NEQ expr1 # neq
    | expr0 BROKET_OPEN expr1 # lt
    | expr0 BROKET_CLOSE expr1 # gt
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
    | expr2 LSH expr3 # lsh
    | expr2 RSH expr3 # rsh
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
    : IDENTIFIER (BROKET_OPEN className
      (COMMA className)* BROKET_CLOSE)? # classNameClass
    | PAREN_OPEN className ARROW className (ARROW className)* PAREN_CLOSE #classNameFunc
    ;

classList
    : className
    | PAREN_OPEN className COMMA className
      (COMMA className)* PAREN_CLOSE
    ;

exprAddon
    : PAREN_OPEN (expr (COMMA expr)*)? PAREN_CLOSE # call
    | DOT IDENTIFIER # get
    ;

bool
    : TRUE # true
    | FALSE # false
    ;