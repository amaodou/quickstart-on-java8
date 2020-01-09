package xyz.mdou.quickstart.files;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PathWatcher {
    static Path test = Paths.get("test");

    static void delTxtFiles() {
        try {
            Files.walk(test).filter(f -> f.toString().endsWith(".txt")).forEach(path -> {
                try {
                    Files.delete(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Directories.refreshTestDir();
        Directories.createTestPath();
        Files.createFile(test.resolve("HelloWorld.txt"));
        WatchService watchService = FileSystems.getDefault().newWatchService();
        test.register(watchService, StandardWatchEventKinds.ENTRY_DELETE);
        Executors.newSingleThreadScheduledExecutor()
                .schedule(PathWatcher::delTxtFiles, 3, TimeUnit.SECONDS);
        WatchKey key = watchService.take();
        key.pollEvents().forEach(k -> {
            System.out.printf("event.context(): %s \r\n" +
                            "event.count(): %d\r\n" +
                            "event.kind(): %s",
                    k.context(), k.count(), k.kind());
            System.exit(0);
        });
    }
}
