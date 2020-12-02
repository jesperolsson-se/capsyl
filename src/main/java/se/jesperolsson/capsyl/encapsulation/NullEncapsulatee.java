/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation;

import java.util.LinkedList;
import java.util.List;

/**
 * Null object for an encapsulatee.
 *
 * @since 0.1
 */
public final class NullEncapsulatee implements Encapsulatee {

    @Override
    public String name() {
        return "";
    }

    @Override
    public List<Encapsulatee> children() {
        return new LinkedList<>();
    }

    @Override
    public boolean equals(final Object obj) {
        return obj instanceof NullEncapsulatee;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
