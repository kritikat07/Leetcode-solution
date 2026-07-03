class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count=0;
        int n=isConnected.length;
        boolean [] vis =new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(isConnected,vis,i);
            }
        }
        return count;
    }
    static void dfs(int[][] isConnected,boolean []vis,int node){
        vis[node]=true;
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[node][i]==1 && vis[i]==false){
                dfs(isConnected,vis,i);
            }
        }
    }
}