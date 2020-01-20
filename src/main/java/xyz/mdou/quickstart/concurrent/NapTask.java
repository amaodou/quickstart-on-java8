package xyz.mdou.quickstart.concurrent;

import java.util.concurrent.TimeUnit;

public class NapTask implements Runnable {

    @Override
    public void run() {
        new Nap(1);
        System.out.println(Thread.currentThread().getName());
    }

    static class Nap {

        Nap(long time) {
            try {
                TimeUnit.SECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
