package xyz.mdou.quickstart.collections;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Randoms {

    public static final Random RANDOM = new Random(47);
    public static final char[] BASE62 = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };

    public static String string(int length) {
        return IntStream.range(0, length)
                .mapToObj(i -> BASE62[RANDOM.nextInt(BASE62.length)])
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    public static List<String> strings(int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> string(8))
                .collect(Collectors.toList());
    }
}
