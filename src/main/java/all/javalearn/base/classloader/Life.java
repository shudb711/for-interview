package all.javalearn.base.classloader;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created on 2020/7/29 10:46
 *
 * @author shudebao@limikeji.com
 */
public class Life {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = Life.class.getClassLoader();
        System.out.println("life.class" + classLoader);
        Eat eat = new Eat();
        eat.eat("小明");
        System.out.println("eat.class::" + eat.getClass().getClassLoader().toString());

//        File file = new File("C:\\Users\\shudb\\.m2\\repository\\com\\baomidou\\mybatis-plus-core\\3.1.1");
//        URL url = file.toURI().toURL();

        URL[] webAppLibURL = new URL[] {new URL("file:C:\\Users\\shudb\\.m2\\repository\\com\\baomidou\\mybatis-plus-core\\3.1.1\\mybatis-plus-core-3.1.1.jar")};
        URLClassLoader loader = new URLClassLoader(webAppLibURL);
        Thread.currentThread().setContextClassLoader(loader);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                try {
                    Class<?> aClass = contextClassLoader.loadClass("com.baomidou.mybatisplus.core.conditions.Wrapper");
                    System.out.println("子线程的类加载器" + aClass.getClassLoader());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setContextClassLoader(loader);
        thread.start();

        Class<?> aClass = loader.loadClass("com.baomidou.mybatisplus.core.conditions.SharedString");
        System.out.println("SharedString.class::" + aClass.getClassLoader().toString());

        BeatDoudou beatDoudou = new BeatDoudou();
        beatDoudou.beatDoudou("小明");
        System.out.println("beatDoudou.class::" + beatDoudou.getClass().getClassLoader().toString());
    }
}
