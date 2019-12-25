package xyz.mdou.quickstart.functional;

interface Callable {
    void call(String s);
}

class Describe {
    void show(String msg) {
        System.out.println(msg);
    }
}

public class MethodReferences {

    static void hello(String name) {
        System.out.println("Hello, " + name);
    }

    static class Description {
        String about;

        Description(String about) {
            this.about = about;
        }

        void desc(String msg) {
            System.out.println(about + " " + msg);
        }
    }

    static class Help {
        static void help(String msg) {
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        Describe describe = new Describe();

        Callable callable = describe::show;
        callable.call("describe::show");

        callable = MethodReferences::hello;
        callable.call("MethodReferences::hello");

        callable = new Description("about")::desc;
        callable.call("Description::desc");

        callable = Help::help;
        callable.call("Help::help");
    }
}
