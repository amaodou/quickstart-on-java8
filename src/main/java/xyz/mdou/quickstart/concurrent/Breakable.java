package xyz.mdou.quickstart.concurrent;

import java.util.StringJoiner;

public class Breakable {
    private String id;
    private int failCount;

    Breakable(String id, int failCount) {
        this.id = id;
        this.failCount = failCount;
    }

    public static Breakable work(Breakable b) {
        if (--b.failCount == 0) {
            System.out.println("Throwing Exception for " + b.id + "");
            throw new RuntimeException("Breakable_" + b.id + " failed");
        }
        System.out.println(b);
        return b;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Breakable.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("failCount=" + failCount)
                .toString();
    }
}
