package xyz.mdou.quickstart.functional;

class Dog {
    String name;
    int age;

    Dog() {
        this.name = "unKnow";
    }

    Dog(String name) {
        this.name = name;
    }

    Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

interface MakeNoArgs {
    Dog make();
}

interface Make1Args {
    Dog make(String s);
}

interface Make2Args {
    Dog make(String s, int age);
}

public class CtorReference {
    public static void main(String[] args) {
        MakeNoArgs makeNoArgs = Dog::new;
        makeNoArgs.make();

        Make1Args make1Args = Dog::new;
        make1Args.make("jelly");

        Make2Args make2Args = Dog::new;
        make2Args.make("tom", 3);
    }
}
