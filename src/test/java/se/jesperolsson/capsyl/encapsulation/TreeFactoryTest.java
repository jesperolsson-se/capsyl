/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.representation.EncapsulateeTreeMedium;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.representation.TreeEncapsulatees;
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

    /**
     * When the factory is asked to create an encapsulatee medium,
     * Then it should return a Tree encapsulatee medium.
     */
    @Test
    public void provideEncapsulateeMedium() {
        MatcherAssert.assertThat(
            new EncapsulateeTreeMedium(),
            CoreMatchers.equalTo(new TreeFactory().encapsulatee())
        );
    }

    /**
     * When the factory is asked to create an encapsulatees medium,
     * Then it should return a Tree encapsulatees medium.
     */
    @Test
    public void provideEncapsulateesMedium() {
        MatcherAssert.assertThat(
            new TreeEncapsulatees(),
            CoreMatchers.equalTo(new TreeFactory().encapsulatees())
        );
    }
}
