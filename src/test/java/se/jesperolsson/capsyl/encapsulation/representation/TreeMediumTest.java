/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.representation;

import java.util.Arrays;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import se.jesperolsson.capsyl.depth.Depth;
import se.jesperolsson.capsyl.depth.NullDepth;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.Encapsulatee;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.NullEncapsulatee;

/**
 * Tests for {@link TreeMedium}.
 *
 * @since 0.1
 */
public class TreeMediumTest {

    /**
     * When the object is asked to represent a parameter,
     * Then it should return a copy of itself that contains that parameter.
     */
    @Test
    public void representParameter() {
        final Depth depth = new NullDepth();
        final Encapsulatee encapsulatee = new NullEncapsulatee();
        MatcherAssert.assertThat(
            new TreeMedium(depth, encapsulatee),
            CoreMatchers.equalTo(new TreeMedium(depth).representEncapsulatee(encapsulatee))
        );
    }

    /**
     * When the object is asked for a representation
     * of the next level in the encapsulation hierarchy,
     * Then it should return a medium with the next depth level.
     */
    @Test
    public void provideNextLevel() {
        final Depth depth = new NullDepth();
        MatcherAssert.assertThat(
            new TreeMedium(depth.next()),
            CoreMatchers.equalTo(new TreeMedium(depth).nextLevel())
        );
    }

    /**
     * When the object is asked to represent a child,
     * Then it should return a copy of itself that contains that child.
     */
    @Test
    public void representChild() {
        final Depth depth = new NullDepth();
        final Medium child = new NullMedium();
        final List<Medium> children = Arrays.asList(child);
        MatcherAssert.assertThat(
            new TreeMedium(depth, new NullEncapsulatee(), children),
            CoreMatchers.equalTo(new TreeMedium(depth).representChild(child))
        );
    }

    /**
     * When the object is asked to print itself,
     * Then it should answer with its depth and its encapsulatee.
     */
    @Test
    public void printItself() {
        final Depth depth = new NullDepth();
        final NullEncapsulatee encapsulatee = new NullEncapsulatee();
        final Medium sut = new TreeMedium(depth, encapsulatee);
        MatcherAssert.assertThat(
            depth.print() + encapsulatee.represent().print(),
            CoreMatchers.equalTo(sut.print())
        );
    }
}
