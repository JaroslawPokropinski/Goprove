package Prove;

import Expressions.*;

interface Prover {
    boolean implies(Expression left, Expression right);
}
