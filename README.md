# capsyl
Capsyl aims to be an aid for comprehending object-oriented programs.
Specifically, it's a tool for visualizing Java objects' encapsulations.

This concept is examplified [here](https://github.com/jesperolsson-se/FizzBuzz-OCP-Challenge/blob/main/src/main/java/org/example/rearrange/positive/fizzBuzz.svg).
What we see is a variable, fizzBuzz, whose value is a `Priority` object. This
Priority encapsulates an `Echo` object and a `Contatenation` object, which
in turn encapsulates a `Buzz` and a `Fizz` object. The corresponding source
code is written on [this line](https://github.com/jesperolsson-se/FizzBuzz-OCP-Challenge/blob/main/src/main/java/org/example/rearrange/positive/App.java#L13).
