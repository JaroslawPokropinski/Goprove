import Antlr.GoproveBaseVisitor;
import Antlr.GoproveLexer;
import Antlr.GoproveParser;
import Prove.ProveContext;
import Prove.ProveFunction;
import Prove.SourceVisitor;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class ProveContextTest {

    @Test
    void proverShouldProveAssert() {
        String code = "package ex1\n" +
                "\n" +
                "//@ prove\n" +
                "//@ pre x == y\n" +
                "func example0(x int, y int) {\n" +
                "\tx = x + 1\n" +
                "\ty = y + 1\n" +
                "\t//@ assert x == y\n" +
                "}\n";

        GoproveLexer grammarLexer = new GoproveLexer (CharStreams.fromString(code));
        grammarLexer.removeErrorListeners();
        CommonTokenStream tokens = new CommonTokenStream(grammarLexer);
        GoproveParser parser = new GoproveParser(tokens);
        ParseTree tree = parser.sourceFile();

        ProveContext proveContext = new ProveContext();
        GoproveBaseVisitor<ProveFunction> visitor = new SourceVisitor(proveContext);
        visitor.visit(tree);
        List<Boolean> t = proveContext.prove();

        List<Boolean> trues = new ArrayList<>(Collections.nCopies(t.size(), true));
        Assertions.assertIterableEquals(trues, t);
    }

    @Test
    void proverShouldFailProvingAssert() {
        String code = "package ex1\n" +
                "\n" +
                "//@ prove\n" +
                "//@ pre x == y\n" +
                "//@ post 1 == 1\n" +
                "func example0(x int, y int) {\n" +
                "\tx = x + 1\n" +
                "\ty = y + 1\n" +
                "\t//@ assert x != y\n" +
                "}\n";

        GoproveLexer grammarLexer = new GoproveLexer (CharStreams.fromString(code));
        grammarLexer.removeErrorListeners();
        CommonTokenStream tokens = new CommonTokenStream(grammarLexer);
        GoproveParser parser = new GoproveParser(tokens);
        ParseTree tree = parser.sourceFile();

        ProveContext proveContext = new ProveContext();
        GoproveBaseVisitor<ProveFunction> visitor = new SourceVisitor(proveContext);
        visitor.visit(tree);
        List<Boolean> t = proveContext.prove();

        for (Boolean b : t) {
            if (!b) {
                return;
            }
        }
        Assertions.fail();
    }

    @Test
    void proverShouldProveLoop() {
        String code = "package ex1\n" +
                "\n" +
                "//@ prove\n" +
                "//@ pre x >= 0 && y >= 0\n" +
                "//@ post q*y + r == x && r >= 0 && r < y\n" +
                "func divideWithZero(x int, y int) (q, r int) {\n" +
                "\tq = 0\n" +
                "\tr = x\n" +
                "\t//@ inv q * y + r == x && r >= 0\n" +
                "\tfor r >= y {\n" +
                "\t\tr = r - y\n" +
                "\t\tq = q + 1\n" +
                "\t}\n" +
                "\treturn\n" +
                "}\n";

        GoproveLexer grammarLexer = new GoproveLexer (CharStreams.fromString(code));
        grammarLexer.removeErrorListeners();
        CommonTokenStream tokens = new CommonTokenStream(grammarLexer);
        GoproveParser parser = new GoproveParser(tokens);
        ParseTree tree = parser.sourceFile();

        ProveContext proveContext = new ProveContext();
        GoproveBaseVisitor<ProveFunction> visitor = new SourceVisitor(proveContext);
        visitor.visit(tree);
        List<Boolean> t = proveContext.prove();

        List<Boolean> trues = new ArrayList<>(Collections.nCopies(t.size(), true));
        Assertions.assertIterableEquals(trues, t);
    }

    @Test
    void proverShouldProveLoopWithNotChangedVariables() {
        String code = "package ex1\n" +
                "\n" +
                "//@ prove\n" +
                "//@ pre x >= 0 && y >= 0\n" +
                "//@ post q*y + r == x && r >= 0 && r < y\n" +
                "func divideWithZero3(x int, y int) (q, r int) {\n" +
                "\tvar a int\n" +
                "\tvar b int\n" +
                "\ta = x\n" +
                "\tb = y\n" +
                "\tq = 0\n" +
                "\tr = a\n" +
                "\t//@ inv q * b + r == a && r >= 0\n" +
                "\tfor r >= b {\n" +
                "\t\tr = r - b\n" +
                "\t\tq = q + 1\n" +
                "\t}\n" +
                "\treturn\n" +
                "}";

        GoproveLexer grammarLexer = new GoproveLexer (CharStreams.fromString(code));
        grammarLexer.removeErrorListeners();
        CommonTokenStream tokens = new CommonTokenStream(grammarLexer);
        GoproveParser parser = new GoproveParser(tokens);
        ParseTree tree = parser.sourceFile();

        ProveContext proveContext = new ProveContext();
        GoproveBaseVisitor<ProveFunction> visitor = new SourceVisitor(proveContext);
        visitor.visit(tree);
        List<Boolean> t = proveContext.prove();

        List<Boolean> trues = new ArrayList<>(Collections.nCopies(t.size(), true));
        Assertions.assertIterableEquals(trues, t);
    }

    @Test
    void proverShouldProveOld() {
        String code = "package ex1\n" +
                "\n" +
                "//@ prove\n" +
                "//@ pre x >= 0 && y >= 0\n" +
                "//@ post q * y'old + r == x'old && r >= 0 && r < y'old\n" +
                "func divideWithZero(x int, y int) (q, r int) {\n" +
                "\tq = 0\n" +
                "\tr = x\n" +
                "\t//@ inv q * y + r == x && r >= 0\n" +
                "\tfor r >= y {\n" +
                "\t\tr = r - y\n" +
                "\t\tq = q + 1\n" +
                "\t}\n" +
                "\treturn\n" +
                "}\n";

        GoproveLexer grammarLexer = new GoproveLexer (CharStreams.fromString(code));
        grammarLexer.removeErrorListeners();
        CommonTokenStream tokens = new CommonTokenStream(grammarLexer);
        GoproveParser parser = new GoproveParser(tokens);
        ParseTree tree = parser.sourceFile();

        ProveContext proveContext = new ProveContext();
        GoproveBaseVisitor<ProveFunction> visitor = new SourceVisitor(proveContext);
        visitor.visit(tree);
        List<Boolean> t = proveContext.prove();

        List<Boolean> trues = new ArrayList<>(Collections.nCopies(t.size(), true));
        Assertions.assertIterableEquals(trues, t);
    }

    @Test
    void proverShouldProveArray() {
        String code = "package ex1\n" +
                "\n" +
                "//@ prove\n" +
                "//@ pre 1 == 1\n" +
                "//@ post x[0] == a && x[1] == a\n" +
                "func arrayExample(x []int, a int) {\n" +
                "\tx[0] = a\n" +
                "\tx[1] = x[0]\n" +
                "\treturn\n" +
                "}\n";

        GoproveLexer grammarLexer = new GoproveLexer (CharStreams.fromString(code));
        grammarLexer.removeErrorListeners();
        CommonTokenStream tokens = new CommonTokenStream(grammarLexer);
        GoproveParser parser = new GoproveParser(tokens);
        ParseTree tree = parser.sourceFile();

        ProveContext proveContext = new ProveContext();
        GoproveBaseVisitor<ProveFunction> visitor = new SourceVisitor(proveContext);
        visitor.visit(tree);
        List<Boolean> t = proveContext.prove();

        List<Boolean> trues = new ArrayList<>(Collections.nCopies(t.size(), true));
        Assertions.assertIterableEquals(trues, t);
    }

    @Test
    void proverShouldProveArrayAndOld() {
        String code = "package ex1\n" +
                "\n" +
                "//@ prove\n" +
                "//@ pre 1 == 1\n" +
                "//@ post x[0] == x'old[1] && x[1] == x'old[0]\n" +
                "func arrayExample(x []int) {\n" +
                "\tvar t int\n" +
                "\tt = x[0]\n" +
                "\tx[0] = x[1]\n" +
                "\tx[1] = t\n" +
                "\treturn\n" +
                "}\n";

        GoproveLexer grammarLexer = new GoproveLexer (CharStreams.fromString(code));
        grammarLexer.removeErrorListeners();
        CommonTokenStream tokens = new CommonTokenStream(grammarLexer);
        GoproveParser parser = new GoproveParser(tokens);
        ParseTree tree = parser.sourceFile();

        ProveContext proveContext = new ProveContext();
        GoproveBaseVisitor<ProveFunction> visitor = new SourceVisitor(proveContext);
        visitor.visit(tree);
        List<Boolean> t = proveContext.prove();

        List<Boolean> trues = new ArrayList<>(Collections.nCopies(t.size(), true));
        Assertions.assertIterableEquals(trues, t);
    }

    @Test
    void proverShouldProveArrayForAll0() {
        // ex6.go
        String code = "package ex1\n" +
                "\n" +
                "//@ prove\n" +
                "//@ pre 1 == 1\n" +
                "//@ post (forall j integer !(0 <= j && j < n) || x[j] == y)\n" +
                "func fillExample(x []int, n int, y int) {\n" +
                "\tvar i int = 0\n" +
                "\t//@ inv (forall j integer !(0 <= j && j < i) || x[j] == y)\n" +
                "\tfor i < n {\n" +
                "\t\tx[i] = y\n" +
                "\t}\n" +
                "\treturn\n" +
                "}\n";

        GoproveLexer grammarLexer = new GoproveLexer (CharStreams.fromString(code));
        grammarLexer.removeErrorListeners();
        CommonTokenStream tokens = new CommonTokenStream(grammarLexer);
        GoproveParser parser = new GoproveParser(tokens);
        ParseTree tree = parser.sourceFile();

        ProveContext proveContext = new ProveContext();
        GoproveBaseVisitor<ProveFunction> visitor = new SourceVisitor(proveContext);
        visitor.visit(tree);
        List<Boolean> t = proveContext.prove();

        List<Boolean> trues = new ArrayList<>(Collections.nCopies(t.size(), true));
        Assertions.assertIterableEquals(trues, t);
    }

    @Test
    void proverShouldProveArrayForAll() {
        // ex4.go
        String code = "package ex1\n" +
                "\n" +
                "//@ prove\n" +
                "//@ pre 1 == 1\n" +
                "//@ post (forall k integer !(1 <= k && k < n) || x[k - 1] <= x[k])\n" +
                "func sortExample(x []int, n int) {\n" +
                "\tvar i int = 1\n" +
                "\t//@ inv (forall k integer !(1 <= k && k < i) || x[k - 1] <= x[k])\n" +
                "\tfor i < n {\n" +
                "\t\tvar j int = i\n" +
                "\t\t//@ inv (forall k integer !(k >= 1 && k <= j-1) || x[k - 1] <= x[k]) && (forall k integer !(k >= j + 1 && k <= i) || x[k - 1] <= x[k]) && (!(1 <= j && j < i) || x[j-1] <= x[j+1]) && j <= i\n" +
                "\t\tfor j > 0 && x[j-1] > x[j] {\n" +
                "\t\t\tvar t int = x[j]\n" +
                "\t\t\t//@ assert (!(2 <= j) || x[j-2] <= x[j-1])\n" +
                "\t\t\tx[j] = x[j-1]\n" +
                "\t\t\tx[j-1] = t\n" +
                "\t\t\tj = j - 1\n" +
                "\t\t\t//@ assert (forall k integer !(k >= 1 && k <= j-1) || x[k - 1] <= x[k])\n" +
                "\t\t\t//@ assert (forall k integer !(k >= j + 1 && k <= i) || x[k - 1] <= x[k])\n" +
                "\t\t\t//@ assert (!(j >= 1 && j <= i) || x[j-1] <= x[j+1])\n" +
                "\t\t\t// @ assert (x[j-1] <= x[j+1])\n" +
                "\t\t\t//@ assert j < i\n" +
                "\t\t}\n" +
                "\t\ti = i + 1\n" +
                "\t}\n" +
                "\treturn\n" +
                "}";

        GoproveLexer grammarLexer = new GoproveLexer (CharStreams.fromString(code));
        grammarLexer.removeErrorListeners();
        CommonTokenStream tokens = new CommonTokenStream(grammarLexer);
        GoproveParser parser = new GoproveParser(tokens);
        ParseTree tree = parser.sourceFile();

        ProveContext proveContext = new ProveContext();
        GoproveBaseVisitor<ProveFunction> visitor = new SourceVisitor(proveContext);
        visitor.visit(tree);
        List<Boolean> t = proveContext.prove();

        List<Boolean> trues = new ArrayList<>(Collections.nCopies(t.size(), true));
        Assertions.assertIterableEquals(trues, t);
    }

    @Test
    void proverShouldProveIf() {
        // ex4.go
        String code = "package ex1\n" +
                "\n" +
                "//@ prove\n" +
                "//@ pre 1 == 1\n" +
                "//@ post (j >= 0 || i == 1) && (j < 0 || i == 2)\n" +
                "func ifExample(j int) (i int) {\n" +
                "\ti = 0\n" +
                "\n" +
                "\tif j < 0 {\n" +
                "\t\ti = 1\n" +
                "\t}\n" +
                "\n" +
                "\tif j >= 0 {\n" +
                "\t\ti = 2\n" +
                "\t}\n" +
                "\n" +
                "\treturn\n" +
                "}";

        GoproveLexer grammarLexer = new GoproveLexer (CharStreams.fromString(code));
        grammarLexer.removeErrorListeners();
        CommonTokenStream tokens = new CommonTokenStream(grammarLexer);
        GoproveParser parser = new GoproveParser(tokens);
        ParseTree tree = parser.sourceFile();

        ProveContext proveContext = new ProveContext();
        GoproveBaseVisitor<ProveFunction> visitor = new SourceVisitor(proveContext);
        visitor.visit(tree);
        List<Boolean> t = proveContext.prove();

        List<Boolean> trues = new ArrayList<>(Collections.nCopies(t.size(), true));
        Assertions.assertIterableEquals(trues, t);
    }

    //TODO: test else and else if
}