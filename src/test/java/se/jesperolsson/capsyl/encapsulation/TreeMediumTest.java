package se.jesperolsson.capsyl.encapsulation;

import org.junit.Test;
import se.jesperolsson.capsyl.depth.Depth;
import se.jesperolsson.capsyl.depth.NullDepth;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class TreeMediumTest {

    /**
     * When the object is asked to represent a parameter,
     * Then it should return a copy of itself that contains that parameter.
     */
    @Test
    public void representParameter() {
        Depth depth = new NullDepth();
        Encapsulatee encapsulatee = mock(Encapsulatee.class);
        Medium actual = new TreeMedium(depth, encapsulatee);
        Medium sut = new TreeMedium(depth).representEncapsulatee(encapsulatee);
        assertEquals(actual, sut);
    }

    /**
     * When the object is asked for a representation of the next level in the encapsulation hierarchy,
     * Then it should return a medium with the next depth level.
     */
    @Test
    public void provideNextLevel() {
        Depth depth = new NullDepth();
        Medium actual = new TreeMedium(depth.next());
        Medium sut = new TreeMedium(depth).nextLevel();
        assertEquals(actual, sut);
    }

    /**
     * When the object is asked to represent a child,
     * Then it should return a copy of itself that contains that child.
     */
    @Test
    public void representChild() {
        Depth depth = new NullDepth();
        Medium child = mock(Medium.class);
        List<Medium> children = Arrays.asList(child);
        Medium actual = new TreeMedium(depth, new NullEncapsulatee(), children);
        Medium sut = new TreeMedium(depth).representChild(child);
        assertEquals(actual, sut);
    }

    /**
     * When the object is asked to print itself,
     * Then it should answer with its depth and its encapsulatee.
     */
    @Test
    public void printItself() {
        Depth depth = new NullDepth();
        NullEncapsulatee encapsulatee = new NullEncapsulatee();
        Medium sut = new TreeMedium(depth, encapsulatee);
        assertEquals(depth.print() + encapsulatee.name(), sut.print());
    }
}
