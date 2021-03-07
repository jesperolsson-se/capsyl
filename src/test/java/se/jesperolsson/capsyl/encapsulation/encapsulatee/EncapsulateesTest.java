/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * Tests for {@link Encapsulatees}.
 *
 * @since 0.1
 */
public class EncapsulateesTest {

    /**
     * Given that the collective is created without member,
     * When the object is asked to stream its members,
     * Then the result should be empty.
     */
    @Test
    public void streamNonexistentMembers() {
        MatcherAssert.assertThat(
            false,
            CoreMatchers.equalTo(
                new Encapsulatees()
                    .stream()
                    .findFirst()
                    .isPresent()
            )
        );
    }

    /**
     * Give that the collective is created with a singular member,
     * When the object is asked to stream its members,
     * Then the first entry should be that member.
     */
    @Test
    public void streamAllMembers() {
        final Encapsulatee encapsulatee = new NullEncapsulatee();
        MatcherAssert.assertThat(
            encapsulatee,
            CoreMatchers.equalTo(
                new Encapsulatees(encapsulatee)
                    .stream()
                    .findFirst()
                    .get()
            )
        );
    }
}
