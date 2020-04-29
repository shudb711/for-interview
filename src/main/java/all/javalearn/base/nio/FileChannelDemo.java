package all.javalearn.base.nio;/*
    created by shudb at 2019/12/21 20:00
*/

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {
    public static void main(String[] args) throws Exception {
//        FileOutputStream out =new FileOutputStream("C:\\Users\\shudb\\Desktop\\11.txt");
//        out.write("你好啊".getBytes("utf-8"));
//        out.close();


        ByteBuffer wrap = ByteBuffer.wrap("hello world".getBytes());
        FileOutputStream out =new FileOutputStream("C:\\Users\\shudb\\Desktop\\11.txt");
        FileChannel channel = out.getChannel();
        channel.write(wrap);
        channel.close();
        out.close();
    }
}
