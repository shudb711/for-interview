package all.javalearn.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * @Function:
 * @Author:shudb
 * @Date:2018/10/11 10:45
 **/

public class ProxyTest {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        HelloWorldInvocationHandler handler = new HelloWorldInvocationHandler(new HelloWorldImpl());
        HelloWorld proxy = (HelloWorld) Proxy.newProxyInstance(
                ProxyTest.class.getClassLoader(),
                new Class[]{HelloWorld.class},
                handler);
        proxy.hello();
    }
}
