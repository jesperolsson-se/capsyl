/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee.representation;

import java.util.Collections;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * Tests for {@link NullEncapsulateesMedium}.
 *
 * @since 0.1
 */
public class NullEncapsulateesMediumTest {

    /**
     * When the object is asked to print itself,
     * Then it should respond with an empty string.
     */
    @Test
    public void printNothing() {
        MatcherAssert.assertThat(
            new NullMedium().print(),
            CoreMatchers.equalTo("")
        );
    }

    /**
     * When the object is asked to represent a collective,
     * Then it should respond with an unchanged copy of itself.
     */
    @Test
    public void disregardCollective() {
        MatcherAssert.assertThat(
            new NullEncapsulateesMedium().withMembers(Collections.emptyList()),
            CoreMatchers.equalTo(new NullEncapsulateesMedium())
        );
    }
}
