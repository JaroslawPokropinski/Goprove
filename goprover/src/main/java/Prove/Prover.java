package Prove;

import Expressions.*;

public abstract class Prover {
    public abstract boolean implies(Expression left, Expression right);
}
