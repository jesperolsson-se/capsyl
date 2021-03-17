/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee;

import com.github.javaparser.ast.expr.LiteralExpr;
import se.jesperolsson.capsyl.depth.Depth;
import se.jesperolsson.capsyl.encapsulation.MediaFactory;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.representation.Medium;

/**
 * Encapsulatee adapter for a JavaParser literal expression.
 *
 * @since 0.1
 */
public final class JpLiteral implements Encapsulatee {

    /**
     * JavaParser representation of literal expressions.
     */
    private final LiteralExpr literal;

    /**
     * The factory for creating media.
     */
    private final MediaFactory factory;

    /**
     * The object's depth in the encapsulation.
     */
    private final Depth depth;

    /**
     * Constructs a literal representation from a JavaParser concept.
     * @param literal A JavaParser representation of a literal.
     * @param factory The factory to use when creating media.
     * @param depth The object's depth in the encapsulation.
     */
    public JpLiteral(final LiteralExpr literal, final MediaFactory factory, final Depth depth) {
        this.literal = literal;
        this.factory = factory;
        this.depth = depth;
    }

    @Override
    public Medium represent() {
        return this.factory.encapsulatee()
            .representName(this.literal.toString())
            .withDepth(this.depth);
    }
}
