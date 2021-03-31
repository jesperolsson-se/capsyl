/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.name;

import lombok.EqualsAndHashCode;

/**
 * Null object for name representation.
 *
 * @since 0.1
 */
@EqualsAndHashCode
public final class NullName implements Name {

    @Override
    public String print() {
        return "";
    }
}
