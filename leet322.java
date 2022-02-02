public class leet322 {
    public static int coinChange(int[] coins, int amount) {
        if(amount<=0)
            return 0;
        return coinNum(coins,amount,new int[amount]);
    }
    private static int coinNum(int[] coins,int nowMoney,int[] count)
    {
        if(nowMoney<0)
            return -1;
        if(nowMoney==0)
            return 0;
        if(count[nowMoney-1]!=0)
            return count[nowMoney-1];
        int num = Integer.MAX_VALUE;
        for(int coin:coins)
        {
            if(coin<=nowMoney)
            {
                int ret = coinNum(coins,nowMoney-coin,count);
                if(ret>=0&&ret<num)
                    num = 1+ret;
            }
        }
        count[nowMoney-1] = (num==Integer.MAX_VALUE)? -1:num;
        return count[nowMoney-1];

    }

    public static void main(String[] args) {
        int res = coinChange(new int[] {1,2,5},11);
        System.out.println(res);
    }
}
