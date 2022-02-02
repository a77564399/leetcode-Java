public class leet121 {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) { // 特殊条件判断
            return 0;
        }
        int[][] dp = new int[n][2];

        // dp[i][0] 表示not_hold[i]
        // dp[i][1] 表示hold[i]

        // 子问题0初始状态
        dp[0][0] = 0; // 第0天不持股，手上拥有的现金数为 0
        dp[0][1] = -prices[0]; // 第0天持股，手上拥有的现金数为-prices[0]，因为需要花prices[0]去购买股票

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1],  -prices[i]);
//          此处 -price[i] 保证了只允许一次买入

        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        int res = maxProfit(new int[] {7,1,5,3,6,4});
        System.out.println(res);
    }

}
