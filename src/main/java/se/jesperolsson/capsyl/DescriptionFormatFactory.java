/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl;

import java.util.Locale;
import se.jesperolsson.capsyl.encapsulation.DotFactory;
import se.jesperolsson.capsyl.encapsulation.MediaFactory;
import se.jesperolsson.capsyl.encapsulation.NullFactory;
import se.jesperolsson.capsyl.encapsulation.TreeFactory;

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
    public MediaFactory create() {
        final MediaFactory result;
        switch (this.description.toLowerCase(Locale.ROOT)) {
            case "dot":
                result = new DotFactory();
                break;
            case "tree":
                result = new TreeFactory();
                break;
            default:
                result = new NullFactory();
                break;
        }
        return result;
    }
}
