import Antlr.GoproveBaseVisitor;
import Antlr.GoproveLexer;
import Antlr.GoproveParser;
import Prove.ProveContext;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String inPath = "D:\\Programming ssd\\Praca dyplomowa\\examples\\ex1.5.go";
        ProveFunction proveFunction = null;
        ProveContext proveContext = new ProveContext();
        try {
            GoproveLexer grammarLexer = new GoproveLexer (CharStreams.fromFileName(inPath));
            CommonTokenStream tokens = new CommonTokenStream(grammarLexer);
            GoproveParser parser = new GoproveParser(tokens);
            ParseTree tree = parser.sourceFile();

            GoproveBaseVisitor<ProveFunction> visitor = new SourceVisitor(proveContext);
            proveFunction = visitor.visit(tree);

        } catch (IOException e) {
            System.out.println("Problem opening file");
            System.exit(1);
        }
        if (proveFunction == null) {
            System.out.println("Nothing to prove");
            System.exit(1);
        }
        // Prove program
        proveContext.prove();
    }
}
