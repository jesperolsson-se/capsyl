/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation;

import com.github.javaparser.ast.expr.ObjectCreationExpr;
import se.jesperolsson.capsyl.encapsulation.representation.Medium;
import se.jesperolsson.capsyl.encapsulation.representation.TreeMedium;

/**
 * Represents an object's encapsulation.
 *
 * @since 0.1
 */
public class Encapsulation {

    /**
     * The syntax tree node representing a constructor expression.
     */
    private final Encapsulatee node;

    /**
     * The medium in which to represent myself.
     */
    private final Medium medium;

    /**
     * Constructs an encapsulation from a construction statement.
     * @param node An AST node for object creation.
     */
    public Encapsulation(final ObjectCreationExpr node) {
        this(new JpConstructor(node));
    }

    /**
     * Constructs an encapsulation containing an encapsulatee.
     * @param encapsulatee An entity that can be encapsulated.
     */
    public Encapsulation(final Encapsulatee encapsulatee) {
        this(encapsulatee, new TreeMedium());
    }

    /**
     * Constructs an encapsulation.
     * @param encapsulatee An entity that can be encapsulated.
     * @param medium The medium to in which the encapsulation should represent itself.
     */
    public Encapsulation(final Encapsulatee encapsulatee, final Medium medium) {
        this.node = encapsulatee;
        this.medium = medium;
    }

    /**
     * Asks the encapsulation to represent itself.
     * @return A medium containing a representation of this object.
     */
    public Medium represent() {
        final Medium childless = this.medium.representEncapsulatee(this.node);
        return this.node.children()
            .stream()
            .map(expression -> new Encapsulation(expression, this.medium.nextLevel()).represent())
            .reduce(childless, (next, child) -> next.representChild(child));
    }
}
