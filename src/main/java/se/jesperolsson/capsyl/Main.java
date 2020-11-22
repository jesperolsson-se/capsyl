package se.jesperolsson.capsyl;

import se.jesperolsson.capsyl.encapsulation.Encapsulation;
import se.jesperolsson.capsyl.encapsulation.Encapsulations;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {

        Iterable<Encapsulation> encapsulations = new Encapsulations(
                new File(
                        args.length >= 1
                                ? args[0]
                                : "src/main/java/se/jesperolsson/capsyl/App.txt"
                )
        ).asIterable();

        for(Encapsulation encapsulation : encapsulations) {
            System.out.println(encapsulation.represent());
        }
    }
}
