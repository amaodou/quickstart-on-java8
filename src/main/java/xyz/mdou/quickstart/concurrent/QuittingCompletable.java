package xyz.mdou.quickstart.concurrent;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QuittingCompletable {
    public static void main(String[] args) {
        List<QuittableTask> ts = IntStream.range(0, 100)
                .mapToObj(QuittableTask::new)
                .collect(Collectors.toList());
        List<CompletableFuture<Void>> futures = ts.stream()
                .map(CompletableFuture::runAsync)
                .collect(Collectors.toList());
        new NapTask.Nap(1);
        ts.forEach(QuittableTask::quit);
        futures.forEach(CompletableFuture::join);
    }
}
