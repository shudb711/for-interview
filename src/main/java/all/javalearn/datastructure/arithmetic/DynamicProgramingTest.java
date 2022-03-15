package all.javalearn.datastructure.arithmetic;

import java.util.Arrays;

/**
 * author:shudb
 * date:2022/3/5
 * email:shudebao@aliyun.com
 * description:
 */

public class DynamicProgramingTest {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,0,9,8,5,6,7,8,9,1,9,6,5,6,7,8,9,10,11,12};
        int i = lengthOfLIS(arr);
        System.out.println(i);
    }

    /**
     * 力扣322 零钱兑换
     * @param coins
     * @param amount
     * @return
     */
    public static int coinCharge(int[] coins, int amount) {
        int[] cache = new int[amount + 1];
        Arrays.fill(cache, -666);
        return dpFromTop(coins, amount, cache);

    }
    private static int dpFromTop(int[] coins, int amount, int[] cache) {
        //自顶向下
        if (cache[amount] != -666) return cache[amount];
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int subproblem = dpFromTop(coins, amount - coins[i], cache);
            if (subproblem < 0) continue;
            res = Math.min(res, subproblem + 1);
        }
        cache[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return cache[amount];
    }

    private static int coinCharge2(int[] coins, int amount) {
        //自底向上
        int[] arr = new int[amount + 1];
        Arrays.fill(arr, amount + 1);
        arr[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0) continue;
                arr[i] = Math.min(arr[i], arr[i - coins[j]] + 1);
            }
        }
        return arr[amount] == amount + 1 ? -1 : arr[amount];
    }

    /**
     * 力扣300 最长递增子序列
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums){
        int[] arr = new int[nums.length];
        Arrays.fill(arr, 1);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] >= nums[i]) continue;
                arr[i] = Math.max(arr[i], arr[j] + 1);
            }
        }
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }

    /**
     * 投掷n次骰子，点数和不小于m的概率 todo
     * @param n
     * @return
     */
    public static double dice(int n, int m) {

        return 0;
    }

    /**
     * 力扣64  最小路径和问题
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid){
        int[][] cache = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        return dp(grid, grid.length, grid[0].length, cache);
    }

    private static int dp(int[][] grid, int i, int j, int[][] cache) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        if (cache[i][j] != -1) {
            return cache[i][j];
        }
        cache[i][j] = Math.min(dp(grid, i, j - 1, cache), dp(grid,i - 1, j, cache)) + grid[i][j];
        return cache[i][j];
    }
}
