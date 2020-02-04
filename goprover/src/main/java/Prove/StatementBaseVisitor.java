package Prove;

import Antlr.GoproveBaseVisitor;
import Antlr.GoproveParser;
import Exceptions.UnimplementedException;

import java.util.List;

public class StatementBaseVisitor extends GoproveBaseVisitor<List<Statement>> {

    @Override
    public List<Statement> visitExpressionStmt(GoproveParser.ExpressionStmtContext ctx) {
        throw new UnimplementedException();
    }

    @Override
    public List<Statement> visitSendStmt(GoproveParser.SendStmtContext ctx) {
        throw new UnimplementedException();
    }

    @Override
    public List<Statement> visitIncDecStmt(GoproveParser.IncDecStmtContext ctx) {
        throw new UnimplementedException();
    }

    @Override
    public List<Statement> visitShortVarDecl(GoproveParser.ShortVarDeclContext ctx) {
        throw new UnimplementedException();
    }

    @Override
    public List<Statement> visitLabeledStmt(GoproveParser.LabeledStmtContext ctx) {
        throw new UnimplementedException();
    }

    @Override
    public List<Statement> visitBreakStmt(GoproveParser.BreakStmtContext ctx) {
        throw new UnimplementedException();
    }

    @Override
    public List<Statement> visitContinueStmt(GoproveParser.ContinueStmtContext ctx) {
        throw new UnimplementedException();
    }

    @Override
    public List<Statement> visitGotoStmt(GoproveParser.GotoStmtContext ctx) {
        throw new UnimplementedException();
    }

    @Override
    public List<Statement> visitFallthroughStmt(GoproveParser.FallthroughStmtContext ctx) {
        throw new UnimplementedException();
    }

    @Override
    public List<Statement> visitDeferStmt(GoproveParser.DeferStmtContext ctx) {
        throw new UnimplementedException();
    }

    @Override
    public List<Statement> visitSwitchStmt(GoproveParser.SwitchStmtContext ctx) {
        throw new UnimplementedException();
    }

    @Override
    public List<Statement> visitSelectStmt(GoproveParser.SelectStmtContext ctx) {
        throw new UnimplementedException();
    }

    @Override
    public List<Statement> visitGoStmt(GoproveParser.GoStmtContext ctx) {
        throw new UnimplementedException();
    }
}
