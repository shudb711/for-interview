package all.javalearn.spring.aop.error;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * author:shudb
 * date:2021/4/15
 * email:shudebao@aliyun.com
 * description:
 */

@Service
public class AsyncServiceImpl implements AsyncService {


    @Override
    @Async
    public void async1() {
        System.out.println(Thread.currentThread().getName());
        async2();
    }

    @Override
    @Async
    public void async2() {
        System.out.println(Thread.currentThread().getName());
    }
}
