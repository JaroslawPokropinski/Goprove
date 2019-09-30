package Expressions;

import Prove.ProveContext;

public class ExistsExpression implements Expression {
    private OperandName iterator;
    private Expression expression;

    public ExistsExpression(OperandName operandName, Expression accept) {
        if (operandName == null) {
            throw new NullPointerException();
        }
        if (accept == null) {
            throw new NullPointerException();
        }

        this.iterator = operandName;
        this.expression = accept;
    }

    public OperandName getIterator() {
        return iterator;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return String.format("(exists %s is %s)", iterator, expression);
    }

    @Override
    public Expression replace(Expression a, Expression b) {
        return new ExistsExpression(iterator, expression.replace(a, b));
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
        return new ExistsExpression(iterator, newExpression);
    }

    @Override
    public void checkDeclaration(ProveContext proveContext) {
        proveContext.declareVariable(iterator);
        expression.checkDeclaration(proveContext);
        proveContext.undeclareVariable(iterator.getName());
    }
}
