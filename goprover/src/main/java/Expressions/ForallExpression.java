package Expressions;

import Exceptions.UnimplementedException;

import java.util.Collection;
import java.util.HashSet;

public class ForallExpression implements Expression {

    private OperandName iterator;
    private Expression expression;

    public ForallExpression(OperandName iterator, Expression expression) {
        // TODO: Check for shadowing
        if (iterator == null) {
            throw new NullPointerException();
        }
        if (expression == null) {
            throw new NullPointerException();
        }
        this.iterator = iterator;
        this.expression = expression;
    }

    public OperandName getIterator() {
        return iterator;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return String.format("(forall %s is %s)", iterator, expression);
    }

    @Override
    public Expression replace(Expression a, Expression b) {
        // TODO: make iterator ..
        return new ForallExpression(iterator, expression.replace(a, b));
    }

    @Override
    public boolean contains(Expression a) {
        return expression.contains(a);
    }

    @Override
    public Expression removeTernary() {
        Expression newExpression = expression.removeTernary();
        if (newExpression instanceof TernaryExpression) {
            throw new RuntimeException("Expression in forall statement must be boolean");
        }
        return new ForallExpression(iterator, newExpression);
    }

    @Override
    public Collection<OperandName> getOperands() {
        HashSet<OperandName> hs = new HashSet<>(expression.getOperands());
        hs.add(iterator);
        return hs;
    }
}
