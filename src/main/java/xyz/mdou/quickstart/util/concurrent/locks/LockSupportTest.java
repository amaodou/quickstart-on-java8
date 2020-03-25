package xyz.mdou.quickstart.util.concurrent.locks;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;
import java.util.stream.IntStream;

public class LockSupportTest {

    private AtomicBoolean locked = new AtomicBoolean(false);
    private Queue<Thread> waits = new ConcurrentLinkedQueue<>();

    public void lock() {
        boolean interrupted = false;
        Thread thread = Thread.currentThread();
        waits.add(thread);
        while (waits.peek() != thread
                || !locked.compareAndSet(false, true)) {
            System.out.println(String.format("%s get lock failed, park thread.", thread.getName()));
            LockSupport.parkNanos(this, TimeUnit.SECONDS.toNanos(1));
            if (thread.isInterrupted()) {
                interrupted = true;
            }
        }
        System.out.println(String.format("%s get lock success.", thread.getName()));
        waits.poll();
        if (interrupted) {
            thread.interrupt();
        }
    }

    public void unLock() {
        locked.compareAndSet(true, false);
        LockSupport.unpark(waits.peek());
    }

    @Test
    public void test() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(0, 100).forEach(i -> executorService.submit(() -> {
                    lock();
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        unLock();
                    }
                }
        ));
        TimeUnit.SECONDS.sleep(10);
    }
}
