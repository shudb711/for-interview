package all.javalearn.datastructure.arithmetic;

/**
 * 凑零钱问题:最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1
 * todo
 */
public class CoinCharge {

    /**暴力递归
     * @param coins
     * @param amount
     * @return最少需要凑出这个金额的硬币数
     */
    public static int coinCharge1(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int count = Integer.MAX_VALUE - 1;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            if (amount - coin < 0) {
                continue;
            }
            int innnerCount = coinCharge1(coins, amount - coin);
            if (innnerCount < 0) {
                continue;
            }
            count = Math.min(count, innnerCount + 1);
        }
        return count == Integer.MAX_VALUE - 1 ? -1 : count;
    }

    /**
     * 递归，备忘录
     * @param coins
     * @param amount
     * @return
     */
    public static int coinCharge2(int[] coins, int amount, int[] memory) {
        if (amount == 0) {
            return 0;
        }
        int count = Integer.MAX_VALUE - 1;
        int innnerCount;
        if (memory[amount] > 0) {
            count = memory[amount];
        } else {
            for (int i = 0; i < coins.length; i++) {
                int coin = coins[i];
                if (amount - coin < 0) {
                    continue;
                }
                innnerCount = coinCharge2(coins, amount - coin, memory);
                if (innnerCount < 0) {
                    continue;
                }
                count = Math.min(count, innnerCount + 1);
                memory[amount] = count;
            }
        }
        return count == Integer.MAX_VALUE - 1 ? -1 : count;
    }

    /**
     * 自下而上
     * @param coins
     * @param amount
     * @return
     */
    public static int coinCharge3(int[] coins, int amount, int[] dp){
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                if (i - coin < 0)continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = {1,2,5,7};
        int amount = 80;
//        System.out.println(coinCharge1(coins, amount));

        int[] memory = new int[amount + 1];
        System.out.println(coinCharge2(coins, amount, memory));

        System.out.println(coinCharge3(coins, amount, memory));

        System.out.println();
    }
}