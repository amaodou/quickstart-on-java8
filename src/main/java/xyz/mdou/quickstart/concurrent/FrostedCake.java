package xyz.mdou.quickstart.concurrent;

import java.util.concurrent.CompletableFuture;

class Frosting {
    static CompletableFuture<Frosting> make() {
        new NapTask.Nap(1);
        return CompletableFuture.completedFuture(new Frosting());
    }
}

public class FrostedCake {

    @Override
    public String toString() {
        return "FrostedCake";
    }

    public FrostedCake(Baked baked, Frosting frosting) {
        new NapTask.Nap(1);
    }

    public static void main(String[] args) {
        Baked.batch()
                .forEach(
                        baked -> baked.thenCombineAsync(Frosting.make(), FrostedCake::new)
                                .thenAcceptAsync(System.out::println)
                                .join()
                );

    }
}
