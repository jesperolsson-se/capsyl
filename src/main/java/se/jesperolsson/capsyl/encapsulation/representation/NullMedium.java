/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.representation;

import lombok.EqualsAndHashCode;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.Encapsulatee;
import se.jesperolsson.capsyl.name.Name;

/**
 * Null object for a medium.
 *
 * @since 0.1
 */
@EqualsAndHashCode
public final class NullMedium implements Medium {

    @Override
    public Medium representEncapsulatee(final Encapsulatee encapsulatee) {
        return new NullMedium();
    }

    @Override
    public Medium representName(final Name name) {
        return new NullMedium();
    }

    @Override
    public String print() {
        return "";
    }
}
