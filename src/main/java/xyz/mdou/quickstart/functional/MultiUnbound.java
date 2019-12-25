package xyz.mdou.quickstart.functional;

// 非静态方法与多参数运用

interface TwoArgs {
    void call(This aThis, int i, int j);
}

interface ThreeArgs {
    void call(This aThis, int i, int j, int k);
}

class This {
    void twoArgs(int i, int j) {
        System.out.println(i + j);
    }

    void threeArgs(int i, int j, int k) {
        System.out.println(i + j + k);
    }
}

public class MultiUnbound {
    public static void main(String[] args) {
        This aThis = new This();

        TwoArgs twoArgs = This::twoArgs;
        twoArgs.call(aThis, 1, 2);

        ThreeArgs threeArgs = This::threeArgs;
        threeArgs.call(aThis, 1, 2, 3);
    }
}
