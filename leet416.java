import java.util.Arrays;

public class leet416 {
    public static boolean canPartition(int[] nums) {

        /*
        本题实际是在找选取某些元素使其和=tar=sum(nums)/2
        构造dp[n][tar+1]  dp[i][j]表示前i个值的情况下是否存在选取一些数=j

        初始状态：dp[0][nums[0]] 选取第0个数使其值=nums[0]肯定是没问题的;  dp[i][0]=true  选取任意个数字=0,选取0个即可=true;

        状态转移方程，dp[i][j] 当nums[i]<=j时 可以再-nums[i] 有不放入第i个值=dp[i-1][j]  放入第i个值=dp[i-1][j-nums[i]]
         nums[i]>j时只能是不放入，因此只有=dp[i-1][j]

        结束状态：dp[n-1][target]
         */

        int n = nums.length;
        if(nums==null||nums.length==0||nums.length==1)
            return false;
        boolean flag = false;
//        Arrays.sort(nums);
        int sum=0;
        int maxNum = 0;
        for(int i:nums)
        {
            sum+=i;
            maxNum = Math.max(maxNum,i);
        }

        if(sum%2!=0) return false;
        int target = sum/2;
        if(maxNum>target) return false;

        boolean[][] dp = new boolean[n][target+1];
        for(int i=0;i<n;i++)
        {
            dp[i][0]=true;
        }
        dp[0][nums[0]] = true;

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=target;j++)
            {
                if(nums[i]<=j)
                {
                    dp[i][j] = (dp[i-1][j]||dp[i-1][j-nums[i]]);
                }else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n-1][target];

    }

    public static void main(String[] args) {
        int[] nums = new int[4];
        System.out.println(canPartition(new int[] {1,5,11,5}));
    }
}
