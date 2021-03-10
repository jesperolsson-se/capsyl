/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee.representation;

import java.util.Arrays;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import se.jesperolsson.capsyl.depth.Depth;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.Encapsulatees;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.SimpleEncapsulatees;

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
        final Encapsulatees children = new SimpleEncapsulatees(
            Arrays.asList(
                medium -> null
            )
        );
        MatcherAssert.assertThat(
            new DotMedium("", children),
            CoreMatchers.equalTo(
                new DotMedium().representChildren(children)
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
     * Given the absence of children,
     * When the object is asked to print itself,
     * Then the result should equal its name.
     */
    @Test
    public void childlessPrint() {
        final String name = "Bar";
        MatcherAssert.assertThat(
            new DotMedium(name).print()
            .matches(this.identifierRegex(name)),
            CoreMatchers.is(true)
        );
    }

    /**
     * Given the presence of one or more children,
     * When the object is asked to print itself,
     * Then the result should match the subgraph regex.
     */
    @Test
    public void familyPrint() {
        final String parent = "Apa";
        final String child = "Bepa";
        MatcherAssert.assertThat(
            new DotMedium(
                parent,
                new SimpleEncapsulatees(
                    Arrays.asList(
                        medium -> medium.representName(child)
                    )
                )
            ).print()
            .matches(
                this.subgraphRegex(
                    parent,
                    new StringBuilder()
                        .append(this.identifierRegex(child))
                        .toString()
                )
            ),
            CoreMatchers.is(true)
        );
    }

    /**
     * Given the presence of two children with the same name,
     * When the object is asked to print itself,
     * Then the result should make the children unique.
     */
    @Test
    public void differentiateTwins() {
        final String parent = "Parent";
        final String twin = "Twin";
        MatcherAssert.assertThat(
            new DotMedium(
                parent,
                new SimpleEncapsulatees(
                    Arrays.asList(
                        medium -> medium.representName(twin),
                        medium -> medium.representName(twin)
                    )
                )
            ).print()
                .matches(
                    this.subgraphRegex(
                        parent,
                        new StringBuilder()
                        .append(this.identifierRegex(twin))
                        .append(' ')
                        .append(this.identifierRegex(twin))
                        .toString()
                    )
                ),
            CoreMatchers.is(true)
        );
    }

    private String subgraphRegex(final String name, final String contents) {
        return new StringBuilder()
            .append("subgraph \"cluster ")
            .append(this.identifierRegex())
            .append('\"')
            .append(" \\{ ")
            .append("label=\"")
            .append(name)
            .append('\"')
            .append(' ')
            .append(contents)
            .append(" }")
            .toString();
    }

    private String identifierRegex(final String name) {
        return new StringBuilder()
            .append('"')
            .append(this.identifierRegex())
            .append('"')
            .append("\\[label=\"")
            .append(name)
            .append("\"\\]")
            .toString();
    }

    private String identifierRegex() {
        return "[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}";
    }
}
