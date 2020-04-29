package all.javalearn.concurrent.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created on 2020/4/29 10:02
 * Author shudebao@limikeji.com
 */
public class COWTest {
    private List<String> list = new CopyOnWriteArrayList<>();
//    private List<String> list = new ArrayList<>();

    {
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
    }

    public static void main(String[] args) throws InterruptedException {
        COWTest cowTest = new COWTest();
//        for (int i = 0; i < cowTest.list.size(); i++) {
//            //角标遍历的方式
//            //遍历针对的是Object[] array指向的数组
//            //此时如果其他线程修改集合的元素，会复制一份进行修改，修改完之后，Object[] array指向新数组
//            //所以这种遍历方式，在其他线程修改完之后，遍历的是新数组
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    cowTest.list.clear();
//                    System.out.println("清除了元素");
//                }
//            }).start();
//
//            System.out.println(cowTest.list.get(i));
//            Thread.sleep(20);
//        }

        for (String str : cowTest.list) {
            //迭代的方式
            //遍历针对的是老的数组（创建迭代器的时候，会把Object[] snapshot指向老数组），
            //此时如果其他线程修改集合的元素，会复制一份进行修改，修改完之后，Object[] array指向新数组
            //但是此时由于迭代的对象仍是老数组，所以可以正常迭代，迭代的数据仍是老数组的数据
            new Thread(new Runnable() {
                @Override
                public void run() {
                    cowTest.list.clear();
                    System.out.println("清除了元素");
                }
            }).start();

            System.out.println(str);
            Thread.sleep(20);
        }
    }
}
