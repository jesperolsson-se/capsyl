/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee;

import java.util.LinkedList;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * Tests for {@link NullEncapsulatee}.
 *
 * @since 0.1
 */
public class NullEncapsulateeTest {

    /**
     * When the object is asked if it's equal to another NullEncapsulatee,
     * Then the result should affirmative.
     */
    @Test
    public void demonstrateEgalitarianism() {
        MatcherAssert.assertThat(
            new NullEncapsulatee(),
            CoreMatchers.equalTo(new NullEncapsulatee())
        );
    }

    /**
     * When the object is asked if it's equal to some other type,
     * Then the result should negative.
     */
    @Test
    public void demonstrateTribalism() {
        MatcherAssert.assertThat(
            new NullEncapsulatee(),
            CoreMatchers.not(CoreMatchers.equalTo(new Object()))
        );
    }
}
