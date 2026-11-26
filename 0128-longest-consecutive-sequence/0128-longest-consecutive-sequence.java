class Solution {
    public int longestConsecutive(int[] nums) {
       Set<Integer> set=new HashSet<>();
       for(int num:nums){
        set.add(num);
       }
       int longest=0;
       for(int num:set){
        if(!set.contains(num-1)){
            int start=num;
            int end=1;
            while(set.contains(start+1)){
                start++;
                end++;
            }
            longest=Math.max(longest,end);
        }
       }
       return longest;
    }
}