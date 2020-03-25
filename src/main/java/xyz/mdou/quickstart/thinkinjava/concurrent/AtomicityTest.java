package xyz.mdou.quickstart.thinkinjava.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable {

    private volatile int value = 0;

    public int getValue() {
        return value;
    }

    private synchronized void increment() {
        value++;
        value++;
    }

    @Override
    public void run() {
        while (true) {
            increment();
        }
    }

    public static void main(String[] args) {
        AtomicityTest task = new AtomicityTest();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(task);
        while (true) {
            int val = task.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
