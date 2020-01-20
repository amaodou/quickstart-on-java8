package xyz.mdou.quickstart.concurrent;

import java.util.stream.IntStream;

public class InterferingTask implements Runnable {

    private int id;
    private static int sum;

    InterferingTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        IntStream.range(0, 1000).forEach(i -> sum += 1);
        System.out.println(id + " " + Thread.currentThread().getName() + " " + sum);
    }

}
