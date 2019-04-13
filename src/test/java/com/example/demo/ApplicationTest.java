package com.example.demo;

import all.DemoApplication;
import all.javalearn.redis.distributelock.JedisLockUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;

/**
 * @Function:
 * @Author:shudb
 * @Date:2018/11/6 14:43
 **/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
public class ApplicationTest
{

    @Autowired
    private JedisLockUtil jedisLockUtil;


    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "{\"error\":200,\"msg\":null,\"tianji_api_fahai_lawgreylist_response\":[{\"body\":\"\\u6709\\u5c65\\u884c\\u80fd\\u529b\\u800c\\u62d2\\u4e0d\\u5c65\\u884c\\u751f\\u6548\\u6cd5\\u5f8b\\u6587...\",\"dataType\":\"shixin\",\"entryId\":\"c2018330305zhi346_t20180530_pzhangliang\",\"matchRatio\":0.99,\"sortTime\":1527609600000,\"sortTimeString\":\"2018\\u5e7405\\u670830\\u65e5\",\"title\":\"\\u5f20\\u826f\"},{\"body\":\"33032219810...\",\"dataType\":\"zxgg\",\"entryId\":\"c2018330305zhi346_t20180530_pzhangliang\",\"matchRatio\":0.99,\"sortTime\":1527609600000,\"sortTimeString\":\"2018\\u5e7405\\u670830\\u65e5\",\"title\":\"\\u5f20\\u826f\"},{\"body\":\"\\u539f\\u544a:\\u9648\\u66f9\\u52c7;\\u88ab\\u544a:\\u5f20\\u826f \\u88ab\\u544a...\",\"dataType\":\"cpws\",\"entryId\":\"c2018330305minchu274_t20180424\",\"matchRatio\":0.8,\"partyId\":\"c2018330305minchu274_t20180424_pzhangliang_rt_117\",\"sortTime\":1524499200000,\"sortTimeString\":\"2018\\u5e7404\\u670824\\u65e5\",\"title\":\"\\u9648\\u66f9\\u52c7\\u4e0e\\u5f20\\u826f\\u6c11\\u95f4\\u501f\\u8d37\\u7ea0\\u7eb7\\u4e00\\u5ba1\\u6c11\\u4e8b\\u5224\\u51b3\\u4e66\"},{\"body\":\"\\u5f20\\u826f 330322198105...\",\"dataType\":\"zxgg\",\"entryId\":\"c2012wendongzhimin166_t20120813_pzhangliang\",\"matchRatio\":1,\"sortTime\":1344787200000,\"sortTimeString\":\"2012\\u5e7408\\u670813\\u65e5\",\"title\":\"(2012)\\u6e29\\u6d1e\\u6267\\u6c11\\u5b57\\u7b2c00166\\u53f7\"},{\"body\":\"\\u5f20\\u826f 330322198105...\",\"dataType\":\"zxgg\",\"entryId\":\"c2012wendongzhimin102_t20120528_pzhangliang\",\"matchRatio\":1,\"sortTime\":1338134400000,\"sortTimeString\":\"2012\\u5e7405\\u670828\\u65e5\",\"title\":\"(2012)\\u6e29\\u6d1e\\u6267\\u6c11\\u5b57\\u7b2c00102\\u53f7\"}],\"request_id\":\"15414853311152637150\"}";
        String transfer = new String(s.getBytes("iso-8859-1"), "iso-8859-1");
        System.out.println(transfer);
    }

    @Test
    public void testDistributelLock()
    {
        boolean b = jedisLockUtil.tryLock("lock-key", 10, 5000);

//        for (int i = 0; i < 3; i++) {
//            new Thread(new Runnable() {
//                public void run() {
//                    boolean b = jedisLockUtil.tryLock("lock-key", 10, 5000);
//                    System.out.println("加锁" + (b == true?"成功":"失败"));
//                }
//            }).start();
//        }
    }




}
