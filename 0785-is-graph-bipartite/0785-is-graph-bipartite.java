class Solution {
    public boolean dfs(int node,int col,int[] colour,int [][]graph){
      colour[node]=col;
      for(int it:graph[node]){
        if(colour[it]==-1){
            if(dfs(it,1-col,colour,graph)==false) return false;
        }
        else if(colour[it]==col) return false;
      }
      return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
       int colour[]=new int[n];
       for(int i=0;i<n;i++){
        colour[i]=-1;
       } 
       for(int i=0;i<n;i++){
        if(colour[i]==-1){
           if( dfs(i,0,colour,graph)==false){
            return false;
           }
        }

       }
       return true;
    }
}