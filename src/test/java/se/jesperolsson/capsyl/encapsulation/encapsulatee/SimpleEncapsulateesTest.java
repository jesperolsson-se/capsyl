/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee;

import java.util.Arrays;
import java.util.Collections;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import se.jesperolsson.capsyl.encapsulation.NullFactory;

/**
 * Tests for {@link SimpleEncapsulatees}.
 *
 * @since 0.1
 */
public class SimpleEncapsulateesTest {

    /**
     * Given zero members,
     * When the object is asked if it's empty,
     * Then the result should be affirmative.
     */
    @Test
    public void beEmpty() {
        MatcherAssert.assertThat(
            true,
            CoreMatchers.is(
                new SimpleEncapsulatees(new NullFactory(), Collections.EMPTY_LIST).isEmpty()
            )
        );
    }

    /**
     * Given one or more members,
     * When the object is asked if it's empty,
     * Then the result should be negative.
     */
    @Test
    public void beNonEmpty() {
        MatcherAssert.assertThat(
            false,
            CoreMatchers.is(
                new SimpleEncapsulatees(
                    new NullFactory(),
                    Arrays.asList(new NullEncapsulatee())
                ).isEmpty()
            )
        );
    }
}
