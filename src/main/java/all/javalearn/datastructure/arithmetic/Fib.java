package all.javalearn.datastructure.arithmetic;

/*
    created by shudb at 2020/2/9 22:10
*/

public class Fib {

    //递归的暴力解法 -> 带备忘录的递归解法 -> 非递归的动态规划解
    /**
     * 斐波那契数列,递归
     */
    public static long fib1(int n) {
        if (n <= 1) return n;
        return fib1(n-2) + fib1(n - 1);
    }

    /**
     * 斐波那契数列--递归，自顶而下，保存已计算的，时间复杂度O(n)
     */
    public static Integer fib3(Integer n, Integer[] arr) {
        if (n <= 1) {
            return n;
        }
        Integer prevPrev = arr[n-2];
        Integer prev = arr[n-1];
        if (prevPrev == null) {
            prevPrev = fib3(n -2,arr);
        }
        if (prev == null) {
            prev = fib3(n -1, arr);
        }
        return prevPrev + prev;
    }


    /**
     * 斐波那契数列--自底而上，时间复杂度O(n)
     */
    public static Integer fib2(Integer n, Integer[] arr) {
        arr[0] = 0;
        arr[1] = 1;
        if (n <= 1) {
            return n;
        }

        Integer sum = 0;
        for (Integer i = 0; i < n - 1; i++) {
            sum = arr[i] + arr[i + 1];
            if (i != n - 2) {
                arr[i + 2] = sum;
            }
        }
        return sum;
    }

    /**
     * 斐波那契数列--自底而上，只保存前两个，而不是保存前面所有的，时间复杂度O(n)
     */
    public static Integer fib2(int n) {
        if (n <= 1) return n;
        Integer first = 0;
        Integer second = 1;
        Integer sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(fib1(20));
        System.out.println(fib2(20));
        System.out.println(fib2(20, new Integer[20]));
        System.out.println(fib3(20, new Integer[20]));


        int[] arr = new int[10];
        System.out.println(arr);
    }
}
