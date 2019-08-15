import Antlr.GoproveBaseVisitor;
import Antlr.GoproveParser;
import Expressions.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionVisitor extends GoproveBaseVisitor<ProveFunction> {
    private class ParameterVisitor extends GoproveBaseVisitor<List<OperandName>> {
        @Override
        public List<OperandName> visitParameters(GoproveParser.ParametersContext ctx) {
            if (ctx.parameterList() != null) {
                List<OperandName> list = new ArrayList<>();
                ctx.parameterList().parameterDecl().forEach(p -> {
                    if (p.identifierList() != null) {
                        p.identifierList()
                                .IDENTIFIER()
                                .forEach(i -> list.add(new OperandName(i.getText(), p.type().getText())));
                    } else {
                        throw new RuntimeException("Unexpected parameter format (no variable name)");
                    }
                });
                return list;
            }
            return new ArrayList<>();
        }
    }

    private class BlockVisitor extends GoproveBaseVisitor<List<CodeBlock>> {
        @Override
        public List<CodeBlock> visitBlock(GoproveParser.BlockContext ctx) {
            List<CodeBlock> list = new ArrayList<>();
            StatementVisitor visitor = new StatementVisitor();
            ctx.statementList().statement().forEach(s -> list.add(s.accept(visitor)));
            return list;
        }
    }

    private class StatementVisitor extends GoproveBaseVisitor<CodeBlock> {
        @Override
        public CodeBlock visitAssignment(GoproveParser.AssignmentContext ctx) {
            ExpressionVisitor expressionVisitor = new ExpressionVisitor();
            return new AssignmentBlock(ctx.start.getLine(),
                    ctx.expressionList(0)
                            .children.stream()
                            .map(c -> c.accept(expressionVisitor))
                            .collect(Collectors.toList()),
                    ctx.expressionList(1).children
                            .stream()
                            .map(c -> c.accept(expressionVisitor))
                            .collect(Collectors.toList()),
                    ctx.assign_op().getText());
        }

        @Override
        public CodeBlock visitForStmt(GoproveParser.ForStmtContext ctx) {
            Expression condition = null;
            if (ctx.expression() != null) {
                condition = ctx.expression().accept(new ExpressionVisitor());
            }
            List<CodeBlock> body = ctx.block().accept(new BlockVisitor());
            Expression invariant = null;
            if (ctx.loopInv() != null) {
                invariant = ctx.loopInv().expression().accept(new ExpressionVisitor());
            }
            return new LoopBlock(ctx.start.getLine(), condition, body, invariant);
        }

        @Override
        public CodeBlock visitReturnStmt(GoproveParser.ReturnStmtContext ctx) {
            return new ReturnBlock(ctx.start.getLine());
        }

        @Override
        public CodeBlock visitAssertStatement(GoproveParser.AssertStatementContext ctx) {
            return new AssertBlock(ctx.start.getLine(), ctx.expression().accept(new ExpressionVisitor()));
        }
    }

    @Override
    public ProveFunction visitProveFunctionDecl(GoproveParser.ProveFunctionDeclContext ctx) {
        List<OperandName> params = ctx.function().signature().parameters().accept(new ParameterVisitor());
        if (ctx.function().signature().result() != null) {
            GoproveParser.ResultContext resultContext = ctx.function().signature().result();
            if (resultContext.parameters() != null) {
                // List<String> params2 = resultContext.parameters().accept(new ParameterVisitor());
                // list.addAll(params2);
            } else if (resultContext.type() != null) {
                // list.add(resultContext.type().getText());
            }
        }
        Expression precondition = null, postcondition = null;
        ExpressionVisitor expressionVisitor = new ExpressionVisitor();
        for (int i = 0; i < ctx.children.size(); i++) {
            if (ctx.children.get(i) instanceof TerminalNode) {
                TerminalNode node = (TerminalNode) ctx.children.get(i);
                if (node.getSymbol().getText().equals("pre")) {
                    precondition = ctx.children.get(i + 1).accept(expressionVisitor);
                }

                if (node.getSymbol().getText().equals("post")) {
                    postcondition = ctx.children.get(i + 1).accept(expressionVisitor);
                }
            }
        }
        if (precondition == null) {
            precondition = new BinaryExpression(new Literal("1"), new Literal("1"), "==");
        }
        if (postcondition == null) {
            postcondition = new BinaryExpression(new Literal("1"), new Literal("1"), "==");
        }
        // TODO: add args and returns
        return new ProveFunction(ctx.function().block().accept(new BlockVisitor()), params, null, precondition, postcondition);
    }
}
