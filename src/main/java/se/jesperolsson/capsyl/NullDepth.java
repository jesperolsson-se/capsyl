package se.jesperolsson.capsyl;

/**
 * Null object for depth representation.
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
    public boolean equals(Object obj) {
        return obj instanceof NullDepth;
    }
}
