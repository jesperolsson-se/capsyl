/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee;

import lombok.EqualsAndHashCode;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.representation.Medium;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.representation.NullMedium;

/**
 * Null object for an encapsulatee.
 *
 * @since 0.1
 */
@EqualsAndHashCode
public final class NullEncapsulatee implements Encapsulatee {

    @Override
    public Medium represent() {
        return new NullMedium();
    }
}
