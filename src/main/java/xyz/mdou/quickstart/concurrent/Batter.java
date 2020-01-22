package xyz.mdou.quickstart.concurrent;

import java.util.concurrent.CompletableFuture;

public class Batter {
    public static <T> T prepare(T t) {
        new NapTask.Nap(1);
        return t;
    }

    public static <T> CompletableFuture<T> pre(T t) {
        return CompletableFuture.completedFuture(t).thenApplyAsync(Batter::prepare);
    }

    public static CompletableFuture<Batter> mix() {
        CompletableFuture.allOf(
                pre(new Eggs()),
                pre(new Milk()),
                pre(new Sugar()),
                pre(new Flour())
        ).join();
        new NapTask.Nap(1);
        return CompletableFuture.completedFuture(new Batter());
    }

    static class Eggs {}

    static class Milk {}

    static class Sugar {}

    static class Flour {}
}
