/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation;

import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import java.util.LinkedList;
import java.util.List;

/**
 * Encapsulatee adapter for a JavaParser constructor expression.
 *
 * @since 0.1
 */
public final class JpConstructor implements Encapsulatee {

    /**
     * JavaParser representation of a constructor expression.
     */
    private final ObjectCreationExpr constructor;

    /**
     * Constructs a constructor representation from a JavaParser concept.
     * @param constructor A JavaParser representation of a constructor.
     */
    public JpConstructor(final ObjectCreationExpr constructor) {
        this.constructor = constructor;
    }

    @Override
    public String name() {
        return this.constructor.getTypeAsString();
    }

    @Override
    public List<Encapsulatee> children() {
        final List<Encapsulatee> result = new LinkedList<>();
        for (final Expression parameter : this.constructor.getArguments()) {
            if (parameter.isObjectCreationExpr()) {
                result.add(new JpConstructor(parameter.asObjectCreationExpr()));
            } else if (parameter.isLiteralExpr()) {
                result.add(new JpLiteral(parameter.asLiteralExpr()));
            }
        }
        return result;
    }
}
