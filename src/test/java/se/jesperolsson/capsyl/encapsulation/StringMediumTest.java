package se.jesperolsson.capsyl.encapsulation;

import org.junit.Test;
import se.jesperolsson.capsyl.Depth;
import se.jesperolsson.capsyl.NullDepth;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class StringMediumTest {

    /**
     * When the object is asked to represent a parameter,
     * Then it should return a copy of itself that contains that parameter.
     */
    @Test
    public void representParameter() {
        Depth depth = new NullDepth();
        Encapsulatee encapsulatee = mock(Encapsulatee.class);
        Medium actual = new StringMedium(depth, encapsulatee);
        Medium sut = new StringMedium(depth).representParameter(encapsulatee);
        assertEquals(actual, sut);
    }

    /**
     * When the object is asked for a representation of the next level in the encapsulation hierarchy,
     * Then it should return a medium with the next depth level.
     */
    @Test
    public void provideNextLevel() {
        Depth depth = new NullDepth();
        Medium actual = new StringMedium(depth.next());
        Medium sut = new StringMedium(depth).nextLevel();
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
        Medium actual = new StringMedium(depth, null, children);
        Medium sut = new StringMedium(depth).representChild(child);
        assertEquals(actual, sut);
    }

    @Test
    public void printItself() {
        Depth depth = new NullDepth();
        NullEncapsulatee parameter = new NullEncapsulatee();
        Medium sut = new StringMedium(depth, parameter);
        assertEquals(depth.print() + "Param: " + parameter.name(), sut.print());
    }
}
