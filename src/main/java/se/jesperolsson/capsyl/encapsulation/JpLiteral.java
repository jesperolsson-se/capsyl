/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation;

import com.github.javaparser.ast.expr.LiteralExpr;

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
     * Constructs a literal representation from a JavaParser concept.
     * @param literal A JavaParser representation of a literal.
     */
    public JpLiteral(final LiteralExpr literal) {
        this.literal = literal;
    }

    @Override
    public String name() {
        return this.literal.toString();
    }
}
