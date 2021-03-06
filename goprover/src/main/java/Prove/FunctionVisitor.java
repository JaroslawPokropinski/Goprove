package Prove;

import Antlr.GoproveBaseVisitor;
import Antlr.GoproveParser;
import Exceptions.UnimplementedException;
import Expressions.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionVisitor extends GoproveBaseVisitor<Void> {

    private ProveContext proveContext;
    public FunctionVisitor(ProveContext proveContext) {
        this.proveContext = proveContext;
    }

    private static class ReturnVisitor extends GoproveBaseVisitor<List<OperandName>> {
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

    private static class ParameterVisitor extends GoproveBaseVisitor<List<OperandName>> {
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

    private class BlockVisitor extends StatementBaseVisitor {
        private Map<String, OperandName> localDeclarationTable = new HashMap<>();
        private ProveContext proveContext;
        public BlockVisitor(ProveContext proveContext) {
            this.proveContext = proveContext;
        }
        @Override
        public List<Statement> visitBlock(GoproveParser.BlockContext ctx) {
            List<Statement> list = new ArrayList<>();
            StatementVisitor visitor = new StatementVisitor(proveContext, localDeclarationTable);
            ctx.statementList().statement().forEach(s -> list.add(s.accept(visitor)));
            localDeclarationTable.forEach((name, _operandName) -> proveContext.undeclareVariable(name));
            return list;
        }
    }

    private class StatementVisitor extends GoproveBaseVisitor<Statement> {

        private ProveContext proveContext;
        private Map<String, OperandName> localDeclarationTable;

        public StatementVisitor(ProveContext proveContext, Map<String, OperandName> localDeclarationTable) {
            this.proveContext = proveContext;
            this.localDeclarationTable = localDeclarationTable;
        }

        @Override
        public Statement visitAssignment(GoproveParser.AssignmentContext ctx) {
            ExpressionVisitor expressionVisitor = new ExpressionVisitor();
            Stream<Expression> left = ctx.expressionList(0)
                    .children.stream()
                    .map(c -> {
                        Expression e = c.accept(expressionVisitor);
                        // Check for use of undeclared variables
                        e.checkDeclaration(proveContext);
                        return e;
                    });
            Stream<Expression> right = ctx.expressionList(1)
                    .children.stream()
                    .map(c -> {
                        Expression e = c.accept(expressionVisitor);
                        // Check for use of undeclared variables
                        e.checkDeclaration(proveContext);
                        return e;
                    });
            return new AssignmentStatement(
                    ctx.start.getLine(),
                    left.collect(Collectors.toList()),
                    right.collect(Collectors.toList()),
                    ctx.assign_op().getText()
            );
        }

        @Override
        public Statement visitForStmt(GoproveParser.ForStmtContext ctx) {
            // e.getOperands().forEach(op -> proveContext.getVariable(op.getName()));
            Expression invariant = new BinaryExpression(new Literal("0"), new Literal("0"), "==");
            if (ctx.loopInv() != null) {
                invariant = ctx.loopInv().expression().accept(new ExpressionVisitor());
                // Check for use of undeclared variables
                invariant.checkDeclaration(proveContext);
            }
            Expression variant = Literal.zero;
            if (ctx.loopVar() != null) {
                variant = ctx.loopVar().expression().accept(new ExpressionVisitor());
                // Check for use of undeclared variables
                variant.checkDeclaration(proveContext);
            }


            if (ctx.expression() == null) {
                // TODO: handle for statements with other structure
                throw new UnimplementedException();
            }
            Expression condition = ctx.expression().accept(new ExpressionVisitor());
            condition.checkDeclaration(proveContext);
            List<Statement> body = ctx.block().accept(new BlockVisitor(proveContext));

            return new LoopStatement(ctx.start.getLine(), condition, body, invariant, variant);
        }

        @Override
        public Statement visitReturnStmt(GoproveParser.ReturnStmtContext ctx) {
            return new ReturnStatement(ctx.start.getLine());
        }

        @Override
        public Statement visitAssertStatement(GoproveParser.AssertStatementContext ctx) {
            return new AssertStatement(ctx.start.getLine(), ctx.expression().accept(new ExpressionVisitor()));
        }

        @Override
        public Statement visitDeclaration(GoproveParser.DeclarationContext ctx) {
            if (ctx.varDecl() != null) {
                List<TerminalNode>list = ctx.varDecl().varSpec().identifierList().IDENTIFIER();
                List<Expression> operandNames = new ArrayList<>(list.size());
                for (TerminalNode node : list) {
                    OperandName op = new OperandName(node.getText(), ctx.varDecl().varSpec().type().getText());
                    proveContext.declareVariable(op);
                    localDeclarationTable.put(op.getName(), op);
                    operandNames.add(op);
                }
                if (ctx.varDecl().varSpec().expressionList() != null) {
                    return new AssignmentStatement(
                            ctx.start.getLine(),
                            operandNames,
                            ctx.varDecl().varSpec().expressionList().expression().stream().map(c -> c.accept(new ExpressionVisitor())).collect(Collectors.toList()),
                            "="
                    );
                }
                return new EmptyStatement(ctx.start.getLine());
            }
            // TODO: Implement declaration of constants etc
            throw new UnimplementedException();
            //*/
        }

        @Override
        public Statement visitIfStmt(GoproveParser.IfStmtContext ctx) {
            if (ctx.simpleStmt() != null) {
                throw new RuntimeException("Statement preceding conditionals are not supported");
            }
            // else
            if (ctx.block(1) != null) {
                return new IfStatement(ctx.start.getLine(), ctx.expression().accept(new ExpressionVisitor()), ctx.block(0).accept(new BlockVisitor(proveContext)), ctx.block(1).accept(new BlockVisitor(proveContext)));
            }
            // else if
            if (ctx.ifStmt() != null) {
                return new IfStatement(ctx.start.getLine(),
                        ctx.expression().accept(new ExpressionVisitor()),
                        ctx.block(0).accept(new BlockVisitor(proveContext)),
                        Collections.singletonList(ctx.ifStmt().accept(new StatementVisitor(proveContext, localDeclarationTable)))
                );
            }

            return new IfStatement(ctx.start.getLine(), ctx.expression().accept(new ExpressionVisitor()), ctx.block(0).accept(new BlockVisitor(proveContext)));
        }
    }

    @Override
    public Void visitProveFunctionDecl(GoproveParser.ProveFunctionDeclContext ctx) {
        List<OperandName> params = ctx.function().signature().parameters().accept(new ParameterVisitor());
        List<OperandName> returns;
        if (ctx.function().signature().result() != null) {
            returns = ctx.function().signature().result().accept(new ReturnVisitor());
        } else {
            returns = new ArrayList<>();
        }

        params.forEach(proveContext::declareVariable);
        returns.forEach(proveContext::declareVariable);
        params.forEach(p -> proveContext.declareVariable(new OperandName(String.format("%s'old", p.getName()), p.getType())));

        Expression precondition = null, postcondition = null;
        ExpressionVisitor expressionVisitor = new ExpressionVisitor();
        for (int i = 0; i < ctx.children.size(); i++) {
            if (ctx.children.get(i) instanceof TerminalNode) {
                TerminalNode node = (TerminalNode) ctx.children.get(i);
                if (node.getSymbol().getText().equals("pre")) {
                    precondition = ctx.children.get(i + 1).accept(expressionVisitor);
                    // Check for use of undeclared variables
                    precondition.checkDeclaration(proveContext);
                }

                if (node.getSymbol().getText().equals("post")) {
                    postcondition = ctx.children.get(i + 1).accept(expressionVisitor);
                    // Check for use of undeclared variables
                    postcondition.checkDeclaration(proveContext);
                }
            }
        }
        if (precondition == null) {
            precondition = new BinaryExpression(new Literal("1"), new Literal("1"), "==");
        }
        if (postcondition == null) {
            postcondition = new BinaryExpression(new Literal("1"), new Literal("1"), "==");
        }
        proveContext.create(precondition, postcondition, ctx.function().block().accept(new BlockVisitor(proveContext)), params);
        return null;
    }
}
