package xyz.mdou.quickstart.concurrent;

import xyz.mdou.quickstart.Timer;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableApply {

    public static void main(String[] args) {
        Timer timer = new Timer();
        CompletableFuture<Machina> cf = CompletableFuture.completedFuture(new Machina(0));
        CompletableFuture<Machina> cf2 = cf.thenApply(Machina::work);
        CompletableFuture<Machina> cf3 = cf2.thenApply(Machina::work);
        CompletableFuture<Machina> cf4 = cf3.thenApply(Machina::work);
        CompletableFuture<Machina> cf5 = cf4.thenApply(Machina::work);
        System.out.println(timer.duration() + " ms");

        Timer timer1 = new Timer();
        CompletableFuture<Machina> cfx = CompletableFuture.completedFuture(new Machina(1))
                .thenApply(Machina::work)
                .thenApply(Machina::work)
                .thenApply(Machina::work)
                .thenApply(Machina::work);
        System.out.println(timer1.duration() + " ms");

        Timer timer2 = new Timer();
        CompletableFuture<Machina> cfx2 = CompletableFuture.completedFuture(new Machina(2))
                .thenApplyAsync(Machina::work)
                .thenApplyAsync(Machina::work)
                .thenApplyAsync(Machina::work)
                .thenApplyAsync(Machina::work);
        System.out.println(timer2.duration() + " ms");
        System.out.println(cfx2.join());
        System.out.println(timer2.duration() + " ms");
    }
}
