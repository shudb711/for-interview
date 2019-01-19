package all.javalearn.spring.cglibproxy;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Function:cglib动态代理
 * @Author:shudb
 * @Date:2019/1/19 14:50
 **/
public class CglibProxyTest
{
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonServiceImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("Before:" + method);
                Object object = methodProxy.invokeSuper(o, objects);
                System.out.println("After:" + method);
                return object;
            }
        });
        PersonServiceImpl proxy= (PersonServiceImpl)enhancer.create();
        proxy.setPerson();
        proxy.getPerson("1");
//        打印结果如下：
//        PersonService构造
//        Before:public void all.javalearn.spring.cglibproxy.PersonServiceImpl.setPerson()
//        PersonService:setPerson
//        After:public void all.javalearn.spring.cglibproxy.PersonServiceImpl.setPerson()
//        PersonService:getPerson>>1
    }
}
