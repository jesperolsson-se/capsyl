/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation;

import lombok.EqualsAndHashCode;
import se.jesperolsson.capsyl.encapsulation.representation.Medium;
import se.jesperolsson.capsyl.encapsulation.representation.NullMedium;

/**
 * Realizes a factory that will produce Null media.
 *
 * @since 0.1
 */
@EqualsAndHashCode
public final class NullFactory implements MediaFactory {

    @Override
    public Medium encapsulation() {
        return new NullMedium();
    }

    @Override
    public se.jesperolsson.capsyl.encapsulation.encapsulatee.representation.Medium encapsulatee() {
        return new se.jesperolsson.capsyl.encapsulation.encapsulatee.representation.NullMedium();
    }
}
