/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.representation.DotEncapsulatees;
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

    /**
     * When the factory is asked to create an encapsulatee medium,
     * Then it should return a Dot encapsulatee medium.
     */
    @Test
    public void provideEncapsulateeMedium() {
        MatcherAssert.assertThat(
            new se.jesperolsson.capsyl.encapsulation.encapsulatee.representation.DotMedium(),
            CoreMatchers.instanceOf(new DotFactory().encapsulatee().getClass())
        );
    }

    /**
     * When the factory is asked to create an encapsulatees medium,
     * Then it should return a Dot encapsulatees medium.
     */
    @Test
    public void provideEncapsulateesMedium() {
        MatcherAssert.assertThat(
            new DotEncapsulatees(),
            CoreMatchers.equalTo(new DotFactory().encapsulatees())
        );
    }
}
