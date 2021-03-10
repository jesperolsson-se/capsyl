/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee.representation;

import java.util.Arrays;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.Encapsulatee;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.NullEncapsulatee;

/**
 * Tests for {@link DotEncapsulatees}.
 *
 * @since 0.1
 */
public class DotEncapsulateesTest {

    /**
     * Given that one object is created with varargs,
     * Given that another object is created with a collection,
     * When the objects are asked if they are equal,
     * Then it answer should be affirmative.
     */
    @Test
    public void streamMembers() {
        final Encapsulatee member = new NullEncapsulatee();
        MatcherAssert.assertThat(
            new DotEncapsulatees(Arrays.asList(member)),
            CoreMatchers.equalTo(
                new DotEncapsulatees(member)
            )
        );
    }
}
