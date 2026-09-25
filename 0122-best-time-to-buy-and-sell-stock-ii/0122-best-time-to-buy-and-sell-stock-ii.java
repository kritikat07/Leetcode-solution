class Solution {
    public int maxProfit(int[] prices) {
         int profit = 0;
        int current = prices[0];
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            if (prices[i] < current) {
                current = prices[i];
                continue;
            }
            profit += prices[i] - current;
            current = prices[i];
        }
   return profit;

    }
}