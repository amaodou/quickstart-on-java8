package xyz.mdou.quickstart.concurrent;

import java.util.concurrent.Callable;

public class CountingTask implements Callable<Integer> {

    private int id;

    CountingTask(int id) {
        this.id = id;
    }

    @Override
    public Integer call() {
        int val = 0;
        for (int i = 0; i < 100; i++) {
            val += 1;
        }
        System.out.println(id + " " + Thread.currentThread().getName() + ": " + val);
        return val;
    }
}
