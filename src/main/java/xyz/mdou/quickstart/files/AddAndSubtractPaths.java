package xyz.mdou.quickstart.files;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AddAndSubtractPaths {
    private static Path base = Paths.get("D:", "source", "github").toAbsolutePath().normalize();

    static void show(int id, Path o) {
        if (o.isAbsolute()) {
            System.out.printf("(%d) absolute relativize %s\r\n", id, base.relativize(o));
        } else {
            System.out.printf("(%d) %s\r\n", id, o);
        }
        try {
            System.out.println("realPath: " + o.toRealPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        System.out.println(base);
        Path p = Paths.get("D:", "source", "github", "quickstart-on-java8", "src", "..", "pom.xml").toAbsolutePath().normalize();
        show(1, p);
        Path convoluted = p.getParent().resolve("src").resolve("..").resolve("LICENSE");
        show(2, convoluted);
        show(3, convoluted.normalize());
        Path p2 = Paths.get("..");
        show(4, p2);
        show(5, p2.normalize());
        show(6, p2.toAbsolutePath().normalize());
        Path p3 = Paths.get(".").toAbsolutePath();
        Path p4 = p3.resolve(p2);
        show(7, p4);
        show(8, p4.normalize());
        Path p5 = Paths.get("").toAbsolutePath();
        show(9, p5);
        show(10, p5.resolveSibling("vscode"));
    }
}
