package xyz.mdou.quickstart.functional;

/**
 * Strategy 接口提供单一方法 approach() 来承载函数式功能；
 */
interface Strategy {
    String approach(String msg);
}

class Soft implements Strategy {
    @Override
    public String approach(String msg) {
        return msg.toLowerCase() + "?";
    }
}

class Unrelated {
    static String twice(String msg) {
        return msg + " " + msg;
    }
}

public class Strategize {
    private String msg;
    private Strategy strategy;

    private Strategize(String msg) {
        this.msg = msg;
        strategy = new Soft();
    }

    private void communicate() {
        System.out.println(strategy.approach(msg));
    }

    private void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        Strategy[] strategies = {
                new Strategy() {
                    @Override
                    public String approach(String msg) {
                        return msg.toUpperCase() + "!";
                    }
                },
                msg -> msg.substring(0, 5),
                Unrelated::twice
        };
        Strategize strategize = new Strategize("Hello there");
        strategize.communicate();
        for (Strategy strategy : strategies) {
            strategize.changeStrategy(strategy);
            strategize.communicate();
        }
    }
}
