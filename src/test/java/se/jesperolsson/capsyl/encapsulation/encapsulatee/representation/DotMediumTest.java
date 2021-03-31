/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee.representation;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.mockito.Mockito;
import se.jesperolsson.capsyl.depth.NullDepth;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.Encapsulatees;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.NullEncapsulatees;
import se.jesperolsson.capsyl.name.Name;
import se.jesperolsson.capsyl.name.NullName;
import se.jesperolsson.capsyl.name.QuotationEscapedName;

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
            CoreMatchers.equalTo(new DotMedium(() -> "", new NullName(), new NullEncapsulatees()))
        );
    }

    /**
     * When the object is asked to represent a name,
     * Then the result should be a copy of the object that also contains an
     * quotation mark-escaped version of the name.
     */
    @Test
    public void representName() {
        final Name name = new NullName();
        MatcherAssert.assertThat(
            new DotMedium(() -> "").representName(name),
            CoreMatchers.equalTo(
                new DotMedium(
                    () -> "",
                    new QuotationEscapedName(name),
                    new NullEncapsulatees()
                )
            )
        );
    }

    /**
     * Given a name that contains quotation marks,
     * When the object is asked to print itself,
     * Then the response should have escaped the quotation marks.
     */
    @Test
    public void escapeQuotationMarks() {
        MatcherAssert.assertThat(
            new DotMedium(() -> "", new NullName(), new NullEncapsulatees())
                .representName(() -> "\"Apa\"")
                .print(),
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
        MatcherAssert.assertThat(
            new DotMedium(() -> "ID", () -> "NAME", new NullEncapsulatees()).print(),
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
        MatcherAssert.assertThat(
            new DotMedium(() -> "123", () -> "Foo", encaps).print(),
            CoreMatchers.equalTo("subgraph \"cluster 123\" { label=\"Foo\" CHILDREN }")
        );
    }
}
