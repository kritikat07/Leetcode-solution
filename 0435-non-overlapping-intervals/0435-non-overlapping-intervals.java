class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
         Arrays.sort(intervals,(a,b)-> a[1]-b[1]);
         int preEnd=intervals[0][1];
         int res=0;
         for(int i=1;i<intervals.length;i++){
            if(preEnd>intervals[i][0] ){
                res++;
            } 
            else{
                preEnd=intervals[i][1];
            }
         }
         return res;
    }
}