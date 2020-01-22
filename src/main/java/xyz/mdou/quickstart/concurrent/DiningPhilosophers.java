package xyz.mdou.quickstart.concurrent;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class DiningPhilosophers {

    private Philosopher[] philosophers;
    private StickHolder[] holders;

    private DiningPhilosophers(int n) {
        philosophers = new Philosopher[n];
        holders = new StickHolder[n];
        Arrays.setAll(holders, i -> new StickHolder());
        Arrays.setAll(philosophers, i -> new Philosopher(i, holders[i], holders[(i + 1) % n]));
        Arrays.stream(philosophers).forEach(CompletableFuture::runAsync);
    }

    public static void main(String[] args) throws InterruptedException {
        new DiningPhilosophers(2);
        new NapTask.Nap(3);
        Thread.currentThread().join();
    }
}
