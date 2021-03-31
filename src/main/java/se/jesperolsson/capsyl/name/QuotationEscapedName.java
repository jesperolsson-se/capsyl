/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.name;

import lombok.EqualsAndHashCode;

/**
 * Decorator for escaping quotation marks.
 *
 * @since 0.1
 */
@EqualsAndHashCode
public final class QuotationEscapedName implements Name {

    /**
     * The name to decorate.
     */
    private final Name origin;

    /**
     * Constructs a decorator that escapes any quotation marks contained in the
     * original name.
     *
     * @param origin The name to decorate.
     */
    public QuotationEscapedName(final Name origin) {
        this.origin = origin;
    }

    @Override
    public String print() {
        return this.origin.print().replace("\"", "\\\"");
    }
}
