/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import se.jesperolsson.capsyl.encapsulation.DotFactory;
import se.jesperolsson.capsyl.encapsulation.NullFactory;
import se.jesperolsson.capsyl.encapsulation.TreeFactory;

/**
 * Tests for {@link DescriptionFormatFactory}.
 *
 * @since 0.1
 */
public class DescriptionFormatFactoryTest {

    /**
     * When the object is given a specification of DOT,
     * Then it should construct a DOT factory.
     */
    @Test
    public void constructDot() {
        MatcherAssert.assertThat(
            new DescriptionFormatFactory().create(),
            CoreMatchers.equalTo(
                new DotFactory()
            )
        );
    }

    /**
     * When the object is given a specification of tree,
     * Then it should construct a tree media factory.
     */
    @Test
    public void constructTree() {
        MatcherAssert.assertThat(
            new DescriptionFormatFactory("tree").create(),
            CoreMatchers.equalTo(
                new TreeFactory()
            )
        );
    }

    /**
     * When the object is given an unknown specification,
     * Then it should construct a null media factory.
     */
    @Test
    public void constructNull() {
        MatcherAssert.assertThat(
            new DescriptionFormatFactory("gibberish").create(),
            CoreMatchers.equalTo(
                new NullFactory()
            )
        );
    }
}
