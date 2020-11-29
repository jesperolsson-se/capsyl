/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl;

import java.io.File;
import java.io.FileNotFoundException;
import se.jesperolsson.capsyl.encapsulation.Encapsulations;

/**
 * Main entry point to Capsyl. Exemplifies usage.
 *
 * @since 0.1
 */
public final class Main {

    /**
     * The encapsulations that should be visualized.
     */
    private final Encapsulations encaps;

    /**
     * Constructs a Capsyl program for the specified file.
     * @param path A path to a file containing Java source code.
     * @throws FileNotFoundException If the path is invalid.
     */
    public Main(final String path) throws FileNotFoundException {
        this(new File(path));
    }

    /**
     * Constructs a Capsyl program for the specified file.
     * @param file A file containing Java source code.
     * @throws FileNotFoundException If the file cannot be accessed.
     */
    public Main(final File file) throws FileNotFoundException {
        this(new Encapsulations(file));
    }

    /**
     * Constructs a Capsyl program for the specified encapsulations.
     * @param encaps The encapsulations.
     */
    public Main(final Encapsulations encaps) {
        this.encaps = encaps;
    }

    /**
     * Asks Capsyl to print encapsulations to stdout.
     * @param args Optional sequence of arguments.
     *  First item specifies the path to the Java code to visualize.
     * @throws Exception If the path is invalid.
     */
    @SuppressWarnings("PMD.SystemPrintln")
    public static void main(final String... args) throws Exception {
        String path = "src/main/java/se/jesperolsson/capsyl/App.txt";
        if (args.length >= 1) {
            path = args[0];
        }
        System.out.println(new Main(path).execute());
    }

    /**
     * Asks Capsyl to execute its instructions.
     * @return A textual representation of the encapsulations.
     */
    public String execute() {
        return this.encaps.asText();
    }
}
