package xyz.mdou.quickstart.functional;

import java.util.function.BiConsumer;

class In1 {}

class In2 {}

public class MethodConversion {

    private static void accept(In1 arg1, In2 arg2) {
        System.out.println("accept()");
    }

    private static void xyz(In1 arg1, In2 arg2) {
        System.out.println("xyz()");
    }

    public static void main(String[] args) {
        BiConsumer<In1, In2> bic = MethodConversion::accept;
        bic.accept(new In1(), new In2());

        bic = MethodConversion::xyz;
        bic.accept(new In1(), new In2());
    }
}
