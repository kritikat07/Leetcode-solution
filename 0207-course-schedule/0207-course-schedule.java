class Solution {
      public boolean dfs(int node, List<List<Integer>> adj, int[] vis) {
        vis[node] = 1; 
        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                if (!dfs(it, adj, vis))
                    return false;
            } else if (vis[it] == 1) {
                return false; 
            }
        }
        vis[node] = 2; 
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }
        int[] vis = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                if (!dfs(i, adj, vis))
                    return false;
            }
        }
        return true;
    }
}