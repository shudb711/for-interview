package all.javalearn.base.data.operation;

import java.math.BigDecimal;

/**
 * Created on 2020/8/21 11:46
 *
 * @author shudebao@limikeji.com
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        //double
        System.out.println(new BigDecimal(11.1123));
        System.out.println(new BigDecimal(10.125));
        //int
        System.out.println(new BigDecimal(11));
        //string
        System.out.println(new BigDecimal("11.1123"));

        double d = 11.1123;
        System.out.println(d);
    }
}
