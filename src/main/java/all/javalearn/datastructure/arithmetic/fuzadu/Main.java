package all.javalearn.datastructure.arithmetic.fuzadu;/*
    created by shudb at 2020/2/9 22:10
*/

public class Main {
    /**
     * 斐波那契数列,递归
     */
    public static long fib1(long n) {
        if (n <= 1) return n;
        return fib1(n-2) + fib1(n - 1);
    }

    /**
     * 斐波那契数列  时间复杂度O(n)
     */
    public static long fib2(long n) {
        if (n <= 1) return n;
        long first = 0;
        long second = 1;
        long sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }

        return sum;
    }


    public static void main(String[] args) {
//        System.out.println(fib(10));
//        System.out.println(fib1(64));

//        System.out.println(fib2(64));
        System.out.println(fib2(75));

    }
}
