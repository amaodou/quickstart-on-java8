package xyz.mdou.quickstart.util.concurrent;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ScheduledThreadPoolExecutorTest {

    @Test
    public void testFixRateExecutor() throws InterruptedException {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2,
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        AtomicInteger scheduleCount = new AtomicInteger(0);
        scheduledThreadPoolExecutor.schedule(() -> {
            System.out.println(String.format("%s schedule print %d", Thread.currentThread().getName(), scheduleCount.incrementAndGet()));
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 1, TimeUnit.SECONDS);

        AtomicInteger fixedRateCount = new AtomicInteger(0);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
            System.out.println(String.format("%s scheduleAtFixedRate print %d", Thread.currentThread().getName(), fixedRateCount.incrementAndGet()));
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 1, 1, TimeUnit.SECONDS);

        TimeUnit.SECONDS.sleep(15);
    }
}
