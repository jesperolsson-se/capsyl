/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.representation;

import java.util.Locale;

/**
 * Realizes a factory that will determine the media based on the provided description.
 *
 * @since 0.1
 */
public final class DescriptionMediumFactory implements MediumFactory {

    /**
     * A string representing a description of an output format.
     */
    private final String description;

    /**
     * Constructs a factory with a default description.
     */
    public DescriptionMediumFactory() {
        this("DOT");
    }

    /**
     * Constructs a factory with a particular description.
     * @param description A specification of the preferred output format.
     */
    public DescriptionMediumFactory(final String description) {
        this.description = description;
    }

    @Override
    public Medium create() {
        final Medium result;
        switch (this.description.toLowerCase(Locale.ROOT)) {
            case "dot":
                result = new DotMedium();
                break;
            case "tree":
                result = new TreeMedium();
                break;
            default:
                result = new NullMedium();
                break;
        }
        return result;
    }
}
