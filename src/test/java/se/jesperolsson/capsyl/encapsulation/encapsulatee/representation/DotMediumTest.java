/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee.representation;

import java.util.Arrays;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.mockito.Mockito;
import se.jesperolsson.capsyl.depth.Depth;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.Encapsulatee;

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
            new DotMedium(),
            CoreMatchers.equalTo(
                new DotMedium().withDepth(
                    new Depth() {

                        @Override
                        public Depth next() {
                            return null;
                        }

                        @Override
                        public String print() {
                            return null;
                        }
                    }
                )
            )
        );
    }

    /**
     * When the object is asked to represent a child,
     * Then it should return a copy of itself that contains that child.
     */
    @Test
    public void representChild() {
        final Encapsulatee encapsulatee = new Encapsulatee() {
            @Override
            public Medium represent(final Medium medium) {
                return null;
            }
        };
        MatcherAssert.assertThat(
            new DotMedium("", Arrays.asList(encapsulatee)),
            CoreMatchers.equalTo(
                new DotMedium().representChild(encapsulatee)
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
            new DotMedium(name),
            CoreMatchers.equalTo(
                new DotMedium().representName(name)
            )
        );
    }

    /**
     * When the object doesn't have children and is asked to print itself,
     * Then the result should equal its name.
     */
    @Test
    public void childlessPrint() {
        final String name = "Bar";
        MatcherAssert.assertThat(
            name,
            CoreMatchers.equalTo(
                new DotMedium(name).print()
            )
        );
    }

    /**
     * When the object doesn't have children and is asked to print itself,
     * Then the result should equal its name.
     */
    @Test
    public void familyPrint() {
        final Encapsulatee child = Mockito.mock(Encapsulatee.class);
        final Medium medium = Mockito.mock(Medium.class);
        Mockito.when(medium.print()).thenReturn("Bepa");
        Mockito.when(child.represent(Mockito.any(Medium.class))).thenReturn(medium);
        MatcherAssert.assertThat(
            new DotMedium("Apa", Arrays.asList(child)).print()
            .matches(this.subgraphRegex()),
            CoreMatchers.is(true)
        );
    }

    private String subgraphRegex() {
        return new StringBuilder()
            .append("subgraph \"cluster ")
            .append(this.identifierRegex())
            .append('\"')
            .append(" \\{ label=\"Apa\" Bepa }")
            .toString();
    }

    private String identifierRegex() {
        return "[a-z0-9]{8}-[a-z0-9]{4}-[a-z0-9]{4}-[a-z0-9]{4}-[a-z0-9]{12}";
    }
}
