package Prove;

import Expressions.*;

public abstract class ExpressionConverter<Expr> {
    public Expr convertExpression(Expression expression) {
        if (expression instanceof BinaryExpression) {
            BinaryExpression binaryExpression = (BinaryExpression) expression;
            switch (binaryExpression.getBinaryOperator()) {
                case "&&":
                    return onAnd(binaryExpression);
                case "||":
                    return onOr(binaryExpression);
                case "<":
                    return onLt(binaryExpression);
                case ">":
                    return onGt(binaryExpression);
                case ">=":
                    return onGe(binaryExpression);
                case "<=":
                    return onLe(binaryExpression);
                case "==":
                    return onEq(binaryExpression);
                case "!=":
                    return onNotEq(binaryExpression);
                case "+":
                    return onAdd(binaryExpression);
                case "-":
                    return onSub(binaryExpression);
                case "*":
                    return onMul(binaryExpression);
                default:
                    throw new RuntimeException(String.format("Unsupported binary expression '%s'", binaryExpression.getBinaryOperator()));
            }
        }
        if (expression instanceof UnaryExpression) {
            UnaryExpression unaryExpression = (UnaryExpression) expression;
            switch (unaryExpression.getOperator()) {
                case "-":
                    return onSub(unaryExpression);
                case "!":
                    return onNot(unaryExpression);
                default:
                    throw new RuntimeException(String.format("Unsupported unary expression '%s'", unaryExpression));
            }
        }
        if (expression instanceof Literal) {
            return onLiteral((Literal) expression);
        }
        if (expression instanceof OperandName) {
            return onOperand((OperandName) expression);
        }
        if (expression instanceof ArrayExpression) {
            return onArray((ArrayExpression) expression);
        }
        if (expression instanceof ForallExpression) {
            return onForAll((ForallExpression) expression);
        }
        if (expression instanceof ExistsExpression) {
            return onExists((ExistsExpression) expression);
        }
        throw new RuntimeException("Unsupported type of expression");
    }

    protected abstract Expr onAnd(BinaryExpression binaryExpression);
    protected abstract Expr onOr(BinaryExpression binaryExpression);
    protected abstract Expr onLt(BinaryExpression binaryExpression);
    protected abstract Expr onGt(BinaryExpression binaryExpression);
    protected abstract Expr onLe(BinaryExpression binaryExpression);
    protected abstract Expr onGe(BinaryExpression binaryExpression);
    protected abstract Expr onEq(BinaryExpression binaryExpression);
    protected abstract Expr onNotEq(BinaryExpression binaryExpression);
    protected abstract Expr onAdd(BinaryExpression binaryExpression);
    protected abstract Expr onSub(BinaryExpression binaryExpression);
    protected abstract Expr onMul(BinaryExpression binaryExpression);

    protected abstract Expr onSub(UnaryExpression unaryExpression);
    protected abstract Expr onNot(UnaryExpression unaryExpression);

    protected abstract Expr onLiteral(Literal literal);
    protected abstract Expr onOperand(OperandName operand);
    protected abstract Expr onArray(ArrayExpression array);
    protected abstract Expr onForAll(ForallExpression fe);
    protected abstract Expr onExists(ExistsExpression ex);

}
