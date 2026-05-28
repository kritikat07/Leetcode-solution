class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n=candidates.length;
      List<List<Integer>>ans=new ArrayList<>();
      List<Integer>list=new ArrayList<>();
      check(0,ans,list,candidates,target,n);
      return ans;   
    }
    private void check(int ind,List<List<Integer>>ans,List<Integer>list,int[] candidates,int target,int n){
       if(target==0){
        ans.add(new ArrayList<>(list));
        return;
       }
       if(ind==n||target<0){
          return;
       } 
        list.add(candidates[ind]);
        check(ind,ans,list,candidates,target-candidates[ind],n);
        list.remove(list.size()-1);
        check(ind+1,ans,list,candidates,target,n);
    }
}