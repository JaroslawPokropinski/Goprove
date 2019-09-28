// Generated from D:/Programming ssd/Praca dyplomowa/goprover/src/main/antlr4\Goprove.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GoproveParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GoproveVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GoproveParser#sourceFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSourceFile(GoproveParser.SourceFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#packageClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageClause(GoproveParser.PackageClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#importDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDecl(GoproveParser.ImportDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#importSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportSpec(GoproveParser.ImportSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#importPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportPath(GoproveParser.ImportPathContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#topLevelDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopLevelDecl(GoproveParser.TopLevelDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(GoproveParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#constDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDecl(GoproveParser.ConstDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#constSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstSpec(GoproveParser.ConstSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#identifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierList(GoproveParser.IdentifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(GoproveParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#typeDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDecl(GoproveParser.TypeDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#typeSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSpec(GoproveParser.TypeSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(GoproveParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(GoproveParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#methodDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDecl(GoproveParser.MethodDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#receiver}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReceiver(GoproveParser.ReceiverContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(GoproveParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#varSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarSpec(GoproveParser.VarSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(GoproveParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#statementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementList(GoproveParser.StatementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(GoproveParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#simpleStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleStmt(GoproveParser.SimpleStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#expressionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStmt(GoproveParser.ExpressionStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#sendStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSendStmt(GoproveParser.SendStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#incDecStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncDecStmt(GoproveParser.IncDecStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(GoproveParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#assign_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_op(GoproveParser.Assign_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#shortVarDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortVarDecl(GoproveParser.ShortVarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#emptyStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStmt(GoproveParser.EmptyStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#labeledStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeledStmt(GoproveParser.LabeledStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(GoproveParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#breakStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmt(GoproveParser.BreakStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#continueStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStmt(GoproveParser.ContinueStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#gotoStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGotoStmt(GoproveParser.GotoStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#fallthroughStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFallthroughStmt(GoproveParser.FallthroughStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#deferStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeferStmt(GoproveParser.DeferStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(GoproveParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#switchStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStmt(GoproveParser.SwitchStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#exprSwitchStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSwitchStmt(GoproveParser.ExprSwitchStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#exprCaseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprCaseClause(GoproveParser.ExprCaseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#exprSwitchCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSwitchCase(GoproveParser.ExprSwitchCaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#typeSwitchStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSwitchStmt(GoproveParser.TypeSwitchStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#typeSwitchGuard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSwitchGuard(GoproveParser.TypeSwitchGuardContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#typeCaseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeCaseClause(GoproveParser.TypeCaseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#typeSwitchCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSwitchCase(GoproveParser.TypeSwitchCaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#typeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeList(GoproveParser.TypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#selectStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectStmt(GoproveParser.SelectStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#commClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommClause(GoproveParser.CommClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#commCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommCase(GoproveParser.CommCaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#recvStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecvStmt(GoproveParser.RecvStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(GoproveParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#forClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForClause(GoproveParser.ForClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#rangeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeClause(GoproveParser.RangeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#goStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoStmt(GoproveParser.GoStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(GoproveParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(GoproveParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#typeLit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeLit(GoproveParser.TypeLitContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(GoproveParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#arrayLength}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLength(GoproveParser.ArrayLengthContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#elementType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementType(GoproveParser.ElementTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#pointerType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointerType(GoproveParser.PointerTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#interfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceType(GoproveParser.InterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#sliceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSliceType(GoproveParser.SliceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#mapType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapType(GoproveParser.MapTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#channelType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannelType(GoproveParser.ChannelTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#methodSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodSpec(GoproveParser.MethodSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#functionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionType(GoproveParser.FunctionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#signature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignature(GoproveParser.SignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#result}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResult(GoproveParser.ResultContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(GoproveParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(GoproveParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#parameterDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDecl(GoproveParser.ParameterDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperand(GoproveParser.OperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(GoproveParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#basicLit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicLit(GoproveParser.BasicLitContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#operandName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperandName(GoproveParser.OperandNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#qualifiedIdent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedIdent(GoproveParser.QualifiedIdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#compositeLit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompositeLit(GoproveParser.CompositeLitContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#literalType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralType(GoproveParser.LiteralTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#literalValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralValue(GoproveParser.LiteralValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#elementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementList(GoproveParser.ElementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#keyedElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyedElement(GoproveParser.KeyedElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKey(GoproveParser.KeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(GoproveParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#structType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructType(GoproveParser.StructTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#fieldDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDecl(GoproveParser.FieldDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#anonymousField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnonymousField(GoproveParser.AnonymousFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#functionLit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionLit(GoproveParser.FunctionLitContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpr(GoproveParser.PrimaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#proveOperand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProveOperand(GoproveParser.ProveOperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelector(GoproveParser.SelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex(GoproveParser.IndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#slice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlice(GoproveParser.SliceContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#typeAssertion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeAssertion(GoproveParser.TypeAssertionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(GoproveParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#methodExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodExpr(GoproveParser.MethodExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#receiverType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReceiverType(GoproveParser.ReceiverTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(GoproveParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(GoproveParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#conversion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConversion(GoproveParser.ConversionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#eos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEos(GoproveParser.EosContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#proveFunctionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProveFunctionDecl(GoproveParser.ProveFunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#loopInv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopInv(GoproveParser.LoopInvContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#assertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertStatement(GoproveParser.AssertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#eqExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpression(GoproveParser.EqExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoproveParser#logExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogExpression(GoproveParser.LogExpressionContext ctx);
}