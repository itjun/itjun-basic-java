package io.itjun.basic.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * zookeeper 从 origin 的节点 A路径 复制到 replica 的 B路径
 */
@Slf4j
public class ZooKeeperNodeCopy {
    private static final String from = "/test-server/main";
    private static final String to = "/test-server/main";

    private static ZooKeeper origin;
    private static ZooKeeper replica;

    public static void main(String[] args) throws Exception {
        // 从 origin 复制到 replica
        origin = new ZooKeeper("10.0.0.254:2181", 3000, event -> log.error("origin watched event: {}", event));
        replica = new ZooKeeper("10.2.1.1:2181", 3000, event -> log.error("replica watched event {}", event));

        copy(from, to);

        origin.close();
        replica.close();
        log.info("finish ...");
    }

    private static void copy(String source, String target) throws Exception {
        Stat stat = new Stat();
        byte[] data = origin.getData(source, false, stat);
        List<ACL> acl = origin.getACL(source, stat);
        CreateMode createMode = CreateMode.fromFlag((int) stat.getEphemeralOwner());
        replica.create(target, data, acl, createMode);

        List<String> children = origin.getChildren(source, false);
        for (String child : children) {
            String childSourcePath = source + "/" + child;
            String childDestinationPath = target + "/" + child;
            copy(childSourcePath, childDestinationPath);
        }
    }

}
