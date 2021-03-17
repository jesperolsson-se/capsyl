/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.representation;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.Encapsulatee;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.NullEncapsulatee;

/**
 * Tests for {@link DotMedium}.
 *
 * @since 0.1
 */
public class DotMediumTest {

    /**
     * When the object is constructed without a name,
     * Then it default to calling itself "Var".
     */
    @Test
    public void offerADefaultName() {
        MatcherAssert.assertThat(
            new DotMedium(),
            CoreMatchers.equalTo(
                new DotMedium(new NullEncapsulatee(), "Var")
            )
        );
    }

    /**
     * When the object is asked to represent a name,
     * Then it should return a copy of itself that contains that name.
     */
    @Test
    public void representName() {
        final String name = "Foo";
        MatcherAssert.assertThat(
            new DotMedium(new NullEncapsulatee(), name),
            CoreMatchers.equalTo(
                new DotMedium().representName(name)
            )
        );
    }

    /**
     * When the object is asked to represent an encapsulatee,
     * Then it should return a copy of itself that contains that encapsulatee.
     */
    @Test
    public void representEncapsulatee() {
        final Encapsulatee encapsulatee = new NullEncapsulatee();
        MatcherAssert.assertThat(
            new DotMedium(encapsulatee),
            CoreMatchers.equalTo(
                new DotMedium().representEncapsulatee(encapsulatee)
            )
        );
    }

    /**
     * When the object is asked to print itself,
     * Then it should return a correct DOT representation.
     */
    @Test
    public void printItself() {
        MatcherAssert.assertThat(
            "graph { label=\"Var\"  }",
            CoreMatchers.equalTo(
                new DotMedium().print()
            )
        );
    }
}
