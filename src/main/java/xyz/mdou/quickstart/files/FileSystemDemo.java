package xyz.mdou.quickstart.files;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class FileSystemDemo {
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        FileSystem fs = FileSystems.getDefault();
        fs.getRootDirectories().forEach(System.out::println);
        fs.getFileStores().forEach(System.out::println);

        System.out.println("separator " + fs.getSeparator());
        System.out.println("isOpen " + fs.isOpen());
        System.out.println("isReadOnly " + fs.isReadOnly());
        System.out.println("FileSystemProvider " + fs.provider());
        System.out.println("FileAttributeViews " + fs.supportedFileAttributeViews());
    }
}
