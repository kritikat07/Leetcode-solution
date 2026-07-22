class node{
    int first;
    int second;
    int third;
    node(int first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
       int m=mat.length;
       int n=mat[0].length;
       Queue<node> q=new LinkedList<>();
       int [][] dis=new int[m][n];
       int [][] vis=new int[m][n];
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(mat[i][j]==0){
                q.add(new node(i,j,0));
                vis[i][j]=1;
            }
            else{
                vis[i][j]=0;
            }
        }
       }
       int[] delrow ={-1,0,1,0};
       int [] delcol={0,1,0,-1};
       while(!q.isEmpty()){
        int row=q.peek().first;
        int col=q.peek().second;
        int steps=q.peek().third;
        q.remove();
        dis[row][col]=steps;
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0){
                vis[nrow][ncol]=1;
                q.add(new node(nrow,ncol,steps+1));
            }
        }
       }
       return dis;
    }
}