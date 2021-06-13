package io.itjun.examples.redis;

import org.redisson.Redisson;
import org.redisson.RedissonRedLock;
import org.redisson.api.RList;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

public class RedissonTest {

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useClusterServers()
                .setScanInterval(2000) // 集群状态扫描间隔时间，单位是毫秒
                .addNodeAddress("redis://127.0.0.1:7000").setPassword("1")
                .addNodeAddress("redis://127.0.0.1:7001").setPassword("1")
                .addNodeAddress("redis://127.0.0.1:7002")
                .setPassword("1");
        return Redisson.create(config);
    }

    public void getLock() throws InterruptedException {
        long waitTimeout = 10;
        long leaseTime = 1;
        RedissonClient client1 = Redisson.create();
        RedissonClient client2 = Redisson.create();
        RedissonClient client3 = Redisson.create();

        RLock lock1 = client1.getLock("lock1");
        RLock lock2 = client2.getLock("lock2");
        RLock lock3 = client3.getLock("lock3");

        RedissonRedLock redLock = new RedissonRedLock(lock1, lock2, lock3);
        // 同时加锁：lock1 lock2 lock3
        // 红锁在大部分节点上加锁成功就算成功，且设置总超时时间以及单个节点超时时间
        redLock.tryLock(waitTimeout, leaseTime, TimeUnit.SECONDS);
        redLock.unlock();
    }

    public static void main(String[] args) {
        // 默认连接上 127.0.0.1:6379
        RedissonClient client = Redisson.create();

        // RList 继承了 java.util.List 接口
        RList<String> nameList = client.getList("nameList");
        nameList.clear();
        nameList.add("bingo");
        nameList.add("yanglbme");
        nameList.add("https://github.com/yanglbme");
        nameList.remove(-1);

        boolean contains = nameList.contains("yanglbme");
        System.out.println("List size: " + nameList.size());
        System.out.println("Is list contains name 'yanglbme': " + contains);
        nameList.forEach(System.out::println);

        client.shutdown();
    }

}
