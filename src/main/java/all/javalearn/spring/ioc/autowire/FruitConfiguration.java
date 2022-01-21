package all.javalearn.spring.ioc.autowire;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * author:shudb
 * date:2021/8/14
 * email:shudebao@aliyun.com
 * description:
 */


@Configuration
public class FruitConfiguration {

    @Bean(name = "banana")
    public Apple getApple() {
        return new Apple();
    }
}
