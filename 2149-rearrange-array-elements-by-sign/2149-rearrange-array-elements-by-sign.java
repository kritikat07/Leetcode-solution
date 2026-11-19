class Solution {
    public int[] rearrangeArray(int[] nums) {
        // int []out=new int[nums.length];
        // int j=0;
        // int k=1;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]>=0){
        //         out[j]=nums[i];
        //         j+=2;
        //     }
        //     else{
        //         out[k]=nums[i];
        //         k+=2;
        //     }
        // }
        // return out;
      int n = nums.length;
int arr1[] = new int[n];
int arr2[] = new int[n];
int arr3[] = new int[n];

int l = 0;
for (int i = 0; i < n; i++) {
    if (nums[i] >= 0) {
        arr1[l] = nums[i];
        l++;
    }
}

int k = 0;
for (int i = 0; i < n; i++) {
    if (nums[i] < 0) {
        arr2[k] = nums[i];
        k++;
    }
}

int p = 0, q = 0;

for (int i = 0; i < n; i++) {
    if (i % 2 == 0) {
        arr3[i] = arr1[p];
        p++;
    } else {
        arr3[i] = arr2[q];
        q++;
    }
}

return arr3;
    }
}