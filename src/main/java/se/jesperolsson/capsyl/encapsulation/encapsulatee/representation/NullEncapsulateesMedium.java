/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee.representation;

import java.util.Collection;
import lombok.EqualsAndHashCode;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.Encapsulatee;

/**
 * Null object for a encapsulatees medium.
 *
 * @since 0.1
 */
@EqualsAndHashCode
public final class NullEncapsulateesMedium implements EncapsulateesMedium {

    @Override
    public EncapsulateesMedium withMembers(final Collection<Encapsulatee> collective) {
        return new NullEncapsulateesMedium();
    }

    @Override
    public String print() {
        return "";
    }
}
