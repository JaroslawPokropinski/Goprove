package Expressions;

public final class UnaryExpression implements Expression {
    private final String operator;
    private final Expression expression;

    public UnaryExpression(String operator, Expression expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public String getOperator() {
        return operator;
    }

    public Expression getExpression() {
        return expression;
    }

    public boolean isBoolean() {
        return operator.equals("!");
    }

    @Override
    public String toString() {
        return String.format("%s(%s)", operator, expression.toString());
    }

    @Override
    public Expression replace(Expression a, Expression b) {
        Expression newExpression;
        if (expression instanceof OperandName) {
            if (((OperandName) expression).getName().equals(((OperandName) a).getName())) {
                newExpression = b;
            } else {
                newExpression = expression;
            }
        } else {
            newExpression = expression.replace(a, b);
        }
        return new UnaryExpression(operator, newExpression);
    }

    @Override
    public boolean contains(Expression a) {
        if (expression instanceof OperandName) {
            if (((OperandName) expression).getName().equals(((OperandName) a).getName())) {
                return true;
            }
        } else if(expression.contains(a)){
            return true;
        }
        return false;
    }

    @Override
    public Expression removeTernary() {
        Expression newExpression = expression.removeTernary();
        if (newExpression instanceof TernaryExpression) {
            if (isBoolean()) {
                throw new RuntimeException();
            }
            TernaryExpression ternary = (TernaryExpression) newExpression;
            return new TernaryExpression(ternary.getCondition(),
                    new UnaryExpression(operator, ternary.getA()).removeTernary(),
                    new UnaryExpression(operator, ternary.getB()).removeTernary()
            );
        }
        return this;
    }
}
