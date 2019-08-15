package Expressions;

public class TernaryExpression implements Expression {
    private Expression condition;
    private Expression a, b;

    public TernaryExpression(Expression condition, Expression a, Expression b) {
        this.condition = condition;
        this.a = a;
        this.b = b;
    }

    @Override
    public Expression replace(Expression x1, Expression x2) {
        return new TernaryExpression(condition, a.replace(x1, x2), b.replace(x1, x2));
    }

    @Override
    public boolean contains(Expression expression) {
        return a.contains(expression) || b.contains(expression);
    }
}
