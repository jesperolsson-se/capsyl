/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation;

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
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import se.jesperolsson.capsyl.DescriptionFormatFactory;
import se.jesperolsson.capsyl.FormatFactory;

/**
 * Represents all encapsulations contained in a snippet of Java source code.
 *
 * @since 0.1
 */
public final class Encapsulations extends VoidVisitorAdapter<List<Encapsulation>> {

    /**
     * The Java syntax tree.
     */
    private final CompilationUnit code;

    /**
     * The factory for creating media.
     */
    private final FormatFactory factory;

    /**
     * Constructs encapsulations from source code stored in a file.
     * @param source A file containing Java source code.
     * @throws FileNotFoundException If the file is inaccessible.
     */
    public Encapsulations(final File source) throws FileNotFoundException {
        this(StaticJavaParser.parse(source), new DescriptionFormatFactory());
    }

    /**
     * Constructs encapsulations from source code stored in a file.
     * @param source A file containing Java source code.
     * @param factory The factory to use when creating media.
     * @throws FileNotFoundException If the file is inaccessible.
     */
    public Encapsulations(final File source, final FormatFactory factory)
        throws FileNotFoundException {
        this(StaticJavaParser.parse(source), factory);
    }

    /**
     * Constructs encapsulations from a Java abstract syntax tree (AST).
     * @param code The AST of a piece of Java code.
     * @param factory The factory to use when creating media.
     */
    public Encapsulations(final CompilationUnit code, final FormatFactory factory) {
        this.code = code;
        this.factory = factory;
    }

    /**
     * Asks the encapsulations to provide a textual represent of itself.
     * @return The textual representation of the encapsulations.
     */
    public String asText() {
        final List<String> parts = StreamSupport.stream(this.asIterable().spliterator(), false)
            .map(encapsulation -> encapsulation.represent().print())
            .collect(Collectors.toList());
        return String.join(System.lineSeparator(), parts);
    }

    /**
     * Represents the encapsulations as an iterable.
     * @return A series of encapsulations.
     */
    public Iterable<Encapsulation> asIterable() {
        final List<Encapsulation> encaps = new LinkedList<>();
        this.visit(this.code, encaps);
        return encaps;
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
                    this.factory.create(),
                    declaration.getName().asString()
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
                this.factory.create(),
                assignment.getTarget().asNameExpr().getName().asString()
            );
            encaps.add(encap);
        }
    }
}
