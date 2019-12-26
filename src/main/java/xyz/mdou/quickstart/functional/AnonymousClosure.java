package xyz.mdou.quickstart.functional;

import java.util.function.IntSupplier;

public class AnonymousClosure {
    IntSupplier f(int x) {
        int i = 0;
        return new IntSupplier() {
            @Override
            public int getAsInt() {
                return x + i;
            }
        };
    }
}
