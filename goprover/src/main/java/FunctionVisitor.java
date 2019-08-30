import Antlr.GoproveBaseVisitor;
import Antlr.GoproveParser;
import Exceptions.UnimplementedException;
import Expressions.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionVisitor extends GoproveBaseVisitor<ProveFunction> {

    private ProveContext proveContext;
    public FunctionVisitor(ProveContext proveContext) {
        this.proveContext = proveContext;
    }

    private class ReturnVisitor extends GoproveBaseVisitor<List<OperandName>> {
        @Override
        public List<OperandName> visitResult(GoproveParser.ResultContext ctx) {
            if (ctx.parameters() == null) {
                throw new RuntimeException("Unnamed return parameters are not supported!");
            }
            if (ctx.parameters().parameterList() == null) {
                return new ArrayList<>();
            }
            ArrayList<OperandName> list = new ArrayList<>();
            List<GoproveParser.ParameterDeclContext> parameterDecl = ctx.parameters().parameterList().parameterDecl();

            for (GoproveParser.ParameterDeclContext parameterDeclContext : parameterDecl) {
                if (parameterDeclContext.identifierList() == null) {
                    throw new RuntimeException("Unnamed return parameters are not supported!");
                }
                String t = parameterDeclContext.type().getText();
                for (TerminalNode node : parameterDeclContext.identifierList().IDENTIFIER()) {
                    list.add(new OperandName(node.getText(), t));
                }
            }
            return list;
        }
    }

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
                        throw new RuntimeException("Unexpected parameter format (no variable name)!");
                    }
                });
                return list;
            }
            return new ArrayList<>();
        }
    }

    private class BlockVisitor extends GoproveBaseVisitor<List<CodeBlock>> {
        private Map<String, OperandName> localDeclarationTable = new HashMap<>();
        private ProveContext proveContext;
        public BlockVisitor(ProveContext proveContext) {
            this.proveContext = proveContext;
        }
        @Override
        public List<CodeBlock> visitBlock(GoproveParser.BlockContext ctx) {
            List<CodeBlock> list = new ArrayList<>();
            StatementVisitor visitor = new StatementVisitor(proveContext, localDeclarationTable);
            ctx.statementList().statement().forEach(s -> list.add(s.accept(visitor)));
            localDeclarationTable.forEach((name, _operandName) -> proveContext.undeclareVariable(name));
            return list;
        }
    }

    private class StatementVisitor extends GoproveBaseVisitor<CodeBlock> {

        private ProveContext proveContext;
        private Map<String, OperandName> localDeclarationTable;

        public StatementVisitor(ProveContext proveContext, Map<String, OperandName> localDeclarationTable) {
            this.proveContext = proveContext;
            this.localDeclarationTable = localDeclarationTable;
        }

        @Override
        public CodeBlock visitAssignment(GoproveParser.AssignmentContext ctx) {
            ExpressionVisitor expressionVisitor = new ExpressionVisitor();
            Stream<Expression> left = ctx.expressionList(0)
                    .children.stream()
                    .map(c -> {
                        Expression e = c.accept(expressionVisitor);
                        // Check for use of undeclared variables
                        e.getOperands().forEach(op -> proveContext.getVariable(op.getName()));
                        return e;
                    });
            Stream<Expression> right = ctx.expressionList(1)
                    .children.stream()
                    .map(c -> {
                        Expression e = c.accept(expressionVisitor);
                        // Check for use of undeclared variables
                        e.getOperands().forEach(op -> proveContext.getVariable(op.getName()));
                        return e;
                    });
            return new AssignmentBlock(
                    ctx.start.getLine(),
                    left.collect(Collectors.toList()),
                    right.collect(Collectors.toList()),
                    ctx.assign_op().getText()
            );
        }

        @Override
        public CodeBlock visitForStmt(GoproveParser.ForStmtContext ctx) {
            Expression condition = null;
            if (ctx.expression() != null) {
                condition = ctx.expression().accept(new ExpressionVisitor());
            }
            List<CodeBlock> body = ctx.block().accept(new BlockVisitor(proveContext));
            Expression invariant = new BinaryExpression(new Literal("1"), new Literal("1"), "==");
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

        @Override
        public CodeBlock visitDeclaration(GoproveParser.DeclarationContext ctx) {
            // TODO: Implement declaration
            throw new UnimplementedException();
            /*
            proveContext.declareVariable();
            localDeclarationTable.put();
            return new EmptyBlock(ctx.start.getLine());
            */
        }
    }

    @Override
    public ProveFunction visitProveFunctionDecl(GoproveParser.ProveFunctionDeclContext ctx) {
        List<OperandName> params = ctx.function().signature().parameters().accept(new ParameterVisitor());
        List<OperandName> returns;
        if (ctx.function().signature().result() != null) {
            returns = ctx.function().signature().result().accept(new ReturnVisitor());
        } else {
            returns = new ArrayList<>();
        }
//        if (ctx.function().signature().result() != null) {
//            GoproveParser.ResultContext resultContext = ctx.function().signature().result();
//            if (resultContext.parameters() != null) {
//                // List<String> params2 = resultContext.parameters().accept(new ParameterVisitor());
//                // list.addAll(params2);
//            } else if (resultContext.type() != null) {
//                // list.add(resultContext.type().getText());
//            }
//        }
        params.forEach(proveContext::declareVariable);
        returns.forEach(proveContext::declareVariable);
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
        // TODO: add returns
        proveContext.create(precondition, postcondition, ctx.function().block().accept(new BlockVisitor(proveContext)), params);
        return new ProveFunction(ctx.function().block().accept(new BlockVisitor(proveContext)), params, null, precondition, postcondition);
    }
}
