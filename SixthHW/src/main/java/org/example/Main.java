package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int totalSteps = 1000;
        Map<Integer, Boolean> results = new HashMap<>();

        Random random = new Random();

        for (int i = 1; i <= totalSteps; i++) {
            int carPosition = random.nextInt(3);
            int playerChoice = random.nextInt(3);

            int doorWithGoat;
            do {
                doorWithGoat = random.nextInt(3);
            } while (doorWithGoat == carPosition || doorWithGoat == playerChoice);

            int newChoice;
            do {
                newChoice = random.nextInt(3);
            } while (newChoice == playerChoice || newChoice == doorWithGoat);

            boolean win = newChoice == carPosition;
            results.put(i, win);
        }

        int wins = 0;
        int losses = 0;
        for (boolean result : results.values()) {
            if (result) {
                wins++;
            } else {
                losses++;
            }
        }

        System.out.println("Победы: " + wins);
        System.out.println("Поражения: " + losses);
    }
}