class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public void bfs(int row,int col,int [][]vis,char [][]grid){
        vis[row][col]=1;
        int m=grid.length;
        int n=grid[0].length;
        Queue<Pair>q=new LinkedList<Pair>();
        q.add(new Pair(row,col));
                int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    while (!q.isEmpty()) {
        int ro = q.peek().first;
        int co = q.peek().second;
        q.remove();

        for (int i = 0; i < 4; i++) {
            int nrow = ro + dr[i];
            int ncol = co + dc[i];
            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
                && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                vis[nrow][ncol] = 1;
                q.add(new Pair(nrow, ncol));
            }
        }
    }

    }
    public int numIslands(char[][] grid) {
        int count=0;
        int m=grid.length;
        int n=grid[0].length;
        int vis[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    count++;
                    bfs(i,j,vis,grid);
                }
            }
        }
        return count;
    }
}