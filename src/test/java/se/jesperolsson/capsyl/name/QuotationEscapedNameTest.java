/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.name;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * Tests for {@link QuotationEscapedName}.
 *
 * @since 0.1
 */
public class QuotationEscapedNameTest {

    /**
     * Given an origin that contains quotation marks,
     * When the decorator is asked to print,
     * Then the quotation marks should be escaped.
     */
    @Test
    public void escapeQuotationMarks() {
        final Name name = () -> "\"Foo\"";
        MatcherAssert.assertThat(
            new QuotationEscapedName(name).print(),
            CoreMatchers.equalTo("\\\"Foo\\\"")
        );
    }
}
