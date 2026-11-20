class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map<Integer,Integer>map=new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        //     int complement =target-nums[i];
        //     if(map.containsKey(complement))
        //     return new int[]{map.get(complement),i};
        //    map.put(nums[i],i); 
        // }
        // return new int[]{};
        int n=nums.length;
        int ans[]=new int [2];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int sum=nums[i]+nums[j];
                if(sum==target){
                   ans[0]=i;
                   ans[1]=j;
                }
            }
        }
        return ans;
    }
}