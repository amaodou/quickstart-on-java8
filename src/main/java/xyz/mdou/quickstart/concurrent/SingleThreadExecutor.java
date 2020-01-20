package xyz.mdou.quickstart.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        IntStream.range(0, 10).mapToObj(i -> new NapTask()).forEach(executorService::execute);
        System.out.println("All tasks submitted");
        executorService.shutdown();

        while (!executorService.isTerminated()) {
            System.out.println(
                    Thread.currentThread().getName()+
                            " awaiting termination");
            new NapTask.Nap(1);
        }
    }
}
