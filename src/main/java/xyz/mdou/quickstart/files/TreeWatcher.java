package xyz.mdou.quickstart.files;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.Executors;

public class TreeWatcher {

    static void watchTree(Path dir) {
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            dir.register(watchService, StandardWatchEventKinds.ENTRY_DELETE);
            Executors.newSingleThreadExecutor().submit(() -> {
                try {
                    WatchKey key = watchService.take();
                    key.pollEvents().forEach(e -> {
                        System.out.printf("event context: %s, event count: %s, event kind: %s\r\n",
                                e.context(), e.count(), e.kind());
                    });
                } catch (Exception e) {

                }
            });
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) throws IOException {
        Directories.refreshTestDir();
        Directories.createTestPath();
        Files.walk(Paths.get("test"))
                .filter(Files::isDirectory)
                .forEach(TreeWatcher::watchTree);
        PathWatcher.delTxtFiles();
    }
}
