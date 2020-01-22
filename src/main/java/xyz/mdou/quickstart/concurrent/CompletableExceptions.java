package xyz.mdou.quickstart.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableExceptions {

    public static CompletableFuture<Breakable> test(String id, int failCount) {
        return CompletableFuture.completedFuture(new Breakable(id, failCount))
                .thenApply(Breakable::work)
                .thenApply(Breakable::work)
                .thenApply(Breakable::work)
                .thenApply(Breakable::work);
    }

    public static void main(String[] args) {
        test("A", 1);
        test("B", 2);
        test("C", 3);
        test("D", 4);
        test("E", 5);
        try {
            System.out.println(test("F", 3).get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(test("H", 2).isDone());
        System.out.println(test("G", 3).isCompletedExceptionally());
        CompletableFuture<Integer> cf = new CompletableFuture<>();
        System.out.println(cf.isDone());
        cf.completeExceptionally(new RuntimeException("forced"));
        try {
            System.out.println(cf.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
