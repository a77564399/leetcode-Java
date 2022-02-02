public class leet198 {
    /*
    将例子中的[2,7,9,3,1]拿出来分析，找出其初始元素，动态转移过程。
    发现其从2开始的最大值是2+从9开始的最大值。7开始的最大值是7+3开始的最大值。。。
    3开始最大值=3，1开始最大值是1
    因此，初始化为[1,3,0,0,0]
    dp[i]=nums[n-i-1]+dp[i-2]
    但此时遗漏了一种情况：间隔两个屋子其实也是可以的。+dp要在
     */
    public int rob(int[] nums) {
        int res = 0;
        int n = nums.length;
        if(nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        if (nums.length==2) return Math.max(nums[0],nums[1]);
        int[] dp = new int[n];
        dp[0]=nums[n-1];
        dp[1] = nums[n-2];
        dp[2] = nums[n-3]+dp[0];
        res = Math.max(dp[0],dp[1]);
        res = Math.max(res,dp[2]);
        for(int i=3;i<n;i++)
        {
            dp[i] = nums[n-i-1]+Math.max(dp[i-2],dp[i-3]);
            if(dp[i]>res) res = dp[i];
        }
        return res;
    }
}
