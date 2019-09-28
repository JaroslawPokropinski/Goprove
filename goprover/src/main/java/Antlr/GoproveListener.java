// Generated from D:/Programming ssd/Praca dyplomowa/goprover/src/main/antlr4\Goprove.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GoproveParser}.
 */
public interface GoproveListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GoproveParser#sourceFile}.
	 * @param ctx the parse tree
	 */
	void enterSourceFile(GoproveParser.SourceFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#sourceFile}.
	 * @param ctx the parse tree
	 */
	void exitSourceFile(GoproveParser.SourceFileContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#packageClause}.
	 * @param ctx the parse tree
	 */
	void enterPackageClause(GoproveParser.PackageClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#packageClause}.
	 * @param ctx the parse tree
	 */
	void exitPackageClause(GoproveParser.PackageClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#importDecl}.
	 * @param ctx the parse tree
	 */
	void enterImportDecl(GoproveParser.ImportDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#importDecl}.
	 * @param ctx the parse tree
	 */
	void exitImportDecl(GoproveParser.ImportDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#importSpec}.
	 * @param ctx the parse tree
	 */
	void enterImportSpec(GoproveParser.ImportSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#importSpec}.
	 * @param ctx the parse tree
	 */
	void exitImportSpec(GoproveParser.ImportSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#importPath}.
	 * @param ctx the parse tree
	 */
	void enterImportPath(GoproveParser.ImportPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#importPath}.
	 * @param ctx the parse tree
	 */
	void exitImportPath(GoproveParser.ImportPathContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#topLevelDecl}.
	 * @param ctx the parse tree
	 */
	void enterTopLevelDecl(GoproveParser.TopLevelDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#topLevelDecl}.
	 * @param ctx the parse tree
	 */
	void exitTopLevelDecl(GoproveParser.TopLevelDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(GoproveParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(GoproveParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#constDecl}.
	 * @param ctx the parse tree
	 */
	void enterConstDecl(GoproveParser.ConstDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#constDecl}.
	 * @param ctx the parse tree
	 */
	void exitConstDecl(GoproveParser.ConstDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#constSpec}.
	 * @param ctx the parse tree
	 */
	void enterConstSpec(GoproveParser.ConstSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#constSpec}.
	 * @param ctx the parse tree
	 */
	void exitConstSpec(GoproveParser.ConstSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierList(GoproveParser.IdentifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierList(GoproveParser.IdentifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(GoproveParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(GoproveParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#typeDecl}.
	 * @param ctx the parse tree
	 */
	void enterTypeDecl(GoproveParser.TypeDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#typeDecl}.
	 * @param ctx the parse tree
	 */
	void exitTypeDecl(GoproveParser.TypeDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#typeSpec}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpec(GoproveParser.TypeSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#typeSpec}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpec(GoproveParser.TypeSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(GoproveParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(GoproveParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(GoproveParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(GoproveParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void enterMethodDecl(GoproveParser.MethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void exitMethodDecl(GoproveParser.MethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#receiver}.
	 * @param ctx the parse tree
	 */
	void enterReceiver(GoproveParser.ReceiverContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#receiver}.
	 * @param ctx the parse tree
	 */
	void exitReceiver(GoproveParser.ReceiverContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(GoproveParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(GoproveParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#varSpec}.
	 * @param ctx the parse tree
	 */
	void enterVarSpec(GoproveParser.VarSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#varSpec}.
	 * @param ctx the parse tree
	 */
	void exitVarSpec(GoproveParser.VarSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(GoproveParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(GoproveParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#statementList}.
	 * @param ctx the parse tree
	 */
	void enterStatementList(GoproveParser.StatementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#statementList}.
	 * @param ctx the parse tree
	 */
	void exitStatementList(GoproveParser.StatementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(GoproveParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(GoproveParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#simpleStmt}.
	 * @param ctx the parse tree
	 */
	void enterSimpleStmt(GoproveParser.SimpleStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#simpleStmt}.
	 * @param ctx the parse tree
	 */
	void exitSimpleStmt(GoproveParser.SimpleStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#expressionStmt}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStmt(GoproveParser.ExpressionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#expressionStmt}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStmt(GoproveParser.ExpressionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#sendStmt}.
	 * @param ctx the parse tree
	 */
	void enterSendStmt(GoproveParser.SendStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#sendStmt}.
	 * @param ctx the parse tree
	 */
	void exitSendStmt(GoproveParser.SendStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#incDecStmt}.
	 * @param ctx the parse tree
	 */
	void enterIncDecStmt(GoproveParser.IncDecStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#incDecStmt}.
	 * @param ctx the parse tree
	 */
	void exitIncDecStmt(GoproveParser.IncDecStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(GoproveParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(GoproveParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#assign_op}.
	 * @param ctx the parse tree
	 */
	void enterAssign_op(GoproveParser.Assign_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#assign_op}.
	 * @param ctx the parse tree
	 */
	void exitAssign_op(GoproveParser.Assign_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#shortVarDecl}.
	 * @param ctx the parse tree
	 */
	void enterShortVarDecl(GoproveParser.ShortVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#shortVarDecl}.
	 * @param ctx the parse tree
	 */
	void exitShortVarDecl(GoproveParser.ShortVarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#emptyStmt}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStmt(GoproveParser.EmptyStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#emptyStmt}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStmt(GoproveParser.EmptyStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#labeledStmt}.
	 * @param ctx the parse tree
	 */
	void enterLabeledStmt(GoproveParser.LabeledStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#labeledStmt}.
	 * @param ctx the parse tree
	 */
	void exitLabeledStmt(GoproveParser.LabeledStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(GoproveParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(GoproveParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#breakStmt}.
	 * @param ctx the parse tree
	 */
	void enterBreakStmt(GoproveParser.BreakStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#breakStmt}.
	 * @param ctx the parse tree
	 */
	void exitBreakStmt(GoproveParser.BreakStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#continueStmt}.
	 * @param ctx the parse tree
	 */
	void enterContinueStmt(GoproveParser.ContinueStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#continueStmt}.
	 * @param ctx the parse tree
	 */
	void exitContinueStmt(GoproveParser.ContinueStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#gotoStmt}.
	 * @param ctx the parse tree
	 */
	void enterGotoStmt(GoproveParser.GotoStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#gotoStmt}.
	 * @param ctx the parse tree
	 */
	void exitGotoStmt(GoproveParser.GotoStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#fallthroughStmt}.
	 * @param ctx the parse tree
	 */
	void enterFallthroughStmt(GoproveParser.FallthroughStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#fallthroughStmt}.
	 * @param ctx the parse tree
	 */
	void exitFallthroughStmt(GoproveParser.FallthroughStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#deferStmt}.
	 * @param ctx the parse tree
	 */
	void enterDeferStmt(GoproveParser.DeferStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#deferStmt}.
	 * @param ctx the parse tree
	 */
	void exitDeferStmt(GoproveParser.DeferStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(GoproveParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(GoproveParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#switchStmt}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStmt(GoproveParser.SwitchStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#switchStmt}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStmt(GoproveParser.SwitchStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#exprSwitchStmt}.
	 * @param ctx the parse tree
	 */
	void enterExprSwitchStmt(GoproveParser.ExprSwitchStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#exprSwitchStmt}.
	 * @param ctx the parse tree
	 */
	void exitExprSwitchStmt(GoproveParser.ExprSwitchStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#exprCaseClause}.
	 * @param ctx the parse tree
	 */
	void enterExprCaseClause(GoproveParser.ExprCaseClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#exprCaseClause}.
	 * @param ctx the parse tree
	 */
	void exitExprCaseClause(GoproveParser.ExprCaseClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#exprSwitchCase}.
	 * @param ctx the parse tree
	 */
	void enterExprSwitchCase(GoproveParser.ExprSwitchCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#exprSwitchCase}.
	 * @param ctx the parse tree
	 */
	void exitExprSwitchCase(GoproveParser.ExprSwitchCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#typeSwitchStmt}.
	 * @param ctx the parse tree
	 */
	void enterTypeSwitchStmt(GoproveParser.TypeSwitchStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#typeSwitchStmt}.
	 * @param ctx the parse tree
	 */
	void exitTypeSwitchStmt(GoproveParser.TypeSwitchStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#typeSwitchGuard}.
	 * @param ctx the parse tree
	 */
	void enterTypeSwitchGuard(GoproveParser.TypeSwitchGuardContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#typeSwitchGuard}.
	 * @param ctx the parse tree
	 */
	void exitTypeSwitchGuard(GoproveParser.TypeSwitchGuardContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#typeCaseClause}.
	 * @param ctx the parse tree
	 */
	void enterTypeCaseClause(GoproveParser.TypeCaseClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#typeCaseClause}.
	 * @param ctx the parse tree
	 */
	void exitTypeCaseClause(GoproveParser.TypeCaseClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#typeSwitchCase}.
	 * @param ctx the parse tree
	 */
	void enterTypeSwitchCase(GoproveParser.TypeSwitchCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#typeSwitchCase}.
	 * @param ctx the parse tree
	 */
	void exitTypeSwitchCase(GoproveParser.TypeSwitchCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#typeList}.
	 * @param ctx the parse tree
	 */
	void enterTypeList(GoproveParser.TypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#typeList}.
	 * @param ctx the parse tree
	 */
	void exitTypeList(GoproveParser.TypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#selectStmt}.
	 * @param ctx the parse tree
	 */
	void enterSelectStmt(GoproveParser.SelectStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#selectStmt}.
	 * @param ctx the parse tree
	 */
	void exitSelectStmt(GoproveParser.SelectStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#commClause}.
	 * @param ctx the parse tree
	 */
	void enterCommClause(GoproveParser.CommClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#commClause}.
	 * @param ctx the parse tree
	 */
	void exitCommClause(GoproveParser.CommClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#commCase}.
	 * @param ctx the parse tree
	 */
	void enterCommCase(GoproveParser.CommCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#commCase}.
	 * @param ctx the parse tree
	 */
	void exitCommCase(GoproveParser.CommCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#recvStmt}.
	 * @param ctx the parse tree
	 */
	void enterRecvStmt(GoproveParser.RecvStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#recvStmt}.
	 * @param ctx the parse tree
	 */
	void exitRecvStmt(GoproveParser.RecvStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(GoproveParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(GoproveParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#forClause}.
	 * @param ctx the parse tree
	 */
	void enterForClause(GoproveParser.ForClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#forClause}.
	 * @param ctx the parse tree
	 */
	void exitForClause(GoproveParser.ForClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#rangeClause}.
	 * @param ctx the parse tree
	 */
	void enterRangeClause(GoproveParser.RangeClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#rangeClause}.
	 * @param ctx the parse tree
	 */
	void exitRangeClause(GoproveParser.RangeClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#goStmt}.
	 * @param ctx the parse tree
	 */
	void enterGoStmt(GoproveParser.GoStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#goStmt}.
	 * @param ctx the parse tree
	 */
	void exitGoStmt(GoproveParser.GoStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(GoproveParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(GoproveParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(GoproveParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(GoproveParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#typeLit}.
	 * @param ctx the parse tree
	 */
	void enterTypeLit(GoproveParser.TypeLitContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#typeLit}.
	 * @param ctx the parse tree
	 */
	void exitTypeLit(GoproveParser.TypeLitContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(GoproveParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(GoproveParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#arrayLength}.
	 * @param ctx the parse tree
	 */
	void enterArrayLength(GoproveParser.ArrayLengthContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#arrayLength}.
	 * @param ctx the parse tree
	 */
	void exitArrayLength(GoproveParser.ArrayLengthContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#elementType}.
	 * @param ctx the parse tree
	 */
	void enterElementType(GoproveParser.ElementTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#elementType}.
	 * @param ctx the parse tree
	 */
	void exitElementType(GoproveParser.ElementTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#pointerType}.
	 * @param ctx the parse tree
	 */
	void enterPointerType(GoproveParser.PointerTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#pointerType}.
	 * @param ctx the parse tree
	 */
	void exitPointerType(GoproveParser.PointerTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#interfaceType}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceType(GoproveParser.InterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#interfaceType}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceType(GoproveParser.InterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#sliceType}.
	 * @param ctx the parse tree
	 */
	void enterSliceType(GoproveParser.SliceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#sliceType}.
	 * @param ctx the parse tree
	 */
	void exitSliceType(GoproveParser.SliceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#mapType}.
	 * @param ctx the parse tree
	 */
	void enterMapType(GoproveParser.MapTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#mapType}.
	 * @param ctx the parse tree
	 */
	void exitMapType(GoproveParser.MapTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#channelType}.
	 * @param ctx the parse tree
	 */
	void enterChannelType(GoproveParser.ChannelTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#channelType}.
	 * @param ctx the parse tree
	 */
	void exitChannelType(GoproveParser.ChannelTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#methodSpec}.
	 * @param ctx the parse tree
	 */
	void enterMethodSpec(GoproveParser.MethodSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#methodSpec}.
	 * @param ctx the parse tree
	 */
	void exitMethodSpec(GoproveParser.MethodSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#functionType}.
	 * @param ctx the parse tree
	 */
	void enterFunctionType(GoproveParser.FunctionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#functionType}.
	 * @param ctx the parse tree
	 */
	void exitFunctionType(GoproveParser.FunctionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#signature}.
	 * @param ctx the parse tree
	 */
	void enterSignature(GoproveParser.SignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#signature}.
	 * @param ctx the parse tree
	 */
	void exitSignature(GoproveParser.SignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#result}.
	 * @param ctx the parse tree
	 */
	void enterResult(GoproveParser.ResultContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#result}.
	 * @param ctx the parse tree
	 */
	void exitResult(GoproveParser.ResultContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(GoproveParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(GoproveParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(GoproveParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(GoproveParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#parameterDecl}.
	 * @param ctx the parse tree
	 */
	void enterParameterDecl(GoproveParser.ParameterDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#parameterDecl}.
	 * @param ctx the parse tree
	 */
	void exitParameterDecl(GoproveParser.ParameterDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(GoproveParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(GoproveParser.OperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(GoproveParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(GoproveParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#basicLit}.
	 * @param ctx the parse tree
	 */
	void enterBasicLit(GoproveParser.BasicLitContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#basicLit}.
	 * @param ctx the parse tree
	 */
	void exitBasicLit(GoproveParser.BasicLitContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#operandName}.
	 * @param ctx the parse tree
	 */
	void enterOperandName(GoproveParser.OperandNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#operandName}.
	 * @param ctx the parse tree
	 */
	void exitOperandName(GoproveParser.OperandNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#qualifiedIdent}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedIdent(GoproveParser.QualifiedIdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#qualifiedIdent}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedIdent(GoproveParser.QualifiedIdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#compositeLit}.
	 * @param ctx the parse tree
	 */
	void enterCompositeLit(GoproveParser.CompositeLitContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#compositeLit}.
	 * @param ctx the parse tree
	 */
	void exitCompositeLit(GoproveParser.CompositeLitContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#literalType}.
	 * @param ctx the parse tree
	 */
	void enterLiteralType(GoproveParser.LiteralTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#literalType}.
	 * @param ctx the parse tree
	 */
	void exitLiteralType(GoproveParser.LiteralTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#literalValue}.
	 * @param ctx the parse tree
	 */
	void enterLiteralValue(GoproveParser.LiteralValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#literalValue}.
	 * @param ctx the parse tree
	 */
	void exitLiteralValue(GoproveParser.LiteralValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#elementList}.
	 * @param ctx the parse tree
	 */
	void enterElementList(GoproveParser.ElementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#elementList}.
	 * @param ctx the parse tree
	 */
	void exitElementList(GoproveParser.ElementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#keyedElement}.
	 * @param ctx the parse tree
	 */
	void enterKeyedElement(GoproveParser.KeyedElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#keyedElement}.
	 * @param ctx the parse tree
	 */
	void exitKeyedElement(GoproveParser.KeyedElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#key}.
	 * @param ctx the parse tree
	 */
	void enterKey(GoproveParser.KeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#key}.
	 * @param ctx the parse tree
	 */
	void exitKey(GoproveParser.KeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(GoproveParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(GoproveParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#structType}.
	 * @param ctx the parse tree
	 */
	void enterStructType(GoproveParser.StructTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#structType}.
	 * @param ctx the parse tree
	 */
	void exitStructType(GoproveParser.StructTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void enterFieldDecl(GoproveParser.FieldDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void exitFieldDecl(GoproveParser.FieldDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#anonymousField}.
	 * @param ctx the parse tree
	 */
	void enterAnonymousField(GoproveParser.AnonymousFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#anonymousField}.
	 * @param ctx the parse tree
	 */
	void exitAnonymousField(GoproveParser.AnonymousFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#functionLit}.
	 * @param ctx the parse tree
	 */
	void enterFunctionLit(GoproveParser.FunctionLitContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#functionLit}.
	 * @param ctx the parse tree
	 */
	void exitFunctionLit(GoproveParser.FunctionLitContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpr(GoproveParser.PrimaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpr(GoproveParser.PrimaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#proveOperand}.
	 * @param ctx the parse tree
	 */
	void enterProveOperand(GoproveParser.ProveOperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#proveOperand}.
	 * @param ctx the parse tree
	 */
	void exitProveOperand(GoproveParser.ProveOperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#selector}.
	 * @param ctx the parse tree
	 */
	void enterSelector(GoproveParser.SelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#selector}.
	 * @param ctx the parse tree
	 */
	void exitSelector(GoproveParser.SelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#index}.
	 * @param ctx the parse tree
	 */
	void enterIndex(GoproveParser.IndexContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#index}.
	 * @param ctx the parse tree
	 */
	void exitIndex(GoproveParser.IndexContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#slice}.
	 * @param ctx the parse tree
	 */
	void enterSlice(GoproveParser.SliceContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#slice}.
	 * @param ctx the parse tree
	 */
	void exitSlice(GoproveParser.SliceContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#typeAssertion}.
	 * @param ctx the parse tree
	 */
	void enterTypeAssertion(GoproveParser.TypeAssertionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#typeAssertion}.
	 * @param ctx the parse tree
	 */
	void exitTypeAssertion(GoproveParser.TypeAssertionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(GoproveParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(GoproveParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#methodExpr}.
	 * @param ctx the parse tree
	 */
	void enterMethodExpr(GoproveParser.MethodExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#methodExpr}.
	 * @param ctx the parse tree
	 */
	void exitMethodExpr(GoproveParser.MethodExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#receiverType}.
	 * @param ctx the parse tree
	 */
	void enterReceiverType(GoproveParser.ReceiverTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#receiverType}.
	 * @param ctx the parse tree
	 */
	void exitReceiverType(GoproveParser.ReceiverTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(GoproveParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(GoproveParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(GoproveParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(GoproveParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#conversion}.
	 * @param ctx the parse tree
	 */
	void enterConversion(GoproveParser.ConversionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#conversion}.
	 * @param ctx the parse tree
	 */
	void exitConversion(GoproveParser.ConversionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#eos}.
	 * @param ctx the parse tree
	 */
	void enterEos(GoproveParser.EosContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#eos}.
	 * @param ctx the parse tree
	 */
	void exitEos(GoproveParser.EosContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#proveFunctionDecl}.
	 * @param ctx the parse tree
	 */
	void enterProveFunctionDecl(GoproveParser.ProveFunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#proveFunctionDecl}.
	 * @param ctx the parse tree
	 */
	void exitProveFunctionDecl(GoproveParser.ProveFunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#loopInv}.
	 * @param ctx the parse tree
	 */
	void enterLoopInv(GoproveParser.LoopInvContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#loopInv}.
	 * @param ctx the parse tree
	 */
	void exitLoopInv(GoproveParser.LoopInvContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#assertStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssertStatement(GoproveParser.AssertStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#assertStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssertStatement(GoproveParser.AssertStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#eqExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqExpression(GoproveParser.EqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#eqExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqExpression(GoproveParser.EqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoproveParser#logExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogExpression(GoproveParser.LogExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoproveParser#logExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogExpression(GoproveParser.LogExpressionContext ctx);
}