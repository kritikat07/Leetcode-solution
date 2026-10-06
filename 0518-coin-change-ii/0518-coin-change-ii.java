class Solution {
    public int change(int amount, int[] coins) {
       int[] dp=new int[amount+1];
       dp[0]=1;
       for(int num:coins){
        for(int i=num;i<=amount;i++){
            dp[i] += dp[i - num];
        }
       } 
       return dp[amount];
    }
}