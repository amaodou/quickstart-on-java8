package xyz.mdou.quickstart.files;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class ListOfLines {

    static Random random = new Random(47);
    static final int SIZE = 1000;

    public static void main(String[] args) throws Exception {
        URL url = ListOfLines.class.getClassLoader().getResource("Cheese.dat");
        Files.readAllLines(Paths.get(url.toURI()))
                .stream()
                .filter(l -> !l.startsWith("//"))
                .forEach(System.out::println);

        byte[] bytes = new byte[SIZE];
        random.nextBytes(bytes);
        Files.write(Paths.get("bytes.data"), bytes);
        System.out.println("bytes.data: " + Files.size(Paths.get("bytes.data")));

        Files.write(Paths.get("Cheese.txt"), Files.readAllLines(Paths.get(url.toURI())));
        Files.readAllLines(Paths.get("Cheese.txt")).forEach(System.out::println);
    }

}
