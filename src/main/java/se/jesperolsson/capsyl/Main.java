package se.jesperolsson.capsyl;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {

        new VoidVisitorStarter(
                new File(
                        args.length >= 1
                                ? args[0]
                                : "src/main/java/se/jesperolsson/capsyl/App.txt"
                )
        ).print();
    }
}
