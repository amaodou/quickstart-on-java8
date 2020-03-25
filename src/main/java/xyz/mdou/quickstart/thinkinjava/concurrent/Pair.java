package xyz.mdou.quickstart.thinkinjava.concurrent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pair {

    private int x;
    private int y;

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    @Override
    public String toString() {
        return String.format("Pair(%d, %d)", x, y);
    }

    public boolean checkState() {
        if (x != y) {
            throw new PairNotEqualsException();
        }
        return true;
    }

    static class PairNotEqualsException extends RuntimeException {
        public PairNotEqualsException() {
            super("pair is not equals");
        }
    }
}
