package org.example;

public record Pair<T, U>(T first, U second) {

    @Override
    public String toString() {
        return first.toString() + ", " + second.toString();
    }
}
