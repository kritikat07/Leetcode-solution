class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int a = pre[0], b = pre[1];
            graph.get(b).add(a);   
        }
        int[] state = new int[numCourses];  
        int[] result = new int[numCourses];
        int[] index = {numCourses - 1};     
        for (int course = 0; course < numCourses; course++) {
            if (state[course] == 0) {
                if (!dfs(course, graph, state, result, index)) {
                    return new int[0];        
                }
            }
        }
        return result;
    }
    private boolean dfs(int course, List<List<Integer>> graph, int[] state,
                         int[] result, int[] index) {
        if (state[course] == 1) return false;   
        if (state[course] == 2) return true;    
        state[course] = 1;  
        for (int next : graph.get(course)) {
            if (!dfs(next, graph, state, result, index)) {
                return false;
            }
        }
        state[course] = 2;              
        result[index[0]--] = course;    
        return true;
    }
}