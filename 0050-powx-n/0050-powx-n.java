class Solution {
    public double myPow(double x, int n) {
    //    if (n == 0) 
    //         return 1.0;

    //     if (n % 2 == 1) 
    //         return x * myPow(x, n - 1);

    //     if (n % 2 == 0) 
    //         return myPow(x * x, n / 2);

    //     return 1 / myPow(x, -n);
    
    // if(n==0){
    //     return 1;
    // }
    //    if(n<0){
    //     n=-n;
    //     x=1/x;
    //    }
    // return (n%2==0)? myPow(x*x,n/2): x*myPow(x*x,n/2);
    long N=n;
           if(N< 0){
            N = -N;
            x = 1 / x;
        }
        double res =1.0;
        while(N!=0){
            if(N%2==1){
                res*=x;
            }
            x*=x;
            N/=2;
        }

        
          
    return res;
    
    } 
}