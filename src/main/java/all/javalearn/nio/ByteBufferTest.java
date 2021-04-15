package all.javalearn.nio;

import java.io.FileNotFoundException;
import java.nio.ByteBuffer;

/**
 * Created on 2020/5/12 10:36
 * Author shudebao@limikeji.com
 */
public class ByteBufferTest {
    public static void main(String[] args) throws FileNotFoundException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        byteBuffer.put("dqowifnerfjreijfrigjrtigjrtgrtdoieqfjiqfjirfjaafemrigjirtjtrgbr".getBytes());
        byteBuffer.flip();
        System.out.println(byteBuffer.position() + ":" + byteBuffer.limit());


        byte[] b1 = new byte[10];
        byteBuffer.get(b1, 0, 10);
        System.out.println(new String(b1) + ":" + byteBuffer.position() + ":" + byteBuffer.limit());

        byte[] b2 = new byte[10];
        byteBuffer.get(b2, 0, 10);
        System.out.println(new String(b2));
        System.out.println(new String(b1) + ":" + byteBuffer.position() + ":" + byteBuffer.limit());
    }
}
