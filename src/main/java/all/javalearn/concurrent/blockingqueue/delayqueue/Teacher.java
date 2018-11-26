package all.javalearn.concurrent.blockingqueue.delayqueue;

import java.util.concurrent.DelayQueue;

/**
 * @Function:
 * @Author:shudb
 * @Date:2018/9/20 16:45
 **/
class Teacher implements Runnable{

    private DelayQueue<Student> students;
    public Teacher(DelayQueue<Student> students){
        this.students = students;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            System.out.println(" test start");
            while(!Thread.interrupted()){
                students.take().run();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}
