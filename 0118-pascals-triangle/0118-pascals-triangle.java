class Solution {
    public List<List<Integer>> generate(int numRows) {
       
        // List<List<Integer>> result = new ArrayList<>();
        // if (numRows == 0) {
        //     return result;
        // }

        // List<Integer> firstRow = new ArrayList<>();
        // firstRow.add(1);
        // result.add(firstRow);

        // for (int i = 1; i < numRows; i++) {
        //     List<Integer> prevRow = result.get(i - 1);
        //     List<Integer> currentRow = new ArrayList<>();
        //     currentRow.add(1);

        //     for (int j = 1; j < i; j++) {
        //         currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
        //     }

        //     currentRow.add(1);
        //     result.add(currentRow);
        // }

        // return result;
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<numRows;i++){
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
        return ans;
    }
}