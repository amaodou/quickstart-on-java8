package xyz.mdou.quickstart.concurrent;

import java.util.concurrent.CompletableFuture;

public class DualCompletableOperations {

    private static CompletableFuture<Workable> cfA;
    private static CompletableFuture<Workable> cfB;

    static void init() {
        cfA = Workable.make("A", 2);
        cfB = Workable.make("B", 1);
    }

    static void join() {
        cfA.join();
        cfB.join();
        System.out.println("*****************");
    }

    public static void main(String[] args) {
        init();
        CompletableUtilities.voidr(cfA.runAfterEitherAsync(cfB, () -> System.out.println("runAfterEither")));
        join();
        init();
        CompletableUtilities.voidr(cfA.runAfterBothAsync(cfB, () -> System.out.println("runAfterBothAsync")));
        join();
        init();
        CompletableUtilities.showr(cfA.applyToEitherAsync(cfB, w -> {
            System.out.println("applyToEitherAsync " + w);
            return w;
        }));
        join();
        init();
        CompletableUtilities.voidr(cfA.acceptEitherAsync(cfB, w -> {
            System.out.println("acceptEitherAsync " + w);
        }));
        join();
        init();
        CompletableUtilities.voidr(cfA.thenAcceptBothAsync(cfB, (w1, w2) -> {
            System.out.println("thenAcceptBothAsync");
        }));
        join();
        init();
        CompletableUtilities.showr(cfA.thenCombineAsync(cfB, (w1, w2) -> {
            System.out.println("thenCombineAsync");
            return w1;
        }));
        join();
        init();
        CompletableFuture<Workable> cfC = Workable.make("C", 3);
        CompletableFuture<Workable> cfD = Workable.make("D", 4);
        CompletableUtilities.voidr(CompletableFuture.allOf(cfA, cfB, cfC, cfD));
        join();

        init();
        cfC = Workable.make("C", 3);
        cfD = Workable.make("D", 4);
        CompletableUtilities.showr(CompletableFuture.anyOf(cfA, cfB, cfC, cfD));
        join();
    }
}
