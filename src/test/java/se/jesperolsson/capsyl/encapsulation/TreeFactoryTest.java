/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import se.jesperolsson.capsyl.encapsulation.representation.TreeMedium;

/**
 * Tests for {@link TreeFactory}.
 *
 * @since 0.1
 */
public class TreeFactoryTest {

    /**
     * When the factory is asked to create an encapsulation medium,
     * Then it should return a Tree encapsulation medium.
     */
    @Test
    public void provideEncapsulationMedium() {
        MatcherAssert.assertThat(
            new TreeMedium(),
            CoreMatchers.equalTo(new TreeFactory().encapsulation())
        );
    }
}
