/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee;

import lombok.EqualsAndHashCode;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.representation.EncapsulateesMedium;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.representation.NullEncapsulationsMedium;

/**
 * Null object for a collective of encapsulatees.
 *
 * @since 0.1
 */
@EqualsAndHashCode
public final class NullEncapsulatees implements Encapsulatees {

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public EncapsulateesMedium represent(final EncapsulateesMedium medium) {
        return new NullEncapsulationsMedium();
    }
}
