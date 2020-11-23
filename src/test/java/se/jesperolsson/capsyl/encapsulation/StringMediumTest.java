package se.jesperolsson.capsyl.encapsulation;

import com.github.javaparser.ast.expr.Expression;
import org.junit.Test;
import se.jesperolsson.capsyl.Depth;
import se.jesperolsson.capsyl.NullDepth;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StringMediumTest {

    /**
     * When the object is asked to represent a parameter,
     * Then it should return a copy of itself that contains that parameter.
     */
    @Test
    public void representParameter() {
        Depth depth = mock(Depth.class);
        Expression parameter = mock(Expression.class);
        Medium actual = new StringMedium(depth, parameter);
        Medium sut = new StringMedium(depth).representParameter(parameter);
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
        Depth depth = mock(Depth.class);
        Medium child = mock(Medium.class);
        List<Medium> children = Arrays.asList(child);
        Medium actual = new StringMedium(depth, null, children);
        Medium sut = new StringMedium(depth).representChild(child);
        assertEquals(actual, sut);
    }

    @Test
    public void printItself() {
        String depthText = " ";
        Depth depth = mock(Depth.class);
        when(depth.print()).thenReturn(depthText);
        FakeConstructor parameter = new FakeConstructor();
        Medium sut = new StringMedium(depth, parameter);
        assertEquals(depthText + "Ctor: " + parameter.getTypeAsString(), sut.print());
    }
}
