[![EO principles respected here](https://www.elegantobjects.org/badge.svg)](https://www.elegantobjects.org)

[![Mutation testing badge](https://img.shields.io/endpoint?style=flat&url=https%3A%2F%2Fbadge-api.stryker-mutator.io%2Fgithub.com%2Fjesperolsson-se%2Fcapsyl%2Fmain)](https://dashboard.stryker-mutator.io/reports/github.com/jesperolsson-se/capsyl/main)
[![CI](https://github.com/jesperolsson-se/capsyl/actions/workflows/pull_request.yml/badge.svg)](https://github.com/jesperolsson-se/capsyl/actions/workflows/pull_request.yml)
[![CD](https://github.com/jesperolsson-se/capsyl/actions/workflows/main.yml/badge.svg)](https://github.com/jesperolsson-se/capsyl/actions/workflows/main.yml)
[![Docker](https://img.shields.io/docker/v/jesperolssonse/capsyl/latest)](https://hub.docker.com/repository/docker/jesperolssonse/capsyl)

**Capsyl** visualizes encapsulation hierarchies in Java, simplifying the
comprehension of object-oriented programs.

```Java
Rule fizzBuzz = new Priority(
    new Concatenation(
        new Fizz(),
        new Buzz()
    ),
    new Echo()
);
```

<img src="https://github.com/jesperolsson-se/FizzBuzz-OCP-Challenge/blob/main/src/main/java/org/example/rearrange/positive/fizzBuzz.svg"/>

# Usage

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

## Recognized encapsulations

Capsyl assumes the encapsulations are on the form of, e.g.,

```Java
Foo foo = new Apa(new Apa(new Bepa(3), 2), 1);
```

or 

```Java
Foo foo;
foo = new Cepa(new Depa(), new Epa());
```

## Output formats

Capsyl can visualize encapsulations either as a
[DOT](https://en.wikipedia.org/wiki/DOT_%28graph_description_language%29)
graph (`-e FORMAT=dot`) or a simple hierarchy (`-e FORMAT=tree`).

