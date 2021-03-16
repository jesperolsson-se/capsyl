/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import se.jesperolsson.capsyl.encapsulation.representation.NullMedium;

/**
 * Tests for {@link NullFactory}.
 *
 * @since 0.1
 */
public class NullFactoryTest {

    /**
     * When the factory is asked to create an encapsulation medium,
     * Then it should return a Null encapsulation medium.
     */
    @Test
    public void provideEncapsulationMedium() {
        MatcherAssert.assertThat(
            new NullMedium(),
            CoreMatchers.equalTo(new NullFactory().encapsulation())
        );
    }
}
