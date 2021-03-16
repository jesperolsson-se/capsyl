/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import se.jesperolsson.capsyl.encapsulation.representation.DotMedium;

/**
 * Tests for {@link DotFactory}.
 *
 * @since 0.1
 */
public class DotFactoryTest {

    /**
     * When the factory is asked to create an encapsulation medium,
     * Then it should return a Dot encapsulation medium.
     */
    @Test
    public void provideEncapsulationMedium() {
        MatcherAssert.assertThat(
            new DotMedium(),
            CoreMatchers.equalTo(new DotFactory().encapsulation())
        );
    }
}
