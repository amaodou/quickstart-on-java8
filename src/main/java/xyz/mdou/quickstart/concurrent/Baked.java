package xyz.mdou.quickstart.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class Baked {
    static class Pan {}

    static Pan pan(Batter batter) {
        new NapTask.Nap(1);
        return new Pan();
    }

    static Baked heat(Pan pan) {
        new NapTask.Nap(1);
        return new Baked();
    }

    static CompletableFuture<Baked> bake(CompletableFuture<Batter> cfb) {
        return cfb.thenApplyAsync(Baked::pan).thenApplyAsync(Baked::heat);
    }

    public static Stream<CompletableFuture<Baked>> batch() {
        CompletableFuture cfb = Batter.mix();
        return Stream.of(bake(cfb), bake(cfb), bake(cfb), bake(cfb));
    }
}
