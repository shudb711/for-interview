package all.javalearn.concurrent.threadsafe.pipedreaderwriter;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.TimeUnit;

/**
 * @Function:
 * @Author:shudb
 * @Date:2018/12/12 11:12
 **/
public class PipedTest
{
    public static void main(String[] args) throws IOException, InterruptedException {
        PipedReceiver pipedReceiver = new PipedReceiver();
        PipedSender pipedSender = new PipedSender();

        PipedReader pipedReader = pipedReceiver.getPipedReader();
        PipedWriter pipedWriter = pipedSender.getPipedWriter();

        pipedReader.connect(pipedWriter);

        new Thread(pipedReceiver, "thread-receiver").start();

//        TimeUnit.SECONDS.sleep(10);
        new Thread(pipedSender, "thread-sender").start();
    }
}
