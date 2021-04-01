/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.identification;

import lombok.EqualsAndHashCode;

/**
 * Null object for identity representation.
 *
 * @since 0.1
 */
@EqualsAndHashCode
public final class NullIdentity implements Identity {

    @Override
    public String print() {
        return "";
    }
}
