package se.jesperolsson.capsyl.encapsulation;

/**
 * Null object for an encapsulatee.
 */
public final class NullEncapsulatee implements Encapsulatee {

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return "";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof NullEncapsulatee;
    }
}
