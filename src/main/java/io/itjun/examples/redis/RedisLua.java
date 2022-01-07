package io.itjun.examples.redis;

public class RedisLua {

    public static void main(String[] args) {
        final String LUA_SCRIPT_MSETEX = "local keysLen = table.getn(KEYS);" + "local argvLen = table.getn(ARGV);"
                + "local idx=1;" + "local argVIdx=1;" + "for idx=1,keysLen,1 do " + "argVIdx=(idx-1)*2+1; "
                + "redis.call('Set',KEYS[idx],ARGV[argVIdx],'EX',ARGV[argVIdx+1]);" + "end " + "return keysLen;";

        try (Jedis jedis = JedisFactory.getJedis()) {
            jedis.scriptLoad(LUA_SCRIPT_MSETEX);
            jedis.evalsha(jedis.scriptLoad(LUA_SCRIPT_MSETEX), Arrays.asList("a1", "a2"),
                    Arrays.asList("v1", "10", "v2", "20"));
        }
    }

}
