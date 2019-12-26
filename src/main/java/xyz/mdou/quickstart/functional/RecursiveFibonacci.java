package xyz.mdou.quickstart.functional;

interface InCallK {
    int call(int arg);
}

public class RecursiveFibonacci {
    static InCallK fib;

    RecursiveFibonacci() {
        fib = n -> n == 0 ? 0 : n == 1 ? 1 : fib.call(n - 1) + fib.call(n - 2);
    }

    public int fibonacci(int n) {
        return fib.call(n);
    }

    public static void main(String[] args) {
        RecursiveFibonacci fib = new RecursiveFibonacci();
        for (int i = 0; i < 10; i++) {
            System.out.println(fib.fibonacci(i));
        }
    }
}
