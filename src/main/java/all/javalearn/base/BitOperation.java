package all.javalearn.base;

/**
 * @Function: 
 * @Author:shudb
 * @Date:2018/12/21 11:08
 **/
public class BitOperation
{
    public static void main(String[] args) {
        //位运算都是补码进行计算
        System.out.println(-16 >>> 2);
        System.out.println(-16 >> 2);
        System.out.println((byte)((byte)127 + (byte)1));

        System.out.println(-1 & -3);
        System.out.println(-1 | -3);
        System.out.println(~-3);
        System.out.println(-1^-3);

    }
}
