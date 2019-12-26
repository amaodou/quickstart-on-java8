package xyz.mdou.quickstart.functional;

import java.util.function.IntSupplier;

/**
 * 为什么变量 i 被修改编译器却没有报错呢。 它既不是 final 的，也不是等同 final 效果的。
 * 因为 i 是外围类的成员，所以这样做肯定是安全的（除非你正在创建共享可变内存的多个函数）。
 */
class Closure1 {
    int i;

    IntSupplier getInt(int x) {
        return () -> x + i++;
    }
}

public class SharedStorage {

    public static void main(String[] args) {
        Closure1 c = new Closure1();
        System.out.println(c.getInt(0).getAsInt());
        System.out.println(c.getInt(0).getAsInt());
        System.out.println(c.getInt(0).getAsInt());
    }
}
