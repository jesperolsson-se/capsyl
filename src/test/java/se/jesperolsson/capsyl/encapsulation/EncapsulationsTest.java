/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation;

import java.io.File;
import java.io.FileNotFoundException;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import se.jesperolsson.capsyl.encapsulation.representation.DescriptionMediumFactory;
import se.jesperolsson.capsyl.encapsulation.representation.Medium;
import se.jesperolsson.capsyl.encapsulation.representation.MediumFactory;
import se.jesperolsson.capsyl.encapsulation.representation.TreeMedium;

/**
 * Tests for {@link Encapsulations}.
 *
 * @since 0.1
 */
public class EncapsulationsTest {
    /* The library for parsing Java code has some limitations in testability.
     * For this reason, these tests will look more like integration tests than
     * unit tests.
     */

    /**
     * Given a snippet of Java code that declares variables with encapsulations,
     * When the object is asked to represent the encapsulations,
     * Then the declared encapsulations should be present.
     * @throws FileNotFoundException Should never occur.
     */
    @Test
    public void interpretVariableDeclaration() throws FileNotFoundException {
        final Encapsulations sut = new Encapsulations(
            new File(
                "src/test/java/se/jesperolsson/capsyl/encapsulation/VariableDeclaration.txt"
            ),
            () -> new TreeMedium()
        );
        MatcherAssert.assertThat(
            new StringBuilder()
                .append("Foo").append(System.lineSeparator())
                .append("  Bar")
                .toString(),
            CoreMatchers.equalTo(sut.asText())
        );
    }

    /**
     * Given a snippet of Java code that assigns encapsulations to variables,
     * When the object is asked to represent the encapsulations,
     * Then the assigned encapsulations should be present.
     * @throws FileNotFoundException Should never occur.
     */
    @Test
    public void interpretAssignmentExpressions() throws FileNotFoundException {
        final Encapsulations sut = new Encapsulations(
            new File(
                "src/test/java/se/jesperolsson/capsyl/encapsulation/AssignmentExpression.txt"
            ),
            () -> new TreeMedium()
        );
        MatcherAssert.assertThat(
            new StringBuilder()
                .append("Apa").append(System.lineSeparator())
                .append("  Bepa")
                .toString(),
            CoreMatchers.equalTo(sut.asText())
        );
    }
}
