class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int INF=1000000000;
        int [][] dis =new int [n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    dis[i][j]=0;
                }
                else{
                    dis[i][j]=INF;
                }
            }
        }
        for(int[]edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            dis[u][v]=w;
            dis[v][u]=w;
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dis[i][k]!=INF && dis[k][j]!=INF){
                        dis[i][j]=Math.min(dis[i][j],dis[i][k]+dis[k][j]);
                    }
                }
            }
        }
        int answer=-1;
        int minCities=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(i!=j && dis[i][j]<= distanceThreshold){
                    count++;
                }
            }
            if(count<=minCities){
                minCities=count;
                answer=i;
            }
        }
        return answer;
    }
}