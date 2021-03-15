/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl;

import java.util.Locale;
import se.jesperolsson.capsyl.encapsulation.representation.DotMedium;
import se.jesperolsson.capsyl.encapsulation.representation.Medium;
import se.jesperolsson.capsyl.encapsulation.representation.NullMedium;
import se.jesperolsson.capsyl.encapsulation.representation.TreeMedium;

/**
 * Realizes a factory that will determine the media based on the provided description.
 *
 * @since 0.1
 */
public final class DescriptionFormatFactory implements FormatFactory {

    /**
     * A string representing a description of an output format.
     */
    private final String description;

    /**
     * Constructs a factory with a default description.
     */
    public DescriptionFormatFactory() {
        this("DOT");
    }

    /**
     * Constructs a factory with a particular description.
     * @param description A specification of the preferred output format.
     */
    public DescriptionFormatFactory(final String description) {
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
