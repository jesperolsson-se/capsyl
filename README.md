[![EO principles respected here](https://www.elegantobjects.org/badge.svg)](https://www.elegantobjects.org)

# capsyl
Capsyl aims to be an aid for comprehending object-oriented programs.
Specifically, it's a tool for visualizing Java objects' encapsulations.

This concept is examplified [here](https://github.com/jesperolsson-se/FizzBuzz-OCP-Challenge/blob/main/src/main/java/org/example/rearrange/positive/fizzBuzz.svg).
What we see is a variable, fizzBuzz, whose value is a `Priority` object. This
Priority encapsulates an `Echo` object and a `Concatenation` object, which
in turn encapsulates a `Buzz` and a `Fizz` object. The corresponding source
code is written on [this line](https://github.com/jesperolsson-se/FizzBuzz-OCP-Challenge/blob/main/src/main/java/org/example/rearrange/positive/App.java#L13).

## Usage

Pull the latest image from Docker Hub.

```
docker pull jesperolssonse/capsyl:latest
```

Then, run the container.

```
docker run -v $(pwd)/IO:/IO capsyl
```

That's it! You'll find the result in `IO/output`. If you want to change the
input, simply replace `IO/input` or choose a different locatation as volume.

The current version of Capsyl can visualize the encapsulations of objects,
provided that they are on the form of, e.g.,

`Foo foo = new Apa(new Apa(new Bepa(3), 2), 1);`

or 

```
Foo foo;
foo = new Cepa(new Depa(), new Epa());
```

Currently, Capsyl can visualize these either as a [DOT](https://en.wikipedia.org/wiki/DOT_%28graph_description_language%29)
graphs (`-e FORMAT=dot`) or a simple hierarchy (`-e FORMAT=tree`).

