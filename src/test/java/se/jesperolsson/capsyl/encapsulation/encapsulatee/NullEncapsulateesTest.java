/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.representation.NullEncapsulationsMedium;

/**
 * Tests for {@link NullEncapsulatees}.
 *
 * @since 0.1
 */
public class NullEncapsulateesTest {

    /**
     * When the object is asked if it's equal to another NullEncapsulatees,
     * Then the result should affirmative.
     */
    @Test
    public void demonstrateEgalitarianism() {
        MatcherAssert.assertThat(
            new NullEncapsulatees(),
            CoreMatchers.equalTo(new NullEncapsulatees())
        );
    }

    /**
     * When the object is asked if it's equal to some other type,
     * Then the result should negative.
     */
    @Test
    public void demonstrateTribalism() {
        MatcherAssert.assertThat(
            new NullEncapsulatees(),
            CoreMatchers.not(CoreMatchers.equalTo(new Object()))
        );
    }

    /**
     * When the object is asked if it's empty,
     * Then the result should be affirmative.
     */
    @Test
    public void reportEmpty() {
        MatcherAssert.assertThat(
            true,
            CoreMatchers.equalTo(new NullEncapsulatees().isEmpty())
        );
    }

    /**
     * When the object is asked to represent itself,
     * Then the provided medium should be unchanged.
     */
    @Test
    public void disregardRepresentation() {
        MatcherAssert.assertThat(
            new NullEncapsulationsMedium(),
            CoreMatchers.equalTo(new NullEncapsulatees().represent(new NullEncapsulationsMedium()))
        );
    }
}
