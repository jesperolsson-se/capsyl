/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee.representation;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import se.jesperolsson.capsyl.depth.NullDepth;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.Encapsulatees;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.NullEncapsulatees;
import se.jesperolsson.capsyl.identification.Identity;

/**
 * Tests for {@link DotMedium}.
 *
 * @since 0.1
 */
public class DotMediumTest {

    /**
     * When the object is asked to represent a depth,
     * Then the result should be an unaltered DotMedium.
     */
    @Test
    public void ignoreDepthRepresentation() {
        MatcherAssert.assertThat(
            new DotMedium().withDepth(new NullDepth()),
            CoreMatchers.equalTo(new DotMedium())
        );
    }

    /**
     * When the object is asked to represent encapsulatees,
     * Then the result should be a copy of the object that also contains the encapsulatees.
     */
    @Test
    public void representEncapsulatees() {
        MatcherAssert.assertThat(
            new DotMedium().representChildren(new NullEncapsulatees()),
            CoreMatchers.equalTo(new DotMedium("", new NullEncapsulatees()))
        );
    }

    /**
     * When the object is asked to represent a name,
     * Then the result should be a copy of the object that also contains the name.
     */
    @Test
    public void representName() {
        MatcherAssert.assertThat(
            new DotMedium().representName(""),
            CoreMatchers.equalTo(new DotMedium(""))
        );
    }

    /**
     * Given a name that contains quotation marks,
     * When the object is asked to print itself,
     * Then the response should have escaped the quotation marks.
     */
    @Test
    @Ignore
    public void escapeQuotationMarks() {
        final String name = "\"Apa\"";
        final Identity id = () -> "";
        MatcherAssert.assertThat(
            new DotMedium(name, new NullEncapsulatees(), id).print(),
            CoreMatchers.equalTo("\"\"[label=\"\\\"Apa\\\"\"]")
        );
    }

    /**
     * Given an absence of children,
     * When the object is asked to print itself,
     * Then the result should not be a cluster.
     */
    @Test
    public void printChildfree() {
        final String name = "NAME";
        final Identity id = () -> "ID";
        MatcherAssert.assertThat(
            new DotMedium(name, new NullEncapsulatees(), id).print(),
            CoreMatchers.equalTo("\"ID\"[label=\"NAME\"]")
        );
    }

    /**
     * Given a presence of children,
     * When the object is asked to print itself,
     * Then the result should be a cluster.
     */
    @Test
    public void printCluster() {
        final String name = "Foo";
        final EncapsulateesMedium medium = Mockito.mock(EncapsulateesMedium.class);
        Mockito.when(medium.print()).thenReturn("CHILDREN");
        final Encapsulatees encaps = new Encapsulatees() {
            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public EncapsulateesMedium represent() {
                return medium;
            }
        };
        final Identity id = () -> "123";
        MatcherAssert.assertThat(
            new DotMedium(name, encaps, id).print(),
            CoreMatchers.equalTo("subgraph \"cluster 123\" { label=\"Foo\" CHILDREN }")
        );
    }
}
