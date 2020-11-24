package se.jesperolsson.capsyl.encapsulation;

import com.github.javaparser.ast.expr.LiteralExpr;

/**
 * Encapsulatee adapter for a JavaParser literal expression.
 */
public class JpLiteral implements Encapsulatee {

    private final LiteralExpr literal;

    public JpLiteral(LiteralExpr literal) {
        this.literal = literal;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return literal.toString();
    }
}
