/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.depth;

import lombok.EqualsAndHashCode;

/**
 * Null object for depth representation.
 *
 * @since 0.1
 */
@EqualsAndHashCode
public final class NullDepth implements Depth {

    @Override
    public Depth next() {
        return new NullDepth();
    }

    @Override
    public String print() {
        return "";
    }
}
