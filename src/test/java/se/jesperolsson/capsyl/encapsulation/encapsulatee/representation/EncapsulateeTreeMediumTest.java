/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee.representation;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import se.jesperolsson.capsyl.depth.Depth;
import se.jesperolsson.capsyl.depth.NullDepth;
import se.jesperolsson.capsyl.encapsulation.NullFactory;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.Encapsulatees;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.NullEncapsulatee;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.SimpleEncapsulatees;
import se.jesperolsson.capsyl.name.Name;
import se.jesperolsson.capsyl.name.NullName;

/**
 * Tests for {@link EncapsulateeTreeMedium}.
 *
 * @since 0.1
 */
public class EncapsulateeTreeMediumTest {

    /**
     * Given a name,
     * When the object is asked to print itself,
     * Then it should respond with an unchanged copy of itself.
     */
    @Test
    public void disregardName() {
        final Name name = new NullName();
        MatcherAssert.assertThat(
            new EncapsulateeTreeMedium(name),
            CoreMatchers.equalTo(
                new EncapsulateeTreeMedium().representName(name)
            )
        );
    }

    /**
     * When the object is asked to represent a child,
     * Then it should return a copy of itself that contains that child.
     */
    @Test
    public void representChild() {
        final Name name = new NullName();
        final Depth depth = new NullDepth();
        final Encapsulatees children = new SimpleEncapsulatees(
            new NullFactory(),
            new NullEncapsulatee()
        );
        MatcherAssert.assertThat(
            new EncapsulateeTreeMedium(name, depth, children),
            CoreMatchers.equalTo(
                new EncapsulateeTreeMedium(
                    name,
                    depth
                ).representChildren(children)
            )
        );
    }
}
