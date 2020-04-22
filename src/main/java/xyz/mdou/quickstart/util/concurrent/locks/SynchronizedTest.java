package xyz.mdou.quickstart.util.concurrent.locks;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SynchronizedTest {

    int sum = 0;

    public synchronized void incr() throws InterruptedException {
        int i = 1;
        while (i < 10) {
            sum += 1;
            System.out.println(String.format("%s do incr %d, %d",
                    Thread.currentThread().getName(), i, sum));
            if (i % 2 == 0) {
                desc();
            }
            i++;
        }
    }

    public synchronized void desc() throws InterruptedException {
        sum -= 1;
        System.out.println(String.format("%s do desc %d",
                Thread.currentThread().getName(), sum));
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void test() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        IntStream.range(0, 2).forEach(i -> executorService.submit(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                incr();
            }
        }));
        TimeUnit.SECONDS.sleep(15);
    }
}
