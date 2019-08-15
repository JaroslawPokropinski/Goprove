import Expressions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExpressionTest {
    @Test
    void containmentTest() {
        Expression expression = new BinaryExpression(
                new OperandName("a"),
                new OperandName("b"),
                "=="
        );
        Assertions.assertTrue(expression.contains(new OperandName("a")));
        Assertions.assertTrue(expression.contains(new OperandName("b")));
        Assertions.assertFalse(expression.contains(new OperandName("c")));
    }

    @Test
    void replacementTest() {
        Expression expression = new BinaryExpression(
                new OperandName("a"),
                new OperandName("b"),
                "=="
        );
        Expression after = expression.replace(new OperandName("a"), new OperandName("c"));
        Assertions.assertFalse(after.contains(new OperandName("a")));
        Assertions.assertTrue(after.contains(new OperandName("b")));
        Assertions.assertTrue(after.contains(new OperandName("c")));
    }

    @Test
    void arrayReplacementTest() {
        Expression expression = new BinaryExpression(
                new ArrayExpression(new OperandName("a"), new Literal("0")),
                new OperandName("b"),
                "=="
        );
        Expression after = expression.replace(new ArrayExpression(new OperandName("a"), new Literal("0")), new OperandName("c"));
        // Assertions.assertFalse(after.contains(new OperandName("a")));
        Assertions.assertTrue(after.contains(new OperandName("b")));
        Assertions.assertTrue(after.contains(new OperandName("c")));
    }
}
