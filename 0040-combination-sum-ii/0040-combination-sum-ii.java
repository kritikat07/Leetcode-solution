class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n=candidates.length;
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        check(0,target,  ans, list, n,candidates);
        return ans;    
    }
    private void check(int ind,int target,List<List<Integer>> ans,List<Integer> list,int n,int []arr){
        if(target<0) return;
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=ind;i<n;i++){
            if(i>ind&&arr[i]==arr[i-1]) continue;
            list.add(arr[i]);
          check(i+1,target-arr[i],  ans, list, n,arr);
          list.remove(list.size()-1);
        }
    }
}