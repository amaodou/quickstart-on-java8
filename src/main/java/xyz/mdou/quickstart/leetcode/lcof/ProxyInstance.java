package xyz.mdou.quickstart.leetcode.lcof;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class ProxyInstance {

    interface Animal {
        String getName();
    }

    public <T> T proxy(Class<?> clazz) {
        return (T) Proxy.newProxyInstance(
                ProxyInstance.class.getClassLoader(),
                new Class[]{clazz},
                (proxy, method, args) -> "proxy run " + method.getName());
    }

    @Test
    public void test() {
        System.out.println(((Animal) proxy(Animal.class)).getName());
    }
}
