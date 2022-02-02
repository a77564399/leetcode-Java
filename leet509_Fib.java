public class leet509_Fib {
    //记忆化搜索
    public int fib(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        int[] count = new int[n+1];
        if(count[n]!=0)
            return count[n];
        else return fib(n-1)+fib(n-2);
    }
}
