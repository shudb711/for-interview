package all.javalearn.concurrent.threadsafe.pipedreaderwriter;

import java.io.IOException;
import java.io.PipedReader;

/**
 * @Function:
 * @Author:shudb
 * @Date:2018/12/12 11:10
 **/
public class PipedReceiver implements Runnable {
    private PipedReader pipedReader = new PipedReader();

    public PipedReader getPipedReader() {
        return pipedReader;
    }

    public void run() {
        readMessageOnce();
//        readMessageContinued();
    }

    private void readMessageOnce(){
        // 虽然buf的大小是2048个字符，但最多只会从“管道输入流”中读取1024个字符。
        // 因为，“管道输入流”的缓冲区大小默认只有1024个字符。
        char[] buf = new char[2048];
        try {
            int len = pipedReader.read(buf);
            System.out.println(new String(buf,0,len));
            pipedReader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public void readMessageContinued(){
       int total=0;
       while(true) {
           char[] buf = new char[1024];
           try {
                   int len = pipedReader.read(buf);
                   total += len;
                   System.out.println(new String(buf,0,len));
                   // 若读取的字符总数>1024，则退出循环。
                   if (total > 20)
                        break;
               } catch (IOException e) {
                   e.printStackTrace();
               }
       }

       try {
           pipedReader.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
    }

}
