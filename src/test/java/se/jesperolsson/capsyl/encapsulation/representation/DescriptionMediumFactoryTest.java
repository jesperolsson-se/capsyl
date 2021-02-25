/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.representation;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * Tests for {@link DescriptionMediumFactory}.
 *
 * @since 0.1
 */
public class DescriptionMediumFactoryTest {

    /**
     * When the object is given a specification of DOT,
     * Then it should construct DOT media.
     */
    @Test
    public void constructDot() {
        MatcherAssert.assertThat(
            new DotMedium(),
            CoreMatchers.equalTo(
                new DescriptionMediumFactory().create()
            )
        );
    }

    /**
     * When the object is given a specification of tree,
     * Then it should construct tree media.
     */
    @Test
    public void constructTree() {
        MatcherAssert.assertThat(
            new TreeMedium(),
            CoreMatchers.equalTo(
                new DescriptionMediumFactory("tree").create()
            )
        );
    }

    /**
     * When the object is given an unknown specification,
     * Then it should construct null media.
     */
    @Test
    public void constructNull() {
        MatcherAssert.assertThat(
            new NullMedium(),
            CoreMatchers.equalTo(
                new DescriptionMediumFactory("gibberish").create()
            )
        );
    }
}
