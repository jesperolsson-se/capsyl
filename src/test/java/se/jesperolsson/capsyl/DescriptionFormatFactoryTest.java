/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import se.jesperolsson.capsyl.encapsulation.representation.DotMedium;
import se.jesperolsson.capsyl.encapsulation.representation.NullMedium;
import se.jesperolsson.capsyl.encapsulation.representation.TreeMedium;

/**
 * Tests for {@link DescriptionFormatFactory}.
 *
 * @since 0.1
 */
public class DescriptionFormatFactoryTest {

    /**
     * When the object is given a specification of DOT,
     * Then it should construct DOT media.
     */
    @Test
    public void constructDot() {
        MatcherAssert.assertThat(
            new DotMedium(),
            CoreMatchers.equalTo(
                new DescriptionFormatFactory().create()
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
                new DescriptionFormatFactory("tree").create()
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
                new DescriptionFormatFactory("gibberish").create()
            )
        );
    }
}
