package io.itjun.basic.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.List;

public class ZooKeeperClientExample {
    public static void main(String[] args) throws Exception {
        // 连接字符串，指定ZooKeeper集群的地址
        String connectString = "119.3.122.158:2181,119.3.122.158:2182,119.3.122.158:2183";

        // 创建CuratorFramework客户端
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(connectString)
                .sessionTimeoutMs(5000) // 会话超时时间
                .retryPolicy(new ExponentialBackoffRetry(1000, 3)) // 重试策略
                .build();

        // 启动客户端
        client.start();

        // 检查连接状态
        if (client.getZookeeperClient().blockUntilConnectedOrTimedOut()) {
            System.out.println("Connected to ZooKeeper");
            String string = new String(client.getData().forPath("/diteng/gray/common/cdn"));
            System.out.println(string);

            List<String> list = client.getChildren().forPath("/diteng");
            list.forEach(System.out::println);
            // 在这里执行你的ZooKeeper操作
            // 例如，创建节点、获取节点数据等
        } else {
            System.err.println("Failed to connect to ZooKeeper");
        }

        // 关闭客户端
        client.close();
    }
}
