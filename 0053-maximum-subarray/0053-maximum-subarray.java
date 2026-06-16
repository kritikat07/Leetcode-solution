class Solution {
    public int maxSubArray(int[] nums) {
        //  int n = nums.length;
        // int max = Integer.MIN_VALUE, sum = 0;
        
        // for(int i=0;i<n;i++){
        //     sum += nums[i];
        //     max = Math.max(sum,max);
            
        //     if(sum<0) sum = 0;
        // }
        
        // return max;
    //     int n=nums.length;
    //     int max=Integer.MIN_VALUE;
    //     int sum=0;
    //     for(int num:nums){
    //         sum+=num;
            
    //         max=Math.max(sum,max);
    //         if(sum<0) sum=0;
    //     }
    //     return max;
    int n=nums.length;
    int sum=0;
    int max=nums[0];
    for(int num:nums){
        sum+=num;
        max=Math.max(sum,max);
        if(sum<0) sum=0;
    }
    return max;
    }
}