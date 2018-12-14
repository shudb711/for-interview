package all.javalearn.concurrent.threadsafe.pipedreaderwriter;

import java.io.IOException;
import java.io.PipedWriter;

/**
 * @Function:
 * @Author:shudb
 * @Date:2018/12/12 11:10
 **/
public class PipedSender implements Runnable
{
    private PipedWriter pipedWriter = new PipedWriter();

    public PipedWriter getPipedWriter() {
        return pipedWriter;
    }

    public void run() {
        writeShortMessage();
//        writeLongMessage();
    }

    private void writeShortMessage() {
         String strInfo = "this is a short message" ;
         try {
             pipedWriter.write(strInfo.toCharArray());
             pipedWriter.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }


    private void writeLongMessage() {
        StringBuilder sb = new StringBuilder();
        // 通过for循环写入1020个字符
        for (int i = 0; i < 102; i++)
            sb.append("0123456789");
        // 再写入26个字符。
        sb.append("abcdefghijklmnopqrstuvwxyz");
        // str的总长度是1020+26=1046个字符
        String str = sb.toString();
        try {
            // 将1046个字符写入到“管道输出流”中
            pipedWriter.write(str);
            pipedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
