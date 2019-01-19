package all.javalearn.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * @Function:jdk动态代理
 * @Author:shudb
 * @Date:2018/10/11 10:45
 **/

public class ProxyTest {
    public static void main(String[] args) {
        //打开保存开关
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        HelloWorldInvocationHandler handler = new HelloWorldInvocationHandler(new HelloWorldImpl());
        HelloWorld proxy = (HelloWorld) Proxy.newProxyInstance(
                ProxyTest.class.getClassLoader(),
                new Class[]{HelloWorld.class},
                handler);
        //获取生成代理类的路径
        System.out.println("$Proxy0.class全名: "+Proxy.getProxyClass(HelloWorld.class.getClassLoader(), HelloWorld.class));
        proxy.hello();
    }
}
