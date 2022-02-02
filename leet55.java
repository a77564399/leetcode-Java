public class leet55 {
//    static boolean flag = false;
//    public static boolean canJump(int[] nums) {
//        if(nums[0]==0)
//            return false;
//        DFS(nums,0);
//        return flag;
//
//    }
//    private static boolean DFS(int[] nums,int nowPlace)
//    {
//        if(nowPlace==nums.length-1)
//            flag=true;
//        for(int i=1;i<=nums[nowPlace];i++)
//        {
//            if(nowPlace+i<nums.length)
//                DFS(nums,nowPlace+i);
//        }
//        return false;
//    }


    public static boolean canJump(int[] nums) {
        if(nums.length==0)
            return true;
        return DFS(nums,nums.length-1);
    }
    private static boolean DFS(int[] nums,int target)
    {
        if(target==0)
            return true;
        for(int i=target;i>=0;i--)
        {
            if(nums[i]>=target-i)
                return DFS(nums,target-1);
        }
        return false;
    }



    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        boolean res = canJump(nums);
        System.out.println(res);

    }
}
