package xyz.mdou.quickstart.functional;

public class RecursiveFactorial {
    static InCall obj;

    public static void main(String[] args) {
        obj = n -> n == 0 ? 1 : n * obj.call(n - 1);
        for (int i = 0; i < 10; i++) {
            System.out.println(obj.call(i));
        }
    }
}
