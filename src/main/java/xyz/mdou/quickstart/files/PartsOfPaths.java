package xyz.mdou.quickstart.files;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PartsOfPaths {
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        Path p = Paths.get("D:", "source", "github", "quickstart-on-java8", "pom.xml");
        System.out.println(p.endsWith(".java"));
        p.iterator().forEachRemaining(
                c -> System.out.printf("%s: %s: %s\r\n", c, p.startsWith(c), p.endsWith(c)));
        System.out.println(p.startsWith(p.getRoot()));
    }
}
