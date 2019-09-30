package Expressions;

import Exceptions.UnimplementedException;
import Prove.ProveContext;

public class TernaryExpression implements Expression {
    private Expression condition;
    private Expression a, b;

    public TernaryExpression(Expression condition, Expression a, Expression b) {
        if (condition == null || a == null || b == null) {
            throw new NullPointerException();
        }
        this.condition = condition;
        this.a = a;
        this.b = b;
    }

    public Expression getCondition() {
        return condition;
    }

    public Expression getA() {
        return a;
    }

    public Expression getB() {
        return b;
    }

    @Override
    public String toString() {
        return String.format("(if %s then %s else %s)", condition, a, b);
    }

    @Override
    public Expression replace(Expression x1, Expression x2) {
        return new TernaryExpression(condition, a.replace(x1, x2), b.replace(x1, x2));
    }

    @Override
    public boolean contains(Expression expression) {
        return a.contains(expression) || b.contains(expression);
    }

    @Override
    public Expression removeTernary() {
        return new TernaryExpression(condition, a.removeTernary(), b.removeTernary());
    }

    @Override
    public void checkDeclaration(ProveContext proveContext) {
        throw new UnimplementedException();
    }
}
