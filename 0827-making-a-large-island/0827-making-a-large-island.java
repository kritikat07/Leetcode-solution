// class DisjointSet {
//     List<Integer> parent = new ArrayList<>();
//     List<Integer> rank = new ArrayList<>();
//     List<Integer> size = new ArrayList<>();
 
//     public DisjointSet(int n) {
//         for (int i = 0; i <= n; i++) {
//             parent.add(i);
//             rank.add(0);
//             size.add(1);
//         }
//     }
 
//     public int findUPar(int node) {
//         if (node == parent.get(node)) return node;
//         int ulp = findUPar(parent.get(node));
//         parent.set(node, ulp); // path compression
//         return ulp;
//     }
 
//     public void unionByRank(int u, int v) {
//         int ulp_u = findUPar(u);
//         int ulp_v = findUPar(v);
//         if (ulp_u == ulp_v) return;
 
//         int rank_u = rank.get(ulp_u);
//         int rank_v = rank.get(ulp_v);
 
//         if (rank_u < rank_v) parent.set(ulp_u, ulp_v);
//         else if (rank_v < rank_u) parent.set(ulp_v, ulp_u);
//         else {
//             parent.set(ulp_v, ulp_u);
//             rank.set(ulp_u, rank_u + 1);
//         }
//     }
 
//     public void unionBySize(int u, int v) {
//         int ulp_u = findUPar(u);
//         int ulp_v = findUPar(v);
//         if (ulp_u == ulp_v) return;
 
//         int size_u = size.get(ulp_u);
//         int size_v = size.get(ulp_v);
 
//         if (size_u < size_v) {
//             parent.set(ulp_u, ulp_v);
//             size.set(ulp_v, size_u + size_v);
//         } else {
//             parent.set(ulp_v, ulp_u);
//             size.set(ulp_u, size_u + size_v);
//         }
//     }
// }
 
// class Solution {
//     public int largestIsland(int[][] grid) {
//         int n = grid.length;
//     DisjointSet ds = new DisjointSet(n * n);
//     for (int row = 0; row < n; row++) {
//         for (int col = 0; col < n; col++) {

//             if (grid[row][col] == 0)
//                 continue;

//             int dr[] = {-1, 0, 1, 0};
//             int dc[] = {0, -1, 0, 1};

//             for (int ind = 0; ind < 4; ind++) {

//                 int newr = row + dr[ind];
//                 int newc = col + dc[ind];

//                 if (isValid(newr, newc, n) && grid[newr][newc] == 1) {

//                     int nodeNo = row * n + col;
//                     int adjNodeNo = newr * n + newc;

//                     ds.unionBySize(nodeNo, adjNodeNo);
//                 }
//             }
//         }
//     }
//     // Try converting every 0 to 1
//     int mx = 0;
//     for (int row = 0; row < n; row++) {
//         for (int col = 0; col < n; col++) {
//             if (grid[row][col] == 1)
//                 continue;
//             int dr[] = {-1, 0, 1, 0};
//             int dc[] = {0, -1, 0, 1};
//             HashSet<Integer> components = new HashSet<>();
//             for (int ind = 0; ind < 4; ind++) {
//                 int newr = row + dr[ind];
//                 int newc = col + dc[ind];
//                 if (isValid(newr, newc, n)) {
//                     if (grid[newr][newc] == 1) {
//                         components.add(ds.findUPar(newr * n + newc));
//                     }
//                 }
//             }
//             int sizeTotal = 0;
//             for (Integer parents : components) {
//                 sizeTotal += ds.size.get(parents);
//             }
//             mx = Math.max(mx, sizeTotal + 1);
//         }
//     }
//     // Case where grid already contains all 1's
//     for (int cellNo = 0; cellNo < n * n; cellNo++) {
//         mx = Math.max(mx, ds.size.get(ds.findUPar(cellNo)));
//     }
// return mx;
//     }
//         private boolean isValid(int row, int col, int n) {
//         return row >= 0 && row < n && col >= 0 && col < n;
//     }
// }

class Solution {
    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> regionsArea = new HashMap<>();
        regionsArea.put(0,0);
        
        int n = grid.length;
        int region = 2;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int area = floodFill(grid, i, j, region);
                    regionsArea.put(region, area);
                    region++;
                }
            }
        }
        
        int max = regionsArea.getOrDefault(2,0);
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                if(grid[r][c]==0){
                    Set<Integer> neighbors = new HashSet<>();
                    neighbors.add(r>0?grid[r-1][c]:0);
                    neighbors.add(c>0?grid[r][c-1]:0);
                    neighbors.add(r<n-1?grid[r+1][c]:0);
                    neighbors.add(c<n-1?grid[r][c+1]:0);
                    int area = 1;
                    for(int neighbor: neighbors){
                        area+=regionsArea.get(neighbor);
                    }
                    if(area>max){
                        max = area;
                    }
                }
            }
        }
        
        return max;
    }
    
    public int floodFill(int[][] grid, int r, int c, int region) {
        int n = grid.length;
        if(r<0||r>=n||c<0||c>=n||grid[r][c]!=1){
            return 0;
        }
        
        grid[r][c] = region;
        
        int sum = 1;
        sum+=floodFill(grid, r, c+1, region);
        sum+=floodFill(grid, r+1, c, region);
        sum+=floodFill(grid, r, c-1, region);
        sum+=floodFill(grid, r-1, c, region);
        
        return sum;
    }
}