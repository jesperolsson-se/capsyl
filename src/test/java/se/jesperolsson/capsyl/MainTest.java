/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl;

import java.io.FileNotFoundException;
import org.junit.Assert;
import org.junit.Test;

/**
 * System tests.
 *
 * @since 0.1
 */
public class MainTest {

    /**
     * Given that Capsyl is constructed with the example file,
     * When the program is asked to execute,
     * Then it should output the encapsulations as a simple tree.
     * @throws FileNotFoundException Should never occur.
     */
    @Test
    public void outputSimpleTree() throws FileNotFoundException {
        final Main sut = new Main("src/main/java/se/jesperolsson/capsyl/App.txt");
        Assert.assertEquals(
            new StringBuilder()
            .append("Apa")
            .append(System.lineSeparator())
            .append("  Apa")
            .append(System.lineSeparator())
            .append("    Bepa")
            .append(System.lineSeparator())
            .append("      3")
            .append(System.lineSeparator())
            .append("    2")
            .append(System.lineSeparator())
            .append("  1")
            .append(System.lineSeparator())
            .append("Apa")
            .append(System.lineSeparator())
            .append("  Apa")
            .append(System.lineSeparator())
            .append("    Bepa")
            .append(System.lineSeparator())
            .append("      3")
            .append(System.lineSeparator())
            .append("    2")
            .append(System.lineSeparator())
            .append("  1")
            .toString(),
            sut.execute()
        );
    }
}
