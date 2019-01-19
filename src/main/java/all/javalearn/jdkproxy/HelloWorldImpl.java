package all.javalearn.jdkproxy;

/**
 * @Function:
 * @Author:shudb
 * @Date:2018/10/11 10:43
 **/
public class HelloWorldImpl implements HelloWorld {
//    public final void hello() {
//    final方法也可以（jdk动态代理）
    public void hello() {
        System.out.println("=====hello world=====");
    }
}
