public class leet746 {
    /*
简单dp问题
从后往前推，有三个格子就是看第二个格子的最小+第二个格子当前值(要两步)或者第三个格子的最小+第三个格子值(跳一步)
初始化第一个格子，cost[0]  第二个格子，cost[1]
动态转移方程  dp[i] = min(dp[i-1]+cost[i],dp[i-2]+cost[i])
终止条件：min(dp[n-1],dp[n-2])
 */
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==1) return cost[0];
        if(cost.length==2) return Math.min(cost[0],cost[1]);
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2;i<n;i++)
            dp[i] = Math.min(dp[i-1]+cost[i],dp[i-2]+cost[i]);
        System.out.println(dp);
        return Math.min(dp[n-1],dp[n-2]);
    }
}
