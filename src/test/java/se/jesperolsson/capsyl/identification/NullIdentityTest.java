/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.identification;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * Tests for {@link NullIdentity}.
 *
 * @since 0.1
 */
public class NullIdentityTest {

    /**
     * When the object is asked to print itself,
     * Then it should return the empty string.
     */
    @Test
    public void printNothing() {
        MatcherAssert.assertThat(
            "",
            CoreMatchers.equalTo(new NullIdentity().print())
        );
    }
}
