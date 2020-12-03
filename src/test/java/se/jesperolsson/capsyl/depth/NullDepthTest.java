/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.depth;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * Tests for {@link NullDepth}.
 *
 * @since 0.1
 */
public class NullDepthTest {

    /**
     * When the object is asked for its next level
     * Then the result should be a NullDepth.
     */
    @Test
    public void disregardNext() {
        MatcherAssert.assertThat(
            new NullDepth(),
            CoreMatchers.equalTo(new NullDepth().next())
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
                new NullDepth().print()
            )
        );
    }

    /**
     * When the object is asked if it's equal to another NullDepth
     * Then the result should affirmative.
     */
    @Test
    public void demonstrateEgalitarianism() {
        MatcherAssert.assertThat(
            new NullDepth(),
            CoreMatchers.equalTo(new NullDepth())
        );
    }

    /**
     * When the object is asked if it's equal to some other type
     * Then the result should negative.
     */
    @Test
    public void demonstrateTribalism() {
        MatcherAssert.assertThat(
            new NullDepth(),
            CoreMatchers.not(CoreMatchers.equalTo(new Object()))
        );
    }
}
