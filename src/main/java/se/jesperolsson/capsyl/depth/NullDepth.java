/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.depth;

/**
 * Null object for depth representation.
 *
 * @since 0.1
 */
public final class NullDepth implements Depth {

    @Override
    public Depth next() {
        return new NullDepth();
    }

    @Override
    public String print() {
        return "";
    }

    @Override
    public boolean equals(final Object obj) {
        return obj instanceof NullDepth;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
