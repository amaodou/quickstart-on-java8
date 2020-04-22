package xyz.mdou.quickstart.util.concurrent.locks;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class VolatileTest {

    private int sum = 0;

    public void incr() {
        sum++;
    }

    @Test
    public void test() throws InterruptedException {
        int j = 0;
        while (j < 10) {
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.submit(() -> IntStream.range(0, 5).forEach(i -> incr()));
            executorService.submit(() -> IntStream.range(0, 5).forEach(i -> incr()));
            executorService.submit(() -> IntStream.range(0, 5).forEach(i -> incr()));
            executorService.submit(() -> IntStream.range(0, 5).forEach(i -> incr()));
            executorService.submit(() -> IntStream.range(0, 5).forEach(i -> incr()));
            TimeUnit.SECONDS.sleep(3);
            System.out.println(sum);
            j++;
            sum = 0;
        }
    }
}
