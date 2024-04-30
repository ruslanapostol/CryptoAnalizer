package org.javarush.apostol.cryptoanalizer.util;


import java.nio.file.Path;
import java.nio.file.Paths;

public class PathBuilder {

    private Path path;

    public PathBuilder(String initialPath) {
        this.path = Paths.get(initialPath);
    }

    public PathBuilder add(String part) {
        path = path.resolve(part);
        return this;
    }

    public String build() {
        return path.toString();
    }
}

