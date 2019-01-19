package all.javalearn.spring.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Function:
 * @Author:shudb
 * @Date:2018/10/11 10:44
 **/
public class HelloWorldInvocationHandler implements InvocationHandler {
    private Object target;

    public HelloWorldInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("=====Before invocation=====");
        Object retVal = method.invoke(target, args);
        System.out.println("=====After invocation=====");
        return retVal;
    }
}
