/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation;

import com.github.javaparser.ast.expr.ObjectCreationExpr;
import lombok.EqualsAndHashCode;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.Encapsulatee;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.JpConstructor;
import se.jesperolsson.capsyl.encapsulation.representation.Medium;

/**
 * Represents an encapsulation. That is, something that is being encapsulated plus metadata.
 *
 * @since 0.1
 */
@EqualsAndHashCode
public final class Encapsulation {

    /**
     * The syntax tree node representing a constructor expression.
     */
    private final Encapsulatee node;

    /**
     * The medium in which to represent myself.
     */
    private final Medium medium;

    /**
     * The name given to the encapsulation.
     */
    private final String name;

    /**
     * Constructs an encapsulation from a construction statement.
     * @param node An AST node for object creation.
     * @param medium The medium to in which the statement should represent itself.
     */
    public Encapsulation(final ObjectCreationExpr node, final Medium medium) {
        this(node, medium, "Var");
    }

    /**
     * Constructs an encapsulation.
     * @param node An AST node for object creation.
     * @param medium The medium to in which the encapsulation should represent itself.
     * @param name The name of the encapsulation.
     */
    public Encapsulation(final ObjectCreationExpr node, final Medium medium, final String name) {
        this(new JpConstructor(node), medium, name);
    }

    /**
     * Constructs an encapsulation.
     * @param encapsulatee An entity that can be encapsulated.
     * @param medium The medium to in which the encapsulation should represent itself.
     * @param name The name of the encapsulation.
     */
    public Encapsulation(final Encapsulatee encapsulatee, final Medium medium, final String name) {
        this.node = encapsulatee;
        this.medium = medium;
        this.name = name;
    }

    /**
     * Asks the encapsulation to represent itself.
     * @return A medium containing a representation of this object.
     */
    public Medium represent() {
        return this.medium.representEncapsulatee(this.node).representName(this.name);
    }
}
