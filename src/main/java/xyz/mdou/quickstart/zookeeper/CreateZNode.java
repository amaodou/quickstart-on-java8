package xyz.mdou.quickstart.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class CreateZNode implements Watcher {

    private static ZooKeeper zooKeeper;

    public static void main(String[] args) throws IOException, InterruptedException {
        zooKeeper = new ZooKeeper("127.0.0.1:2181", 5000, new CreateZNode());
        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {

            try {
                createZNode();
            } catch (KeeperException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void createZNode() throws KeeperException, InterruptedException {
        String persistentNode = zooKeeper.create("/test-persistent",
                "this is persistentNode".getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        String ephemeralNode = zooKeeper.create("/test-ephemeral",
                "this is ephemeralNode".getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        String ephemeralSequentialNode = zooKeeper.create("/test-ephemeral_sequential",
                "this is ephemeral_sequential node".getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(String.format("result: %s, %s, %s", persistentNode, ephemeralNode, ephemeralSequentialNode));
    }
}
