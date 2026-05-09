class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
       List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        int n=nums.length;
        check(nums,n,list,ans,0);
        return ans;  
    }
    private void check(int[] nums,int n, List<Integer> list,List<List<Integer>> ans,int ind){
        
            ans.add(new ArrayList<>(list));
            
        
         for(Integer i=ind;i<n;i++){
              if (i > ind && nums[i] == nums[i - 1]) continue;
            
            list.add(nums[i]);
            check(nums, n, list, ans,i+1);
            list.remove(list.size() - 1);
        }
    }
}