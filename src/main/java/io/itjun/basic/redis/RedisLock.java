package io.itjun.basic.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

/**
 * https://www.cnblogs.com/cjsblog/p/11273205.html
 */
public class RedisLock {

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    // 加锁脚本
    private static final String SCRIPT_LOCK = "if redis.call('setnx', KEYS[1], ARGV[1]) == 1 then redis.call('pexpire', KEYS[1], ARGV[2]) return 1 else return 0 end";
    // 解锁脚本
    private static final String SCRIPT_UNLOCK = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

    /**
     * 尝试获取分布式锁
     *
     * @param jedis      Redis客户端
     * @param lockKey    锁
     * @param requestId  请求标识
     * @param expireTime 超期时间
     *                   <p>
     *                   EX second ：设置键的过期时间为 second 秒。 SET key value EX second 效果等同于 SETEX key second value 。
     *                   PX millisecond ：设置键的过期时间为 millisecond 毫秒。 SET key value PX millisecond 效果等同于 PSETEX key millisecond value 。
     *                   NX ：只在键不存在时，才对键进行设置操作。 SET key value NX 效果等同于 SETNX key value 。
     *                   XX ：只在键已经存在时，才对键进行设置操作。
     * @return 是否获取成功
     */
    public static boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId, long expireTime) {
        SetParams params = new SetParams();
        params.ex(expireTime);
        params.px(1000L);
        params.nx();
        String result = jedis.set(lockKey, requestId, params);
        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

}
