package Prove;

import Antlr.GoproveBaseVisitor;
import Antlr.GoproveParser;

import java.util.List;

public class SourceVisitor extends GoproveBaseVisitor<Void> {

    private ProveContext proveContext;
    public SourceVisitor(ProveContext proveContext) {
        super();
        this.proveContext = proveContext;
    }

    @Override
    public Void visitSourceFile(GoproveParser.SourceFileContext ctx) {
        List<GoproveParser.TopLevelDeclContext> list = ctx.topLevelDecl();
        FunctionVisitor visitor = new FunctionVisitor(proveContext);
        for (GoproveParser.TopLevelDeclContext topLevelDeclContext : list) {
            if (topLevelDeclContext.proveFunctionDecl() != null) {
                topLevelDeclContext.proveFunctionDecl().accept(visitor);
            }
        }
        return null;
    }
}
