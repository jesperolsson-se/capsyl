/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee.representation;

import java.util.Collections;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.mockito.Mockito;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.Encapsulatee;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.NullEncapsulatee;

/**
 * Tests for {@link DotEncapsulatees}.
 *
 * @since 0.1
 */
public class DotEncapsulateesTest {

    /**
     * Given that one object is created with default values,
     * Given that another object is created with a empty collection,
     * When the objects are asked if they are equal,
     * Then it answer should be affirmative.
     */
    @Test
    public void defaultToNullCollection() {
        MatcherAssert.assertThat(
            new DotEncapsulatees(),
            CoreMatchers.equalTo(
                new DotEncapsulatees().withMembers(Collections.emptyList())
            )
        );
    }

    /**
     * Given that one object is created with varargs,
     * Given that another object is created with a collection,
     * When the objects are asked if they are equal,
     * Then it answer should be affirmative.
     */
    @Test
    public void streamMembers() {
        final String expected = "Foo";
        final Medium medium = Mockito.mock(Medium.class);
        Mockito.when(medium.print()).thenReturn(expected);
        final Encapsulatee member = Mockito.mock(Encapsulatee.class);
        Mockito.when(member.represent()).thenReturn(medium);
        MatcherAssert.assertThat(
            new DotEncapsulatees(member).print(),
            CoreMatchers.equalTo(expected)
        );
    }

    /**
     * Given two or more members,
     * When the object is asked to print itself,
     * Then it should print the members, separated by a space.
     */
    @Test
    public void spaceSeparateMembers() {
        final Encapsulatee first = new NullEncapsulatee();
        final Encapsulatee second = new NullEncapsulatee();
        MatcherAssert.assertThat(
            new DotEncapsulatees(first, second).print(),
            CoreMatchers.equalTo(first.represent().print() + ' ' + second.represent().print())
        );
    }
}
