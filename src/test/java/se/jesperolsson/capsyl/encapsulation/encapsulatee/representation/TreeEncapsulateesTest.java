/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee.representation;

import java.util.Arrays;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import se.jesperolsson.capsyl.depth.Depth;
import se.jesperolsson.capsyl.depth.NullDepth;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.Encapsulatee;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.NullEncapsulatee;

/**
 * Tests for {@link TreeEncapsulatees}.
 *
 * @since 0.1
 */
public class TreeEncapsulateesTest {

    /**
     * Given that one object is created with varargs,
     * Given that another object is created with a collection,
     * When the objects are asked if they are equal,
     * Then it answer should be affirmative.
     */
    @Test
    public void streamMembers() {
        final Depth depth = new NullDepth();
        final Encapsulatee member = new NullEncapsulatee();
        MatcherAssert.assertThat(
            new TreeEncapsulatees(depth, Arrays.asList(member)),
            CoreMatchers.equalTo(
                new TreeEncapsulatees(depth, member)
            )
        );
    }
}
