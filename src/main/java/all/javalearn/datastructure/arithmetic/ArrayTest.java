package all.javalearn.datastructure.arithmetic;

/**
 * @author by shudebao@tal.com
 * @description
 * @date 2022/1/17 2:45 下午
 */
public class ArrayTest {

    /**
     * 1、前缀和：主要适⽤的场景是原始数组不会被修改的情况下，频繁查询某个区间的累加和
     */

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
                    preSum[i + 1][j + 1] = preSum[i][j + 1] + preSum[i + 1][j] + matrix[i][j] - preSum[i][j];
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

    /**
     * 2、差分数组：主要适⽤场景是频繁对原始数组的某个区间的元素进⾏增减。
     */

    class Difference{
        private int[] diff;

        public Difference(int[] arr) {
            assert arr != null && arr.length > 0;
            diff = new int[arr.length];
            diff[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                diff[i] = arr[i] - arr[i -1];
            }
        }

        public void increment(int i, int j, int inc) {
            diff[i] += inc;
            if (j + 1 < diff.length) {
                diff[j + 1] -= inc;
            }
        }

        public int[] getResult() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }




        /**
         * 力扣370：区间加法
         * 给一个长度为n的数组，初始情况下值都是0，你将会被给出k个操作，每个操作表示为一个三元组，[startIndex,endIndex,inc]，
         * 你需要将子数组A[startIndex...endIndex](包含startIndex和endIndex)增加inc,请你返回k次操作之后的数组
         * 例如：输入:length=5,updates=[[1,3,2],[2,4,3],[0,2,-2]],输出[-2,0,3,5,3]
         * 解释：初始状态[0,0,0,0,0],操作[1,3,2]后，变为：[0,2,2,2,0],操作[2,4,3]后，变为[0,2,5,5,3]，操作[0,2,-2]后，变为[-2,0,3,5,3]
         */
        public int[] getModifiedArray(int length, int[][] updates) {
            for (int i = 0; i < updates.length; i++) {
                int[] update = updates[i];
                int startIndex = update[0];
                int endIndex = update[1];
                int inc = update[2];
                increment(startIndex, endIndex, inc);
            }
            return getResult();
        }
    }

}
