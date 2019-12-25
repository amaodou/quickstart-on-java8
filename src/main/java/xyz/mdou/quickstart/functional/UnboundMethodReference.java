package xyz.mdou.quickstart.functional;

class X {
    String f() {
        return "X::f";
    }
}

interface MakeString {
    String make();
}

interface TransformX {
    String transform(X x);
}

public class UnboundMethodReference {

    public static void main(String[] args) {
        MakeString ms = new X()::f;
        System.out.println(ms.make());

        TransformX tx = X::f;
        System.out.println(tx.transform(new X()));
    }
}
