package org.example;

import java.util.concurrent.CountDownLatch;

public class Philosopher extends Thread {
    private final String name;
    private final int leftFork;
    private final int rightFork;
    private int countEat;
    private final CountDownLatch cdl;
    private final Table table;

    public Philosopher(String name, Table table, int leftFork, int rightFork, CountDownLatch cdl) {
        this.table = table;
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.cdl = cdl;
        countEat = 0;
    }

    @Override
    public void run() {

        while (countEat < 3) {
            try {
                thinking();
                eating();
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }
        }

        System.out.println(name + " полностью наелся");
        cdl.countDown();
    }

    private void eating() throws InterruptedException {
        if (table.tryGetForks(leftFork, rightFork)) {
            System.out.println(name + " ест вилками: " + leftFork
                    + " и " + rightFork);
            sleep(500);
            table.putForks(leftFork, rightFork);
            System.out.println(name + " поел. " +
                    "Вернул вилки " + leftFork + " и " + rightFork);
            countEat++;
        }
    }

    private void thinking() throws InterruptedException {
        sleep(500);
    }
}
