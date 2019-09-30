package Expressions;

import Prove.ProveContext;

public class ArrayExpression implements Expression {
    private OperandName operandName;
    private Expression index;

    public ArrayExpression(OperandName operandName, Expression index) {
        this.operandName = operandName;
        this.index = index;
    }

    public OperandName getOperandName() {
        return operandName;
    }

    public Expression getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return String.format("%s[%s]", operandName, index);
    }

    @Override
    public Expression replace(Expression a, Expression b) {
        Expression newIndex = index.replace(a, b);
        if (a instanceof  ArrayExpression) {
            ArrayExpression ae = (ArrayExpression) a;
            if (ae.getOperandName().getName().equals(operandName.getName())) {
                return new TernaryExpression(
                        new BinaryExpression(index, ae.getIndex(), "=="),
                        b,
                        new ArrayExpression(operandName, newIndex)
                );
            }
        }
        return new ArrayExpression(operandName, newIndex);
    }

    @Override
    public boolean contains(Expression a) {
        if (a instanceof ArrayExpression) {
            ArrayExpression arrayExpression = (ArrayExpression) a;
            if (arrayExpression.getOperandName().getName().equals(operandName.getName())) {
                return true;
            }
        }
//        if (a instanceof OperandName) {
//            if (((OperandName)a).getType().equals("[]int")) {
//                throw new RuntimeException("Unimplemented contains of array");
//            }
//            throw new RuntimeException(String.format("Unimplemented contains %s", ((OperandName)a).getType()));
//        }
//        throw new RuntimeException("Unimplemented contains");
        return index.contains(a);
    }

    @Override
    public Expression removeTernary() {
        Expression e = index.removeTernary();
        if (e instanceof TernaryExpression) {
            TernaryExpression t = (TernaryExpression) e;
            return new TernaryExpression(
                    t.getCondition(),
                    new ArrayExpression(operandName, t.getA()).removeTernary(),
                    new ArrayExpression(operandName, t.getB()).removeTernary()
            );
        }
        return this;
    }

    @Override
    public void checkDeclaration(ProveContext proveContext) {
        proveContext.getVariable(operandName.getName());
        index.checkDeclaration(proveContext);
    }
}
