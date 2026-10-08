class Solution {
    public int minCost(int n, int[] cuts) {        
int m = cuts.length;
        int[] arr = new int[m + 2];
        arr[0] = 0;
        arr[m + 1] = n;
        for (int i = 0; i < m; i++) {
            arr[i + 1] = cuts[i];
        }
        Arrays.sort(arr);
        int[][] dp = new int[m + 2][m + 2];
        for (int len = 2; len < m + 2; len++) {
            for (int l = 0; l + len < m + 2; l++) {
                int r = l + len;
                dp[l][r] = Integer.MAX_VALUE;
                for (int k = l + 1; k < r; k++) {
                    int cost = (arr[r] - arr[l])
                             + dp[l][k]
                             + dp[k][r];
                    dp[l][r] = Math.min(dp[l][r], cost);
                }
            }
        }

        return dp[0][m + 1];
    }
}