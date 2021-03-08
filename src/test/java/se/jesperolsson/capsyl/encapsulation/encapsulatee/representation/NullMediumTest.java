/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee.representation;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import se.jesperolsson.capsyl.depth.NullDepth;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.Encapsulatees;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.NullEncapsulatee;

/**
 * Tests for {@link NullMedium}.
 *
 * @since 0.1
 */
public class NullMediumTest {

    /**
     * When the object is asked to represent a name,
     * Then it should respond with an unchanged copy of itself.
     */
    @Test
    public void disregardName() {
        MatcherAssert.assertThat(
            new NullMedium(),
            CoreMatchers.equalTo(
                new NullMedium().representName("")
            )
        );
    }

    /**
     * When the object is asked to represent a depth,
     * Then it should respond with an unchanged copy of itself.
     */
    @Test
    public void disregardDepth() {
        MatcherAssert.assertThat(
            new NullMedium(),
            CoreMatchers.equalTo(
                new NullMedium().withDepth(new NullDepth())
            )
        );
    }

    /**
     * When the object is asked to print itself,
     * Then it should respond with an empty string.
     */
    @Test
    public void printNothing() {
        MatcherAssert.assertThat(
            "",
            CoreMatchers.equalTo(
                new NullMedium().print()
            )
        );
    }

    /**
     * When the object is asked to represent a child,
     * Then it should respond with an unchanged copy of itself.
     */
    @Test
    public void disregardChild() {
        MatcherAssert.assertThat(
            new NullMedium(),
            CoreMatchers.equalTo(
                new NullMedium().representChildren(
                    new Encapsulatees(
                        new NullEncapsulatee()
                    )
                )
            )
        );
    }

    /**
     * When the object is asked if it's equal to another NullMedium
     * Then the result should affirmative.
     */
    @Test
    public void demonstrateEgalitarianism() {
        MatcherAssert.assertThat(
            new NullMedium(),
            CoreMatchers.equalTo(new NullMedium())
        );
    }

    /**
     * When the object is asked if it's equal to some other type
     * Then the result should negative.
     */
    @Test
    public void demonstrateTribalism() {
        MatcherAssert.assertThat(
            new NullMedium(),
            CoreMatchers.not(CoreMatchers.equalTo(new Object()))
        );
    }
}
