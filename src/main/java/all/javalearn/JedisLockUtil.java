//package all.javalearn;
//
//import com.alibaba.fastjson.JSON;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.data.redis.connection.RedisConnection;
//import org.springframework.data.redis.core.RedisCallback;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//import redis.clients.jedis.Jedis;
//
//import java.util.Random;
//
///**
// * Description
// *
// * @author thinkpad
// * @version 1.0
// * Date                 Author			Version     Description
// * ------------------------------------------------------------------
// * 2018-7-9--20:46     suyin             1.0      Version
// */
//
//@Component
//public class JedisLockUtil {
//
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    private static ThreadLocal<String> label = new ThreadLocal<>();
//
//
//    public static void clear() {
//        label.remove();
//    }
//
//
//    /**
//     * 获取redis锁
//     *
//     * @param lockKey
//     * @param i
//     * @return
//     */
//    public boolean tryLock(String lockKey, int i, int timeout) {
//        if (i <= 0) {
//            throw new IllegalArgumentException("参数i不能小于0");
//        }
//        label.set(String.valueOf(System.currentTimeMillis() + "" + new Random().nextInt(10000)));
//        Boolean b = false;
//        for (int j = 0; j < i; j++) {
//            b = (Boolean) redisTemplate.execute(new RedisCallback() {
//                public Object doInRedis(RedisConnection connection) throws DataAccessException {
//                    Jedis jedis = (Jedis) connection.getNativeConnection();
//                    String result = jedis.set(lockKey, JSON.toJSONString(label.get()), "nx", "ex", timeout);
//                    return "OK".equals(result) ? true : false;
//                }
//            });
//            if (b) {
//                return b;
//            } else {
//                try {
//                    Thread.sleep(j % 10 + new Random().nextInt(20));
//                } catch (InterruptedException e) {
////                    log.error("获取redis分布式锁异常", e);
//                }
//            }
//        }
//        return b;
//
//    }
//
//    /**
//     * 释放redis锁
//     *
//     * @param lockKey
//     */
//    public void deleteLock(String lockKey) {
//        String realValue = "-1";
//        try {
//            realValue = (String) redisTemplate.opsForValue().get(lockKey);
//            realValue = (realValue == null ? "-1" : realValue);
//        } catch (Exception e) {
////            log.error("释放redis锁出现异常", e);
//            redisTemplate.delete(lockKey);
//        } finally {
//            String s = label.get();
//            if (!("-1".equals(realValue)) && s != null && s.equals(realValue)) {
//                redisTemplate.delete(lockKey);
//            }
//
//        }
//    }
//
//
//}
