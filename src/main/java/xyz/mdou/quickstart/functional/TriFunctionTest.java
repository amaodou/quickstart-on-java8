package xyz.mdou.quickstart.functional;

@FunctionalInterface
interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}

public class TriFunctionTest {

    static int fun(int i, long l, double d) {
        return 99;
    }

    public static void main(String[] args) {
        TriFunction<Integer, Long, Double, Integer> tif = TriFunctionTest::fun;
        tif.apply(1, 2L, 3D);

        tif = (i, l, d) -> 12;
    }
}
