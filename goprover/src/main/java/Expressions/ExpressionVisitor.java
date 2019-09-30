package Expressions;

import Antlr.GoproveBaseVisitor;
import Antlr.GoproveParser;
import Exceptions.ParseError;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ExpressionVisitor extends GoproveBaseVisitor<Expression> {
    private static class UnaryExpressionVisitor extends GoproveBaseVisitor<Expression> {
        @Override
        public Expression visitUnaryExpr(GoproveParser.UnaryExprContext ctx) {
            if (ctx.primaryExpr() != null) {
                if (ctx.primaryExpr().operand() != null) {
                    GoproveParser.OperandContext operand = ctx.primaryExpr().operand();
                    if (operand.operandName() != null) {
                        return new OperandName(operand.operandName().getText());
                    }
                    if (operand.literal() != null) {
                        return new Literal(operand.literal().getText());
                    }
                    if (operand.expression() != null) {
                        return operand.expression().accept(new ExpressionVisitor());
                    }
                    if (operand.proveOperand() != null) {
                        return new OperandName(operand.proveOperand().getText());
                    }
                    throw new RuntimeException("Bad operand type (operandName and literals are supported)");
                } else if(ctx.primaryExpr().index() != null) {
                    if (ctx.primaryExpr().primaryExpr().operand() != null) {
                        return new ArrayExpression(new OperandName(ctx.primaryExpr().primaryExpr().operand().getText(), "[]int"), ctx.primaryExpr().index().expression().accept(new ExpressionVisitor()));
                    }
                    throw new RuntimeException("Expression before array index must be operand");
                } else {
                    throw new RuntimeException("No operand (usage of conversion, slices, type assertion and arguments is not supported)");
                }
            } else {
                UnaryExpressionVisitor unaryExpressionVisitor = new UnaryExpressionVisitor();
                Expression unaryExpression = ctx.unaryExpr().accept(unaryExpressionVisitor);
                return new UnaryExpression(ctx.children.get(0).getText(), unaryExpression);
            }
        }
    }
    @Override
    public Expression visitExpression(GoproveParser.ExpressionContext ctx) {
        if (ctx.unaryExpr() != null) {
            return ctx.unaryExpr().accept(new UnaryExpressionVisitor());
        }
        if (ctx.children.get(0) instanceof TerminalNode) {
            TerminalNode node = (TerminalNode) ctx.children.get(0);
            if (node.getSymbol().getText().equals("forall")) {
                ExpressionVisitor expressionVisitor = new ExpressionVisitor();
                return new ForallExpression(new OperandName(ctx.operandName().getText()), ctx.expression(0).accept(expressionVisitor));
            }
            if (node.getSymbol().getText().equals("exists")) {
                ExpressionVisitor expressionVisitor = new ExpressionVisitor();
                return new ExistsExpression(new OperandName(ctx.operandName().getText()), ctx.expression(0).accept(expressionVisitor));
            }
        }
        if (ctx.expression().size() == 2) {
            ExpressionVisitor expressionVisitor = new ExpressionVisitor();
            return new BinaryExpression(ctx.expression(0).accept(expressionVisitor), ctx.expression(1).accept(expressionVisitor), ctx.children.get(1).getText());
        }
        throw new ParseError();
    }
}