//package all.javalearn.redis.distributelock;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Random;
//
///**
// * 分布式锁
// * Created on 2020/5/23 16:54
// * Author shudebao@limikeji.com
// */
//
//@Component
//@Slf4j
//public class RedisDistributeLock {
//
//    @Autowired
//    private RedisClient redisClient;
//
//    private static ThreadLocal<String> label = new ThreadLocal<>();
//
//
//    public static void clear() {
//        label.remove();
//    }
//
//    /**
//     * 获取redis锁(过期时间默认10s)
//     *
//     * @param lockKey
//     * @return
//     */
//    public boolean lock(String lockKey) {
//        return this.lockTimeout(lockKey, 10);
//    }
//
//
//    /**
//     * 获取redis锁(设置过期时间)
//     *
//     * @param lockKey
//     * @return
//     */
//    public boolean lockTimeout(String lockKey, int timeout) {
//        label.set(String.valueOf(System.currentTimeMillis() + "" + new Random().nextInt(10000)));
//        try {
//            return redisClient.setNxEx(lockKey, label.get(), timeout);
//        } catch (Exception e) {
//            log.error("获取redis分布式锁异常: {}", e.getMessage());
//            return false;
//        }
//    }
//
//    /**
//     * 释放redis锁
//     *
//     * @param lockKey
//     */
//    public void unlock(String lockKey) {
//        String realValue = "-1";
//        try {
//            realValue =  redisClient.getKey(lockKey).toString();
//            realValue = realValue == null ? "-1" : realValue;
//        } catch (Exception e) {
//            log.error("释放redis锁出现异常: {}", e.getMessage());
//            redisClient.delete(lockKey);
//        } finally {
//            String s = label.get();
//            clear();
//            if (!("-1".equals(realValue)) && s != null && s.equals(realValue)) {
//                redisClient.delete(lockKey);
//            }
//        }
//    }
//
//
//}
