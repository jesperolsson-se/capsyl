/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee.representation;

import java.util.Arrays;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import se.jesperolsson.capsyl.depth.Depth;
import se.jesperolsson.capsyl.depth.NullDepth;

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

    /**
     * When the object is asked to represent a child,
     * Then it should return a copy of itself that contains that child.
     */
    @Test
    public void representChild() {
        final String name = "";
        final Depth depth = new NullDepth();
        final Medium child = new NullMedium();
        final List<Medium> children = Arrays.asList(child);
        MatcherAssert.assertThat(
            new TreeMedium(name, depth, children),
            CoreMatchers.equalTo(new TreeMedium(name, depth).representChild(child))
        );
    }

    /**
     * When the object is asked for a representation
     * of the next level in the encapsulation hierarchy,
     * Then it should return a medium with the next depth level.
     */
    @Test
    public void provideNextLevel() {
        final String name = "";
        final Depth depth = new NullDepth();
        MatcherAssert.assertThat(
            new TreeMedium(name, depth.next()),
            CoreMatchers.equalTo(new TreeMedium(name, depth).nextLevel())
        );
    }
}
