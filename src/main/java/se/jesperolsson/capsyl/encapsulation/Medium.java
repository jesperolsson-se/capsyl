package se.jesperolsson.capsyl.encapsulation;

import com.github.javaparser.ast.expr.Expression;

/**
 * Abstracts the textual representation of an encapsulation.
 */
public interface Medium {

    /**
     * Asks the medium to add a parameter to its representation.
     * @return A copy of the medium, that also contains the parameter.
     */
    Medium representParameter(Expression node);

    /**
     * Asks the medium to provide a medium that can represent the next level
     * in the encapsulation hierarchy.
     * @return A medium, that represents a new encapsulation level.
     */
    Medium nextLevel();

    /**
     * Asks the medium to add a child to its representation.
     * @return A copy of the medium, that also contains the child.
     */
    Medium representChild(Medium medium);

    /**
     * Asks the medium to provide its representation as text.
     * @return A textual representation of an encapsulation.
     */
    String print();
}
