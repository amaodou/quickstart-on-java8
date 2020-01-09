package xyz.mdou.quickstart.files;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadLineStream {

    public static void main(String[] args) throws Exception {
        URL url = ListOfLines.class.getClassLoader().getResource("Cheese.dat");
        Files.lines(Paths.get(url.toURI())).skip(1).findFirst().ifPresent(System.out::println);
    }
}
