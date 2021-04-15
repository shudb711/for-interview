package all.javalearn.mvc;

import all.javalearn.redis.distributelock.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created on 2020/5/23 11:42
 * Author shudebao@limikeji.com
 */

@Controller
public class RedisController {

    @Autowired
    private RedisServiceImpl redisService;

//    @Autowired
//    private RedisDistributeLock redisDistributeLock;

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/testRedis")
    public String testRedis() {
//        String key = "hahaha";
//        boolean lock = redisDistributeLock.lock(key);
//        System.out.println(Thread.currentThread().getName() + ":" + lock);
//        redisDistributeLock.unlock(key);
        Object redisServiceImpl = applicationContext.getBean("redisServiceImpl");
        Object redisController = applicationContext.getBean("redisController");
        return "true";
    }
}
