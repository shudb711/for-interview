package all.javalearn.concurrent.producerconsumer.threadcommunicate;

/**
 * @Function:
 * @Author:shudb
 * @Date:2018/8/14 14:44
 **/
public class Peach
{
    private int pid;

    public Peach(int pid) {
        this.pid = pid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
