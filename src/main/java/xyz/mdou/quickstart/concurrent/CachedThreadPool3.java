package xyz.mdou.quickstart.concurrent;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CachedThreadPool3 {

    static int getFuture(Future<Integer> future) {
        try {
            return future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<CountingTask> tasks = IntStream.range(0, 100)
                .mapToObj(CountingTask::new)
                .collect(Collectors.toList());
        try {
            List<Future<Integer>> futures = executorService.invokeAll(tasks);
            int sum = futures.stream().map(CachedThreadPool3::getFuture).reduce(0, Integer::sum);
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
