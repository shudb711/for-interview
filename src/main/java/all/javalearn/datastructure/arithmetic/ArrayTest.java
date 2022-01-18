package all.javalearn.datastructure.arithmetic;

/**
 * @author by shudebao@tal.com
 * @description
 * @date 2022/1/17 2:45 下午
 */
public class ArrayTest {

    /**
     * 力扣303
     * 计算以为数组 i到j的 元素和
     * 前缀和（一维数组）,用一个数组保存前n个数之和，sum()方法直接操作该数组即可，时间复杂度是O(1),之后如果多次调用sum()方法的话，可以提高效率，不必每次都重新计算
     */
    class NumArray{
        //前缀和数组
        private int[] preSum;
        //传入一个数组
        public NumArray(int[] arr) {
            preSum = new int[arr.length + 1];
            preSum[0] = 0;
            //计算累加和
            for (int i = 0; i < arr.length; i++) {
                preSum[i + 1] = preSum[i] + arr[i];
            }
        }

        public int sum(int i, int j) {
            return preSum[j + 1] - preSum[i];
        }
    }


    /**
     * 力扣304
     * 计算二维数组 x1,x2,y1,y2 区域和
     * 前缀和（二维数组）
     */
    class NumMatrix{
        private int[][] preSum;
        public NumMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            preSum = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    preSum[i + 1][j + 1] = preSum[i][j + 1] + preSum[i + 1][j] -preSum[i][j];
                }
            }
        }

        public int sumRegion(int x1, int x2, int y1, int y2) {
            return preSum[x2 + 1][y2 + 1] - preSum[x2 + 1][y1] - preSum[x1][y2 + 1] + preSum[x1][y1];
        }
    }

    /**
     * 力扣560
     * 给定一个数组，获取和为 K 的⼦数组
     */
    class SubarraySum{
        private int[] arr;
        //前缀和数组
        private int[] preSum;
        //传入一个数组
        public SubarraySum(int[] arr) {
            this.arr = arr;
            preSum = new int[arr.length + 1];
            preSum[0] = 0;
            //计算累加和
            for (int i = 0; i < arr.length; i++) {
                preSum[i + 1] = preSum[i] + arr[i];
            }
        }

        public int getSubArraySum(int k) {
            int sum = 0;
            //穷举所有的子数组
            for (int i = 1; i < arr.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (preSum[i] - preSum[j] == k) {
                        sum++;
                    }
                }
            }
            return sum;
        }
    }
}
