package com.example.demo;

import all.DemoApplication;
import all.javalearn.base.test.School;
import all.javalearn.redis.distributelock.RedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * @Function:
 * @Author:shudb
 * @Date:2018/11/6 14:43
 **/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
public class ApplicationTest
{

//    @Autowired
//    private JedisLockUtil jedisLockUtil;
//
//
//    public static void main(String[] args) throws UnsupportedEncodingException {
//        String s = "{\"error\":200,\"msg\":null,\"tianji_api_fahai_lawgreylist_response\":[{\"body\":\"\\u6709\\u5c65\\u884c\\u80fd\\u529b\\u800c\\u62d2\\u4e0d\\u5c65\\u884c\\u751f\\u6548\\u6cd5\\u5f8b\\u6587...\",\"dataType\":\"shixin\",\"entryId\":\"c2018330305zhi346_t20180530_pzhangliang\",\"matchRatio\":0.99,\"sortTime\":1527609600000,\"sortTimeString\":\"2018\\u5e7405\\u670830\\u65e5\",\"title\":\"\\u5f20\\u826f\"},{\"body\":\"33032219810...\",\"dataType\":\"zxgg\",\"entryId\":\"c2018330305zhi346_t20180530_pzhangliang\",\"matchRatio\":0.99,\"sortTime\":1527609600000,\"sortTimeString\":\"2018\\u5e7405\\u670830\\u65e5\",\"title\":\"\\u5f20\\u826f\"},{\"body\":\"\\u539f\\u544a:\\u9648\\u66f9\\u52c7;\\u88ab\\u544a:\\u5f20\\u826f \\u88ab\\u544a...\",\"dataType\":\"cpws\",\"entryId\":\"c2018330305minchu274_t20180424\",\"matchRatio\":0.8,\"partyId\":\"c2018330305minchu274_t20180424_pzhangliang_rt_117\",\"sortTime\":1524499200000,\"sortTimeString\":\"2018\\u5e7404\\u670824\\u65e5\",\"title\":\"\\u9648\\u66f9\\u52c7\\u4e0e\\u5f20\\u826f\\u6c11\\u95f4\\u501f\\u8d37\\u7ea0\\u7eb7\\u4e00\\u5ba1\\u6c11\\u4e8b\\u5224\\u51b3\\u4e66\"},{\"body\":\"\\u5f20\\u826f 330322198105...\",\"dataType\":\"zxgg\",\"entryId\":\"c2012wendongzhimin166_t20120813_pzhangliang\",\"matchRatio\":1,\"sortTime\":1344787200000,\"sortTimeString\":\"2012\\u5e7408\\u670813\\u65e5\",\"title\":\"(2012)\\u6e29\\u6d1e\\u6267\\u6c11\\u5b57\\u7b2c00166\\u53f7\"},{\"body\":\"\\u5f20\\u826f 330322198105...\",\"dataType\":\"zxgg\",\"entryId\":\"c2012wendongzhimin102_t20120528_pzhangliang\",\"matchRatio\":1,\"sortTime\":1338134400000,\"sortTimeString\":\"2012\\u5e7405\\u670828\\u65e5\",\"title\":\"(2012)\\u6e29\\u6d1e\\u6267\\u6c11\\u5b57\\u7b2c00102\\u53f7\"}],\"request_id\":\"15414853311152637150\"}";
//        String transfer = new String(s.getBytes("iso-8859-1"), "iso-8859-1");
//        System.out.println(transfer);
//    }
//
//    @Test
//    public void testDistributelLock()
//    {
//        boolean b = jedisLockUtil.tryLock("lock-key", 10, 5000);
//
////        for (int i = 0; i < 3; i++) {
////            new Thread(new Runnable() {
////                public void run() {
////                    boolean b = jedisLockUtil.tryLock("lock-key", 10, 5000);
////                    System.out.println("加锁" + (b == true?"成功":"失败"));
////                }
////            }).start();
////        }
//    }
//
//    @Autowired
//    private FactoryList<Animal, String> rechargeManager;
//
//    @Test
//    public void testIoc() {
//        Animal cat = rechargeManager.getBean("cat");
//        System.out.println(111);
//    }

    @Autowired
    private RedisClient redisClient;


    @Test
    public void testRedis() {
//        redisClient.setKey("integer",111);
//        redisClient.setKey("string","111");
//        redisClient.setKey("object",new School(111, "光山二高"));


//        System.out.println(redisClient.getKey("integer"));
//        System.out.println(redisClient.getKey("string"));
//        System.out.println(JSON.toJSONString(redisClient.getKey("object")));
//        School school = (School)redisClient.getKey("object");
//        System.out.println(school);
//        Boolean setKey = redisClient.setKey("setKey", 1);
//        boolean setKey1 = redisClient.expire("setKey", 100);
//        Long setKey2 = redisClient.getExpire("setKey");
//        Boolean setKey3 = redisClient.hasKey("setKey");
//        Object setKey4 = redisClient.getKey("setKey");
//        redisClient.delete("setKey");
//        Object setKey5 = redisClient.getKey("setKey");

        //string
//        redisClient.setKey("integer",111);
//        redisClient.setKey("string","111");
//        redisClient.setKey("object",new School(111, "光山二高"));
//        System.out.println(redisClient.getKey("integer"));
//        System.out.println(redisClient.getKey("string"));
//        System.out.println(JSON.toJSONString(redisClient.getKey("object")));
//        School school = (School)redisClient.getKey("object");
//        System.out.println(school);
//
//        Boolean setKeyEx = redisClient.setKeyEx("setKeyEx", 222, 100L);
//        redisClient.incrByDelta("setKeyEx", 10);
//        redisClient.incr("setKeyEx");
//        boolean setKeyEx1 = redisClient.setNx("setKeyEx", 333);
//        boolean setKeyEx11 = redisClient.setNx("setKeyEx1", 444);
//        redisClient.setNxEx("setNxEx", "444", 100);
//
//        //list
//        redisClient.putCacheList("putCacheList", Arrays.asList(111,222,333).toArray());
//        Long putCacheList = redisClient.lpush("putCacheList", 444);
//        List<Object> putCacheList1 = redisClient.lrange("putCacheList", 0, 10);
//        Long putCacheList2 = redisClient.rpush("putCacheList", 555);
//        List<Object> putCacheList3 = redisClient.lrange("putCacheList", 0, 10);
//
//        //set
//        Long sadd = redisClient.sadd("sadd", 111);
//        Boolean sadd1 = redisClient.sismember("sadd", 111);
//        Long sadd2 = redisClient.sadd("sadd", 222);
//        Set<Object> sadd3 = redisClient.smembers("sadd");
//        Long sadd4 = redisClient.srem("sadd", 222);
//
//        //zset
//        boolean zadd1 = redisClient.zadd("zadd", 111, 10);
//        boolean zadd2 = redisClient.zadd("zadd", 222, 20);
//        boolean zadd3 = redisClient.zadd("zadd", 333, 30);
//        Set<Object> zadd = redisClient.zrange("zadd", 0, 10);
//        Set<Object> zadd4 = redisClient.zrangebyscore("zadd", 10, 25);
//        redisClient.zrem("zadd", 111);
//        redisClient.incrementScore("zadd", 222, 5);//todo
//
//        //hash
//        redisClient.hset("hset", "filed1", 111);
//        redisClient.hset("hset", "filed2", 222);
//        Object hget = redisClient.hget("hset", "filed1");
//        Map<Object, Object> hset = redisClient.hgetAll("hset");
//        Long hdel = redisClient.hdel("hset", "filed1");
//        boolean hexists = redisClient.hexists("hset", "filed1");
//        boolean hexists1 = redisClient.hexists("hset", "filed2");
//        Map<String, Object> map = new HashMap<>();
//        map.put("aaa", 11);
//        map.put("bbb", 22);
//        map.put("ccc", 33);
//        redisClient.putHash("putHash1",map);
//
//        Map<String, Object> map1 = new HashMap<>();
//        map1.put("aaa", 11);
//        map1.put("bbb", 22);
//        map1.put("ccc", 33);
//        redisClient.putHashEx("putHash2",map1,100L);
//
//        Map<Object, Object> putHash1 = redisClient.getHash("putHash1");
//        Map<Object, Object> putHash2 = redisClient.getHash("putHash2");


        redisClient.hset("stringToObject", "school1", new School(11, "学校1"));
        Map<Object, Object> stringToObject = redisClient.hgetAll("stringToObject");
        School hget = (School)redisClient.hget("stringToObject", "school1");
        School hget2 = (School)stringToObject.get("school1");

        System.out.println(1111);

    }
}
