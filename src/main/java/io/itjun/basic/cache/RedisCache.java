package io.itjun.basic.cache;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Java业务开发常见错误100例
 * <p>
 * <a href="https://time.geekbang.org/column/article/231501">...</a>
 * <p>
 * wrk -c10 -t10 -d 100s <a href="http://localhost:45678/cacheinvalid/city">...</a>
 */
@Slf4j
public class RedisCache {

    AtomicInteger atomicInteger = new AtomicInteger();
    StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();

    @PostConstruct
    public void init() {
        //初始化一个热点数据到Redis中，过期时间设置为5秒
        stringRedisTemplate.opsForValue().set("hotsopt", getExpensiveData(), 5, TimeUnit.SECONDS);
        //每隔1秒输出一下回源的QPS
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            log.info("DB QPS : {}", atomicInteger.getAndSet(0));
        }, 0, 1, TimeUnit.SECONDS);
    }

    @GetMapping("wrong")
    public String wrong() {
        String data = stringRedisTemplate.opsForValue().get("hotsopt");
        if (StringUtils.isEmpty(data)) {
            data = getExpensiveData();
            //重新加入缓存，过期时间还是5秒
            stringRedisTemplate.opsForValue().set("hotsopt", data, 5, TimeUnit.SECONDS);
        }
        return data;
    }

    @PostConstruct
    public void rightInit2() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        //每隔30秒全量更新一次缓存
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            IntStream.rangeClosed(1, 1000).forEach(i -> {
                String data = getCityFromDb(i);
                //模拟更新缓存需要一定的时间
                try {
                    TimeUnit.MILLISECONDS.sleep(20);
                } catch (InterruptedException e) {
                }
                if (!StringUtils.isEmpty(data)) {
                    //缓存永不过期，被动更新
                    stringRedisTemplate.opsForValue().set("city" + i, data);
                }
            });
            log.info("Cache update finished");
            //启动程序的时候需要等待首次更新缓存完成
            countDownLatch.countDown();
        }, 0, 30, TimeUnit.SECONDS);

        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            log.info("DB QPS : {}", atomicInteger.getAndSet(0));
        }, 0, 1, TimeUnit.SECONDS);

        countDownLatch.await();
    }

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("right")
    public String right() {
        String data = stringRedisTemplate.opsForValue().get("hotsopt");
        if (StringUtils.isEmpty(data)) {
            RLock locker = redissonClient.getLock("locker");
            //获取分布式锁
            if (locker.tryLock()) {
                try {
                    data = stringRedisTemplate.opsForValue().get("hotsopt");
                    //双重检查，因为可能已经有一个B线程过了第一次判断，在等锁，然后A线程已经把数据写入了Redis中
                    if (StringUtils.isEmpty(data)) {
                        //回源到数据库查询
                        data = getExpensiveData();
                        stringRedisTemplate.opsForValue().set("hotsopt", data, 5, TimeUnit.SECONDS);
                    }
                } finally {
                    //别忘记释放，另外注意写法，获取锁后整段代码try+finally，确保unlock万无一失
                    locker.unlock();
                }
            }
        }
        return data;
    }

    private String getExpensiveData() {
        return null;
    }

    private String getCityFromDb(int i) {
        return null;
    }

}
