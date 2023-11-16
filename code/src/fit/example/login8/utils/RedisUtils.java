package fit.example.login8.utils;

import redis.clients.jedis.Jedis;

/**
 * redis 工具类
 */
public class RedisUtils {
    public static final String HOST = "127.0.0.1";
    public static final int PORT = 6379;

    public static Jedis getJedis() {
        return new Jedis(HOST, PORT);
    }
}
