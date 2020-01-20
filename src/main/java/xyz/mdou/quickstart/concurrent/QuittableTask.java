package xyz.mdou.quickstart.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;

public class QuittableTask implements Runnable {
    private int id;
    private AtomicBoolean running = new AtomicBoolean(true);

    QuittableTask(int id) {
        this.id = id;
    }

    public void quit() {
        boolean status = running.getAndSet(false);
        System.out.println(id + ": " + Thread.currentThread().getName() + ": " + status);
    }

    @Override
    public void run() {
        while (running.get()) {
            new NapTask.Nap(1);
        }
        System.out.print(id + " ");
    }
}
