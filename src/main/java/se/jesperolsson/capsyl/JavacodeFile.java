/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import se.jesperolsson.capsyl.encapsulation.DotFactory;
import se.jesperolsson.capsyl.encapsulation.Encapsulation;
import se.jesperolsson.capsyl.encapsulation.Encapsulations;
import se.jesperolsson.capsyl.encapsulation.MediaFactory;
import se.jesperolsson.capsyl.encapsulation.NamedEncapsulation;
import se.jesperolsson.capsyl.encapsulation.SimpleEncapsulations;
import se.jesperolsson.capsyl.name.Mononym;

/**
 * Represents Java source code contained in a file.
 *
 * @since 0.1
 */
public final class JavacodeFile extends VoidVisitorAdapter<List<Encapsulation>> implements
    Javacode {

    /**
     * The Java file.
     */
    private final File file;

    /**
     * The factory for creating media.
     */
    private final MediaFactory factory;

    /**
     * Constructs Java code from a path.
     * @param path The path to a file containing Java source code.
     */
    public JavacodeFile(final String path) {
        this(new File(path), new DotFactory());
    }

    /**
     * Constructs Java code from the contents of a file.
     * @param file A file containing Java source code.
     * @param factory The factory to use when creating media.
     */
    public JavacodeFile(final File file, final MediaFactory factory) {
        this.file = file;
        this.factory = factory;
    }

    @Override
    public Encapsulations encapsulations() throws IOException {
        final List<Encapsulation> encaps = new LinkedList<>();
        final CompilationUnit code = StaticJavaParser.parse(this.file);
        this.visit(code, encaps);
        return new SimpleEncapsulations(encaps);
    }

    @Override
    public void visit(final VariableDeclarator declaration, final List<Encapsulation> encaps) {
        super.visit(declaration, encaps);
        final List<Node> children = declaration.getChildNodes();
        for (final Node child: children) {
            if (child instanceof ObjectCreationExpr) {
                final ObjectCreationExpr constructor = (ObjectCreationExpr) child;
                final NamedEncapsulation encap = new NamedEncapsulation(
                    constructor,
                    this.factory,
                    new Mononym(declaration.getName().asString())
                );
                encaps.add(encap);
            }
        }
    }

    @Override
    public void visit(final AssignExpr assignment, final List<Encapsulation> encaps) {
        super.visit(assignment, encaps);
        final Expression value = assignment.getValue();
        if (value.isObjectCreationExpr()) {
            final ObjectCreationExpr constructor = value.asObjectCreationExpr();
            final NamedEncapsulation encap = new NamedEncapsulation(
                constructor,
                this.factory,
                new Mononym(assignment.getTarget().asNameExpr().getName().asString())
            );
            encaps.add(encap);
        }
    }
}
