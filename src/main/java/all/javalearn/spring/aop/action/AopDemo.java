package all.javalearn.spring.aop.action;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Function:
 * @Author:shudb
 * @Date:2018/10/10 14:17
 **/

@Aspect
@Component
public class AopDemo
{

    @Pointcut("execution (* all.javalearn.spring.aop.action.AopControllerApi.*(..))")
    public void pointcut()
    {

    }

    @Before("pointcut()")
    public void before()
    {
        System.out.println("===========before================");
    }

    @After("pointcut()")
    public void after()
    {
        System.out.println("===========after================");
    }
}
