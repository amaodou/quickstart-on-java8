package xyz.mdou.quickstart.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class ThrowsChecked {
    static ThrowsChecked noCheck(ThrowsChecked tc) {
        return tc;
    }

    static ThrowsChecked withChecked(ThrowsChecked tc) throws Checked {
        return tc;
    }

    static void testStream() {
        Stream.of(new ThrowsChecked())
                .map(ThrowsChecked::noCheck)
//                .map(ThrowsChecked::withChecked)
                .map(tc -> {
                    try {
                        return ThrowsChecked.withChecked(tc);
                    } catch (Checked checked) {
                        throw new RuntimeException(checked);
                    }
                }).forEach(System.out::println);
    }

    static void testCompletableFuture() {
        CompletableFuture.completedFuture(new ThrowsChecked())
                .thenApply(ThrowsChecked::noCheck)
//                .thenApply(ThrowsChecked::withChecked)
                .thenApply(tc -> {
                    try {
                        return ThrowsChecked.withChecked(tc);
                    } catch (Checked checked) {
                        throw new RuntimeException(checked);
                    }
                });
    }

    class Checked extends Exception {
    }
}
