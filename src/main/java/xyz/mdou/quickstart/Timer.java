package xyz.mdou.quickstart;

public class Timer {

    private long start;

    public Timer() {
        start = System.nanoTime();
    }

    public long duration() {
        return (System.nanoTime() - start) / 1000000;
    }
}
