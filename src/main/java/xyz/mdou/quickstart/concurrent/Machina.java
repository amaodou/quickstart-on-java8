package xyz.mdou.quickstart.concurrent;

import java.util.StringJoiner;

public class Machina {

    private int id;
    private State state = State.START;

    Machina(int id) {
        this.id = id;
    }

    public static Machina work(Machina m) {
        if (!m.state.equals(State.END)) {
            new NapTask.Nap(1);
            m.state = m.state.next();
        }
        System.out.println(m);
        return m;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Machina.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("state=" + state)
                .toString();
    }

    private enum State {
        START, ONE, TWO, THREE, END;

        State next() {
            if (equals(END)) {
                return END;
            }
            return State.values()[ordinal() + 1];
        }
    }
}
