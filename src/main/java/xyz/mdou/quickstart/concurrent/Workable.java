package xyz.mdou.quickstart.concurrent;

import java.util.StringJoiner;
import java.util.concurrent.CompletableFuture;

public class Workable {

    private String id;
    private int duration;

    Workable(String id, int duration) {
        this.id = id;
        this.duration = duration;
    }

    public static Workable work(Workable w) {
        new NapTask.Nap(w.duration);
        w.id = w.id + "W";
        System.out.println(w);
        return w;
    }

    public static CompletableFuture<Workable> make(String id, int duration) {
        return CompletableFuture.completedFuture(new Workable(id, duration))
                .thenApplyAsync(Workable::work);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Workable.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("duration=" + duration)
                .toString();
    }
}
