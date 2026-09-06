class Solution {
    int []dp;
    public int rob(int[] nums) {
        int n=nums.length;
      dp=new int[n+1];
      Arrays.fill(dp,-1);
      return rob1(nums,n-1);

    }
    private int rob1(int [] nums,int i){
        if(i<0) return 0;
        if(dp[i]!=-1){
            return dp[i];
        }

       int res=Math.max(rob1(nums,i-2)+nums[i],rob1(nums,i-1));
       dp[i]=res;
       return res;
    
    }
}