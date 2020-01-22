package xyz.mdou.quickstart.concurrent;

public class CatchCompletableExceptions {

    static void handleException(int failCount) {
        CompletableExceptions.test("exceptionally", failCount).exceptionally(e -> {
            if (e == null) {
                System.out.println("exceptionally not found exception");
            }
            return new Breakable(e.getMessage(), 0);
        }).thenAccept(r -> System.out.println("exceptionally result: " + r));

        CompletableExceptions.test("handle", failCount).handle((b, e) -> {
            if (e != null) {
                return "handle exception of " + e.getMessage();
            } else {
                return "handle ok";
            }
        }).thenAccept(str -> System.out.println("handle result: " + str));

        CompletableExceptions.test("whenComplete", failCount).whenComplete((b, e) -> {
            if (e != null) {
                System.out.println("whenComplete exception of " + e.getMessage());
            } else {
                System.out.println("whenComplete ok");
            }
        }).thenAccept(r -> System.out.println("whenComplete result: " + r));
    }

    public static void main(String[] args) {
        System.out.println("**** Failure Mode ****");
        handleException(2);
        System.out.println("**** Success Mode ****");
        handleException(0);
    }
}
