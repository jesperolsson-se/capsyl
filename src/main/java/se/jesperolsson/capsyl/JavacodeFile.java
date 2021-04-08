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
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import se.jesperolsson.capsyl.encapsulation.DotFactory;
import se.jesperolsson.capsyl.encapsulation.Encapsulation;
import se.jesperolsson.capsyl.encapsulation.Encapsulations;
import se.jesperolsson.capsyl.encapsulation.MediaFactory;
import se.jesperolsson.capsyl.name.Mononym;

/**
 * Represents Java source code contained in a file.
 *
 * @since 0.1
 */
public final class JavacodeFile extends VoidVisitorAdapter<List<Encapsulation>> implements
    Javacode {

    /**
     * The Java syntax tree.
     */
    private final CompilationUnit code;

    /**
     * The factory for creating media.
     */
    private final MediaFactory factory;

    /**
     * Constructs Java code from a path.
     * @param path The path to a file containing Java source code.
     * @throws FileNotFoundException If the path is inaccessible.
     */
    public JavacodeFile(final String path) throws FileNotFoundException {
        this(new File(path), new DotFactory());
    }

    /**
     * Constructs Java code from the contents of a file.
     * @param file A file containing Java source code.
     * @param factory The factory to use when creating media.
     * @throws FileNotFoundException If the file is inaccessible.
     */
    public JavacodeFile(final File file, final MediaFactory factory) throws FileNotFoundException {
        this(StaticJavaParser.parse(file), factory);
    }

    /**
     * Constructs Java code from an abstract syntax tree (AST).
     * @param code The AST of a piece of Java code.
     * @param factory The factory to use when creating media.
     */
    public JavacodeFile(final CompilationUnit code, final MediaFactory factory) {
        this.code = code;
        this.factory = factory;
    }

    @Override
    public Encapsulations encapsulations() {
        final List<Encapsulation> encaps = new LinkedList<>();
        this.visit(this.code, encaps);
        return new Encapsulations(encaps);
    }

    @Override
    public void visit(final VariableDeclarator declaration, final List<Encapsulation> encaps) {
        super.visit(declaration, encaps);
        final List<Node> children = declaration.getChildNodes();
        for (final Node child: children) {
            if (child instanceof ObjectCreationExpr) {
                final ObjectCreationExpr constructor = (ObjectCreationExpr) child;
                final Encapsulation encap = new Encapsulation(
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
            final Encapsulation encap = new Encapsulation(
                constructor,
                this.factory,
                new Mononym(assignment.getTarget().asNameExpr().getName().asString())
            );
            encaps.add(encap);
        }
    }
}
