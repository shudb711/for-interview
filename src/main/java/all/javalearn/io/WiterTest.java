package all.javalearn.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created on 2020/4/29 19:30
 * Author shudebao@limikeji.com
 */
public class WiterTest {

    public static void main(String[] args) throws Exception {
        File file = new File("E:\\222.txt");
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        FileWriter fw = new FileWriter(file);
        for (int i = 0; i < 1000; i++) {
            fw.write(String.valueOf(i));
            fw.write("\n");
        }

        //字符流必须手动flush
        //因为write()只会把字符转成字节放到ByteBuffer缓冲中
        //等到所有写入完毕后，一次性刷入到磁盘中
        //我觉得这样做的目的是效率高，防止频繁刷盘，参考下面的字节流，每次调用write()都会进行刷盘
        fw.flush();

//        FileOutputStream fos = new FileOutputStream("E:\\111.txt");
//        for (int i = 0; i < 1000; i++) {
//            fos.write("nihao".getBytes());
//            fos.write("\n".getBytes());
//        }
    }
}
