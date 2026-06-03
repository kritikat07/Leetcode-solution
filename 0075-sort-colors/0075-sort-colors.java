class Solution {
    public void sortColors(int[] nums) {
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i;j<nums.length;j++){
        //         if(nums[i]>nums[j]){
        //             int temp=nums[i];
        //             nums[i]=nums[j];
        //             nums[j]=temp;
        //         }
        //     }
        // }
        int low=0;
        int mid=0;
        int high=nums.length-1;
        
        while(mid<=high){
            if(nums[mid]==0){
                int temp=nums[low];
                nums[low++]=nums[mid];
                nums[mid++]=temp;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                int temp=nums[mid];
                nums[mid]=nums[high];
                nums[high--]=temp;
            }
        }
        
    }
}