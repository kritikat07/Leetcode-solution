class Solution {
public:
    int reverse(int x) {
        int rev=0,digit;
       
        bool neg=x<0;
       
        while(x!=0){
           digit=x%10;
           if (rev > INT_MAX / 10 || (rev == INT_MAX / 10 && digit > 7))
                return 0; // positive overflow
            if (rev < INT_MIN / 10 || (rev == INT_MIN / 10 && digit < -8))
                return 0; // negative overflow
            rev=rev*10+digit;
            x/=10;
        }
        return rev;
    }
};