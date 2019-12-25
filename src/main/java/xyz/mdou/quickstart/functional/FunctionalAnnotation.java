package xyz.mdou.quickstart.functional;

@FunctionalInterface
interface Functional {
    String hello(String s);
}

interface FunctionalNon {
    String hello(String s);
}

public class FunctionalAnnotation {
    String concatHello(String s) {
        return "Hello, " + s;
    }

    public static void main(String[] args) {
        FunctionalAnnotation fa = new FunctionalAnnotation();
        Functional f = fa::concatHello;
        System.out.println(f.hello("jeklly"));

        FunctionalNon fn = fa::concatHello;
        System.out.println(fn.hello("jeklly"));
    }
}
