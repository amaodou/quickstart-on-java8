package xyz.mdou.quickstart.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class StickHolder {

    private static class Chopstick {}

    private Chopstick stick = new Chopstick();

    private BlockingQueue<Chopstick> queue = new LinkedBlockingQueue<>(1);

    public StickHolder() {
        putDown();
    }

    public Chopstick pickUp() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void putDown() {
        try {
            queue.put(stick);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
