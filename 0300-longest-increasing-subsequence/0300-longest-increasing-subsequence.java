
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return n;
        int res = 1;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    count = Math.max(count, dp[j] + 1);
                }
            }
            dp[i] = count;
            res = Math.max(res, count);
        }
        return res;
    }
}
