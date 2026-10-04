class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if (Math.abs(target) > totalSum) {
            return 0;
        }
        if ((target + totalSum) % 2 != 0) {
            return 0;
        }
        int positiveSum = (target + totalSum) / 2;
        int[] dp = new int[positiveSum + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int sum = positiveSum; sum >= num; sum--) {
                dp[sum] += dp[sum - num];
            }
        }
        return dp[positiveSum];  
    }
}