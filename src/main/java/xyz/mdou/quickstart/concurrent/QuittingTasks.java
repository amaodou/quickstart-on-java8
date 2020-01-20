package xyz.mdou.quickstart.concurrent;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QuittingTasks {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<QuittableTask> ts = IntStream.range(0, 100)
                .mapToObj(QuittableTask::new)
                .peek(executorService::submit)
                .collect(Collectors.toList());
        new NapTask.Nap(1);
        ts.forEach(QuittableTask::quit);
        executorService.shutdown();
    }
}
