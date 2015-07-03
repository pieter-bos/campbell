// Generated from /home/pieter/programming/haskell/campbell/src/main/java/campbell/parser/Campbell.g4 by ANTLR 4.5
package campbell.parser.gen;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CampbellParser}.
 */
public interface CampbellListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CampbellParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull CampbellParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CampbellParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull CampbellParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CampbellParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull CampbellParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CampbellParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull CampbellParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CampbellParser#haskell}.
	 * @param ctx the parse tree
	 */
	void enterHaskell(@NotNull CampbellParser.HaskellContext ctx);
	/**
	 * Exit a parse tree produced by {@link CampbellParser#haskell}.
	 * @param ctx the parse tree
	 */
	void exitHaskell(@NotNull CampbellParser.HaskellContext ctx);
	/**
	 * Enter a parse tree produced by {@link CampbellParser#fun}.
	 * @param ctx the parse tree
	 */
	void enterFun(@NotNull CampbellParser.FunContext ctx);
	/**
	 * Exit a parse tree produced by {@link CampbellParser#fun}.
	 * @param ctx the parse tree
	 */
	void exitFun(@NotNull CampbellParser.FunContext ctx);
	/**
	 * Enter a parse tree produced by {@link CampbellParser#unsafe}.
	 * @param ctx the parse tree
	 */
	void enterUnsafe(@NotNull CampbellParser.UnsafeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CampbellParser#unsafe}.
	 * @param ctx the parse tree
	 */
	void exitUnsafe(@NotNull CampbellParser.UnsafeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CampbellParser#whileNode}.
	 * @param ctx the parse tree
	 */
	void enterWhileNode(@NotNull CampbellParser.WhileNodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CampbellParser#whileNode}.
	 * @param ctx the parse tree
	 */
	void exitWhileNode(@NotNull CampbellParser.WhileNodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CampbellParser#ifNode}.
	 * @param ctx the parse tree
	 */
	void enterIfNode(@NotNull CampbellParser.IfNodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CampbellParser#ifNode}.
	 * @param ctx the parse tree
	 */
	void exitIfNode(@NotNull CampbellParser.IfNodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CampbellParser#impl}.
	 * @param ctx the parse tree
	 */
	void enterImpl(@NotNull CampbellParser.ImplContext ctx);
	/**
	 * Exit a parse tree produced by {@link CampbellParser#impl}.
	 * @param ctx the parse tree
	 */
	void exitImpl(@NotNull CampbellParser.ImplContext ctx);
	/**
	 * Enter a parse tree produced by {@link CampbellParser#trait}.
	 * @param ctx the parse tree
	 */
	void enterTrait(@NotNull CampbellParser.TraitContext ctx);
	/**
	 * Exit a parse tree produced by {@link CampbellParser#trait}.
	 * @param ctx the parse tree
	 */
	void exitTrait(@NotNull CampbellParser.TraitContext ctx);
	/**
	 * Enter a parse tree produced by {@link CampbellParser#returnNode}.
	 * @param ctx the parse tree
	 */
	void enterReturnNode(@NotNull CampbellParser.ReturnNodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CampbellParser#returnNode}.
	 * @param ctx the parse tree
	 */
	void exitReturnNode(@NotNull CampbellParser.ReturnNodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CampbellParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(@NotNull CampbellParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CampbellParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(@NotNull CampbellParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CampbellParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(@NotNull CampbellParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link CampbellParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(@NotNull CampbellParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link CampbellParser#classNode}.
	 * @param ctx the parse tree
	 */
	void enterClassNode(@NotNull CampbellParser.ClassNodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CampbellParser#classNode}.
	 * @param ctx the parse tree
	 */
	void exitClassNode(@NotNull CampbellParser.ClassNodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CampbellParser#forNode}.
	 * @param ctx the parse tree
	 */
	void enterForNode(@NotNull CampbellParser.ForNodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CampbellParser#forNode}.
	 * @param ctx the parse tree
	 */
	void exitForNode(@NotNull CampbellParser.ForNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code superExpr}
	 * labeled alternative in {@link CampbellParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSuperExpr(@NotNull CampbellParser.SuperExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code superExpr}
	 * labeled alternative in {@link CampbellParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSuperExpr(@NotNull CampbellParser.SuperExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code or}
	 * labeled alternative in {@link CampbellParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOr(@NotNull CampbellParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code or}
	 * labeled alternative in {@link CampbellParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOr(@NotNull CampbellParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code and}
	 * labeled alternative in {@link CampbellParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAnd(@NotNull CampbellParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code and}
	 * labeled alternative in {@link CampbellParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAnd(@NotNull CampbellParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xor}
	 * labeled alternative in {@link CampbellParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterXor(@NotNull CampbellParser.XorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xor}
	 * labeled alternative in {@link CampbellParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitXor(@NotNull CampbellParser.XorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExpr}
	 * labeled alternative in {@link CampbellParser#expr0}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpr(@NotNull CampbellParser.SimpleExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExpr}
	 * labeled alternative in {@link CampbellParser#expr0}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpr(@NotNull CampbellParser.SimpleExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lt}
	 * labeled alternative in {@link CampbellParser#expr0}.
	 * @param ctx the parse tree
	 */
	void enterLt(@NotNull CampbellParser.LtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lt}
	 * labeled alternative in {@link CampbellParser#expr0}.
	 * @param ctx the parse tree
	 */
	void exitLt(@NotNull CampbellParser.LtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code gte}
	 * labeled alternative in {@link CampbellParser#expr0}.
	 * @param ctx the parse tree
	 */
	void enterGte(@NotNull CampbellParser.GteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code gte}
	 * labeled alternative in {@link CampbellParser#expr0}.
	 * @param ctx the parse tree
	 */
	void exitGte(@NotNull CampbellParser.GteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code neq}
	 * labeled alternative in {@link CampbellParser#expr0}.
	 * @param ctx the parse tree
	 */
	void enterNeq(@NotNull CampbellParser.NeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code neq}
	 * labeled alternative in {@link CampbellParser#expr0}.
	 * @param ctx the parse tree
	 */
	void exitNeq(@NotNull CampbellParser.NeqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lte}
	 * labeled alternative in {@link CampbellParser#expr0}.
	 * @param ctx the parse tree
	 */
	void enterLte(@NotNull CampbellParser.LteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lte}
	 * labeled alternative in {@link CampbellParser#expr0}.
	 * @param ctx the parse tree
	 */
	void exitLte(@NotNull CampbellParser.LteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eq}
	 * labeled alternative in {@link CampbellParser#expr0}.
	 * @param ctx the parse tree
	 */
	void enterEq(@NotNull CampbellParser.EqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eq}
	 * labeled alternative in {@link CampbellParser#expr0}.
	 * @param ctx the parse tree
	 */
	void exitEq(@NotNull CampbellParser.EqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code gt}
	 * labeled alternative in {@link CampbellParser#expr0}.
	 * @param ctx the parse tree
	 */
	void enterGt(@NotNull CampbellParser.GtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code gt}
	 * labeled alternative in {@link CampbellParser#expr0}.
	 * @param ctx the parse tree
	 */
	void exitGt(@NotNull CampbellParser.GtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code add}
	 * labeled alternative in {@link CampbellParser#expr1}.
	 * @param ctx the parse tree
	 */
	void enterAdd(@NotNull CampbellParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code add}
	 * labeled alternative in {@link CampbellParser#expr1}.
	 * @param ctx the parse tree
	 */
	void exitAdd(@NotNull CampbellParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subtract}
	 * labeled alternative in {@link CampbellParser#expr1}.
	 * @param ctx the parse tree
	 */
	void enterSubtract(@NotNull CampbellParser.SubtractContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subtract}
	 * labeled alternative in {@link CampbellParser#expr1}.
	 * @param ctx the parse tree
	 */
	void exitSubtract(@NotNull CampbellParser.SubtractContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExpr1}
	 * labeled alternative in {@link CampbellParser#expr1}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpr1(@NotNull CampbellParser.SimpleExpr1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExpr1}
	 * labeled alternative in {@link CampbellParser#expr1}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpr1(@NotNull CampbellParser.SimpleExpr1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code lsh}
	 * labeled alternative in {@link CampbellParser#expr2}.
	 * @param ctx the parse tree
	 */
	void enterLsh(@NotNull CampbellParser.LshContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lsh}
	 * labeled alternative in {@link CampbellParser#expr2}.
	 * @param ctx the parse tree
	 */
	void exitLsh(@NotNull CampbellParser.LshContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rsh}
	 * labeled alternative in {@link CampbellParser#expr2}.
	 * @param ctx the parse tree
	 */
	void enterRsh(@NotNull CampbellParser.RshContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rsh}
	 * labeled alternative in {@link CampbellParser#expr2}.
	 * @param ctx the parse tree
	 */
	void exitRsh(@NotNull CampbellParser.RshContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExpr2}
	 * labeled alternative in {@link CampbellParser#expr2}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpr2(@NotNull CampbellParser.SimpleExpr2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExpr2}
	 * labeled alternative in {@link CampbellParser#expr2}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpr2(@NotNull CampbellParser.SimpleExpr2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code divide}
	 * labeled alternative in {@link CampbellParser#expr2}.
	 * @param ctx the parse tree
	 */
	void enterDivide(@NotNull CampbellParser.DivideContext ctx);
	/**
	 * Exit a parse tree produced by the {@code divide}
	 * labeled alternative in {@link CampbellParser#expr2}.
	 * @param ctx the parse tree
	 */
	void exitDivide(@NotNull CampbellParser.DivideContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiply}
	 * labeled alternative in {@link CampbellParser#expr2}.
	 * @param ctx the parse tree
	 */
	void enterMultiply(@NotNull CampbellParser.MultiplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiply}
	 * labeled alternative in {@link CampbellParser#expr2}.
	 * @param ctx the parse tree
	 */
	void exitMultiply(@NotNull CampbellParser.MultiplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code modulo}
	 * labeled alternative in {@link CampbellParser#expr2}.
	 * @param ctx the parse tree
	 */
	void enterModulo(@NotNull CampbellParser.ModuloContext ctx);
	/**
	 * Exit a parse tree produced by the {@code modulo}
	 * labeled alternative in {@link CampbellParser#expr2}.
	 * @param ctx the parse tree
	 */
	void exitModulo(@NotNull CampbellParser.ModuloContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negate}
	 * labeled alternative in {@link CampbellParser#expr3}.
	 * @param ctx the parse tree
	 */
	void enterNegate(@NotNull CampbellParser.NegateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negate}
	 * labeled alternative in {@link CampbellParser#expr3}.
	 * @param ctx the parse tree
	 */
	void exitNegate(@NotNull CampbellParser.NegateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExpr3}
	 * labeled alternative in {@link CampbellParser#expr3}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpr3(@NotNull CampbellParser.SimpleExpr3Context ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExpr3}
	 * labeled alternative in {@link CampbellParser#expr3}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpr3(@NotNull CampbellParser.SimpleExpr3Context ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link CampbellParser#expr4}.
	 * @param ctx the parse tree
	 */
	void enterInt(@NotNull CampbellParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link CampbellParser#expr4}.
	 * @param ctx the parse tree
	 */
	void exitInt(@NotNull CampbellParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link CampbellParser#expr4}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(@NotNull CampbellParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link CampbellParser#expr4}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(@NotNull CampbellParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link CampbellParser#expr4}.
	 * @param ctx the parse tree
	 */
	void enterId(@NotNull CampbellParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link CampbellParser#expr4}.
	 * @param ctx the parse tree
	 */
	void exitId(@NotNull CampbellParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paren}
	 * labeled alternative in {@link CampbellParser#expr4}.
	 * @param ctx the parse tree
	 */
	void enterParen(@NotNull CampbellParser.ParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paren}
	 * labeled alternative in {@link CampbellParser#expr4}.
	 * @param ctx the parse tree
	 */
	void exitParen(@NotNull CampbellParser.ParenContext ctx);
	/**
	 * Enter a parse tree produced by {@link CampbellParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull CampbellParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CampbellParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull CampbellParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classNameClass}
	 * labeled alternative in {@link CampbellParser#className}.
	 * @param ctx the parse tree
	 */
	void enterClassNameClass(@NotNull CampbellParser.ClassNameClassContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classNameClass}
	 * labeled alternative in {@link CampbellParser#className}.
	 * @param ctx the parse tree
	 */
	void exitClassNameClass(@NotNull CampbellParser.ClassNameClassContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classNameFunc}
	 * labeled alternative in {@link CampbellParser#className}.
	 * @param ctx the parse tree
	 */
	void enterClassNameFunc(@NotNull CampbellParser.ClassNameFuncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classNameFunc}
	 * labeled alternative in {@link CampbellParser#className}.
	 * @param ctx the parse tree
	 */
	void exitClassNameFunc(@NotNull CampbellParser.ClassNameFuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link CampbellParser#classList}.
	 * @param ctx the parse tree
	 */
	void enterClassList(@NotNull CampbellParser.ClassListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CampbellParser#classList}.
	 * @param ctx the parse tree
	 */
	void exitClassList(@NotNull CampbellParser.ClassListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code call}
	 * labeled alternative in {@link CampbellParser#exprAddon}.
	 * @param ctx the parse tree
	 */
	void enterCall(@NotNull CampbellParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code call}
	 * labeled alternative in {@link CampbellParser#exprAddon}.
	 * @param ctx the parse tree
	 */
	void exitCall(@NotNull CampbellParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code get}
	 * labeled alternative in {@link CampbellParser#exprAddon}.
	 * @param ctx the parse tree
	 */
	void enterGet(@NotNull CampbellParser.GetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code get}
	 * labeled alternative in {@link CampbellParser#exprAddon}.
	 * @param ctx the parse tree
	 */
	void exitGet(@NotNull CampbellParser.GetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code true}
	 * labeled alternative in {@link CampbellParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterTrue(@NotNull CampbellParser.TrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code true}
	 * labeled alternative in {@link CampbellParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitTrue(@NotNull CampbellParser.TrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code false}
	 * labeled alternative in {@link CampbellParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterFalse(@NotNull CampbellParser.FalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code false}
	 * labeled alternative in {@link CampbellParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitFalse(@NotNull CampbellParser.FalseContext ctx);
}