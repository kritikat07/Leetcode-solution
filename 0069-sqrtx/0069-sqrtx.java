class Solution {
    public int mySqrt(int x) {
       if(x==0||x==1)
       return x;
       int low=1,high=x,ans=0;
       while(low<=high){
        int mid=low+(high-low)/2;
        long sqrt=(long) mid*mid;
        if(sqrt==x)
        return mid;
        else if(sqrt<x){
            ans=mid;
            low=mid+1;
        }
        else{
            high=mid-1;
        }
       } 
     return ans;
    }
}