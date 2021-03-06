/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl;

import java.io.File;
import java.io.IOException;
import se.jesperolsson.capsyl.encapsulation.MediaFactory;

/**
 * Main entry point to Capsyl. Exemplifies usage.
 *
 * @since 0.1
 */
public final class Main {

    /**
     * The encapsulations that should be visualized.
     */
    private final Javacode encaps;

    /**
     * Constructs a Capsyl program for the specified file.
     * @param path A path to a file containing Java source code.
     * @param description The description of the preferred output format.
     */
    public Main(final String path, final String description) {
        this(new File(path), new DescriptionFormatFactory(description).create());
    }

    /**
     * Constructs a Capsyl program for the specified file.
     * @param file A file containing Java source code.
     * @param factory The factory to create media from.
     */
    public Main(final File file, final MediaFactory factory) {
        this(new JavacodeFile(file, factory));
    }

    /**
     * Constructs a Capsyl program for the specified encapsulations.
     * @param encaps The encapsulations.
     */
    public Main(final Javacode encaps) {
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
        String outformat = "dot";
        if (args.length >= 2) {
            outformat = args[1];
        }
        System.out.println(new Main(path, outformat).execute());
    }

    /**
     * Asks Capsyl to execute its instructions.
     * @return A textual representation of the encapsulations.
     * @throws IOException If the user-supplied path is inaccessible.
     */
    public String execute() throws IOException {
        return this.encaps.encapsulations().asText();
    }
}
