package all.javalearn.concurrent.threadsafe;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Function:
 * @Author:shudb
 * @Date:2018/12/3 17:40
 **/

@Component
public class VolatileDemo2
{
    private boolean flag = false;//标志某个资源是否空闲
    public void doSomethind(){
        while(!flag){
            System.out.println("the resource is free ,let us do something");
        }
        if(flag){
            System.out.println("the resource is busy ,let us stop!");
        }
    }


    @Scheduled(cron = "0/1 * * * * ?")
    public void schedule() throws InterruptedException {
        final VolatileDemo2 sharedObject = new VolatileDemo2();
        new Thread(){
            public void run() {
                sharedObject.doSomethind();
            };
        }.start();
        Thread.sleep(3000);
        new Thread(){
            public void run() {
                sharedObject.flag=true;
            };
        }.start();
    }
//    public static void main(String[] args) throws Exception {
//        final VolatileDemo2 sharedObject = new VolatileDemo2();
//        new Thread(){
//            public void run() {
//                sharedObject.doSomethind();
//            };
//        }.start();
//        Thread.sleep(3000);
//        new Thread(){
//            public void run() {
//                sharedObject.flag=true;
//                while (true)
//                {
//
//                }
//            };
//        }.start();
//    }
}
