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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Represents all encapsulations contained in a snippet of Java source code.
 */
public class Encapsulations extends VoidVisitorAdapter<List<Encapsulation>> {

    private final CompilationUnit syntaxTree;

    /**
     * Constructs encapsulations from source code stored in a file.
     * @param source A file containing Java source code.
     * @throws FileNotFoundException If the file is inaccessible.
     */
    public Encapsulations(File source) throws FileNotFoundException {
        this(StaticJavaParser.parse(source));
    }

    /**
     * Constructs encapsulations from a Java abstract syntax tree (AST).
     * @param syntaxTree The AST of a piece of Java code.
     */
    public Encapsulations(CompilationUnit syntaxTree) {
        this.syntaxTree = syntaxTree;
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
        List<Encapsulation> encapsulations = new ArrayList<>();
        visit(syntaxTree, encapsulations); // Side-effects seems to be the only option.
        return encapsulations;
    }

    @Override
    public void visit(VariableDeclarator md, List<Encapsulation> arg) {
        /* Satisfies, e.g.,
           Foo a = new Apa(new Bepa());
        */

        super.visit(md, arg);
        List<Node> children = md.getChildNodes();
        for (Node child: children) {
            if (child instanceof ObjectCreationExpr) {  // This should happen exactly zero or one times.
                Encapsulation encapsulation = new Encapsulation((ObjectCreationExpr) child);
                arg.add(encapsulation);
            }
        }
    }

    @Override
    public void visit(AssignExpr md, List<Encapsulation> arg) {
        /* Satisfies, e.g.,
           Foo foo;
           foo = new Apa(new Bepa());
         */

        super.visit(md, arg);
        Expression rightHandSide = md.getValue();
        if (rightHandSide.isObjectCreationExpr()) {
            ObjectCreationExpr constructorNode = rightHandSide.asObjectCreationExpr();
            Encapsulation encapsulation = new Encapsulation(constructorNode);
            arg.add(encapsulation);
        }
    }
}