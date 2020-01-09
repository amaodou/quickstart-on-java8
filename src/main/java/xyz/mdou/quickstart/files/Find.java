package xyz.mdou.quickstart.files;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class Find {
    public static void main(String[] args) throws IOException {

        Directories.refreshTestDir();
        Directories.createTestPath();

        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.{tmp,txt}");
        Files.walk(Paths.get("test")).filter(matcher::matches).forEach(System.out::println);

        PathMatcher matcher2 = FileSystems.getDefault().getPathMatcher("glob:*.tmp");
        Files.walk(Paths.get("test")).map(Path::getFileName).filter(matcher2::matches).forEach(System.out::println);

        Files.walk(Paths.get("test")).filter(Files::isRegularFile).map(Path::getFileName).filter(matcher2::matches).forEach(System.out::println);
    }
}
