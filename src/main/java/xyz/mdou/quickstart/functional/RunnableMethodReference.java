package xyz.mdou.quickstart.functional;

/**
 * 函数式编程中的静态方法引用
 */
class Go {
    static void go() {
        System.out.println("Go::go");
    }
}

public class RunnableMethodReference {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread::start");
            }
        }).start();

        new Thread(() -> System.out.println("lambda")).start();

        new Thread(Go::go).start();
    }
}
