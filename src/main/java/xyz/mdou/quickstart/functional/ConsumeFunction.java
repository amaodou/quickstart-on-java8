package xyz.mdou.quickstart.functional;

import java.util.function.Function;

class One {}
class Two {}

public class ConsumeFunction {
    static Two generateTwo(Function<One, Two> oneTwo) {
        return oneTwo.apply(new One());
    }
    public static void main(String[] args) {
        Two two = generateTwo(one -> new Two());
    }
}
