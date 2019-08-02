package Expressions;

import Antlr.GoproveBaseVisitor;
import Antlr.GoproveParser;

public class ExpressionVisitor extends GoproveBaseVisitor<Expression> {
    private class UnaryExpressionVisitor extends GoproveBaseVisitor<Expression> {
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
                } else {
                    throw new RuntimeException("No operand (usage of conversion, arrays, slices, type assertion and arguments is not supported)");
                }
            } else {
                UnaryExpressionVisitor unaryExpressionVisitor = new UnaryExpressionVisitor();
                Expression unaryExpression = ctx.unaryExpr().accept(unaryExpressionVisitor);
                return new UnaryExpression(ctx.children.get(1).getText(), unaryExpression);
            }
        }
    }
    @Override
    public Expression visitExpression(GoproveParser.ExpressionContext ctx) {
        if (ctx.unaryExpr() != null) {
            return ctx.unaryExpr().accept(new UnaryExpressionVisitor());
        } else {
            ExpressionVisitor expressionVisitor = new ExpressionVisitor();
            return new BinaryExpression(ctx.expression(0).accept(expressionVisitor), ctx.expression(1).accept(expressionVisitor), ctx.children.get(1).getText());
        }
    }
}