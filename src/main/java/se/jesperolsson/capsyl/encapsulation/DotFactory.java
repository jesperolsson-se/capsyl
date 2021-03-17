/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation;

import lombok.EqualsAndHashCode;
import se.jesperolsson.capsyl.encapsulation.representation.DotMedium;
import se.jesperolsson.capsyl.encapsulation.representation.Medium;

/**
 * Realizes a factory that will produce media for the DOT format.
 *
 * @since 0.1
 */
@EqualsAndHashCode
public final class DotFactory implements MediaFactory {

    @Override
    public Medium encapsulation() {
        return new DotMedium();
    }

    @Override
    public se.jesperolsson.capsyl.encapsulation.encapsulatee.representation.Medium encapsulatee() {
        return new se.jesperolsson.capsyl.encapsulation.encapsulatee.representation.DotMedium();
    }
}
