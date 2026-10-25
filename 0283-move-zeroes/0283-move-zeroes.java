class Solution {
    public void moveZeroes(int[] nums) {
        // int n=nums.length;
        // if(n==0){
        //     return;
        // }
        
        // int k=0;
        // for(int num:nums){
        //     if(num!=0) nums[k++]=num;
        // }
        // while(k<n){
        //     nums[k++]=0;
        // }
         int n=nums.length;
        //  if(n==0) return ;
         int k=0;
         for(int num:nums ){
            if(num!=0) {
                nums[k]=num;
                k++;
            }
         }
         while(k<n){
            nums[k++]=0;
         }
         
    }
}