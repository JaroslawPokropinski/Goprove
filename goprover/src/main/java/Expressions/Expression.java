package Expressions;

import java.util.Collection;

public interface Expression {
    Expression replace(Expression a, Expression b);
    boolean contains(Expression a);
    Expression removeTernary();
    Collection<OperandName> getOperands();
}
