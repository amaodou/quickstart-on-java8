package xyz.mdou.quickstart.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Directories {
    private static Path test = Paths.get("test");
    private static List<String> parts = Arrays.asList("bar", "foo", "baz", "bag");

    static void refreshTestDir() throws IOException {
        if (Files.exists(test)) {
            RmDir.rmdir(test);
        }
        if (!Files.exists(test)) {
            Files.createDirectory(test);
        }
    }

    static Path getPath() {
        Collections.rotate(parts, 1);
        return Paths.get("test").resolve(String.join(File.separatorChar + "", parts));
    }

    static void createTestPath() throws IOException {
        IntStream.range(1, parts.size())
                .forEach(c -> {
                            Path path = getPath();
                            try {
                                Files.createDirectories(path);
                                Files.createFile(path.resolve("HelloWorld.txt"));
                                Files.createTempFile(path, null, null);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                );
    }

    public static void main(String[] args) throws IOException {
        refreshTestDir();
        Path path = getPath();
        try {
            Files.createDirectory(path);
        } catch (IOException e) {
            System.out.println("Files.createDirectory failed to " + path);
        }
        createTestPath();
        Path tmpDir = Files.createTempDirectory(test, "TMP_DIR");
        Files.createTempFile(tmpDir, "node", ".tmp");
        Files.newDirectoryStream(test).forEach(System.out::println);
        System.out.println("************************");
        Files.walk(test).forEach(System.out::println);
    }
}
