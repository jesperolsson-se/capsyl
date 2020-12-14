/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee.representation;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

public class TreeMediumTest {

    /**
     * Given a name,
     * When the object is asked to print itself,
     * Then it should respond with an unchanged copy of itself.
     */
    @Test
    public void disregardName() {
        final String name = "Foo";
        MatcherAssert.assertThat(
            new TreeMedium(name),
            CoreMatchers.equalTo(
                new TreeMedium().representName(name)
            )
        );
    }
}
