/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.name;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * Tests for {@link Mononym}.
 *
 * @since 0.1
 */
public class MononymTest {

    /**
     * Given a name text
     * When the object is asked to print itself,
     * Then it should return the text.
     */
    @Test
    public void printName() {
        final String name = "Foo";
        MatcherAssert.assertThat(
            new Mononym(name).print(),
            CoreMatchers.equalTo(name)
        );
    }
}
