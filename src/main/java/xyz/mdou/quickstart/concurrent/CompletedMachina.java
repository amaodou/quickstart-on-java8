package xyz.mdou.quickstart.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletedMachina {

    public static void main(String[] args) {
        CompletableFuture<Machina> future = CompletableFuture.completedFuture(new Machina(0));
        try {
            Machina m = future.get();
            System.out.println(m);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
