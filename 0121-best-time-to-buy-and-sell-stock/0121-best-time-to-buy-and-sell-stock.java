class Solution {
    public int maxProfit(int[] prices) {
    //     int profit=0,mini=prices[0];
    //     for(int i=1;i<prices.length;i++){
    //         int cost=prices[i]-mini;
    //         profit=Math.max(profit,cost);
    //         mini=Math.min(mini,prices[i]);
    //     }
    //     return profit;
    int profit=0;
    int current =prices[0];
    int n=prices.length;
    for(int i=1;i<n;i++){
        if(prices[i]<current){
            current =prices[i];
            continue;
        }
        int cost=prices[i]-current;
        profit=Math.max(profit,cost);
    }
    return profit;
    }
}