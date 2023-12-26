package org.example;

public class Main {
    public static void main(String[] args) {

        funOne();
        System.out.println();
        funTwo();
        System.out.println();
        funTree();
    }

    static void funOne() {
        double[] results = {
                Calculator.sum(2, 6),
                Calculator.multiply(9, 3),
                Calculator.divide(4, 8),
                Calculator.subtract(13, 1)};

        roundingUp(results);
    }

    static void roundingUp(double[] results) {
        for (double result : results) {
            if ((result * 10) % 10 == 0 && (result * 100) % 100 == 0) {
                System.out.println((int) result);
            } else {
                System.out.printf("%.2f%n", result);
            }
        }
    }

    static void funTwo() {
        String[] stringArray1 = new String[6];
        Integer[] intArray1 = new Integer[5];
        boolean result = Calculator.compareArrays(intArray1, stringArray1);
        System.out.println(result);
    }

    static void funTree() {
        Pair<String, Integer> pair = new Pair<>("Строка", 10);
        System.out.println("First = " + pair.first());
        System.out.println("Second = " + pair.second());
        System.out.println("Pair = " + pair);
    }
}
