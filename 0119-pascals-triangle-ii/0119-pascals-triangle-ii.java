class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        // Integer[] arr = new Integer[rowIndex+ 1];
        // Arrays.fill(arr, 0);
        // arr[0] = 1;
        
        // for (int i = 1; i <= rowIndex; i++) 
        //     for (int j = i; j > 0; j--) 
        //         arr[j] = arr[j] + arr[j - 1];
        
        // return Arrays.asList(arr);
            List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            ArrayList<Integer> row=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                row.add(1);
                }
            else{
                row.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
            }
            
            }
            ans.add(row);
        }
        return ans.get(rowIndex); 
        }
    
}