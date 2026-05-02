class Solution {
    public int[] searchRange(int[] nums, int target) {
        int count=0;
        int first=-1;
        int last=-1;

       for(int i=0;i<nums.length;i++){
          if(nums[i]==target && count==0){
            first=i;
            count++;

          }
          else if(nums[i]==target && count!=0){
            last=i;
          }
       } 
        if (first != -1 && last == -1) {
            last = first;
        }
       return new int[] {first,last};
    }
}