class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };
        int[][] effortTo = new int[rows][cols];
        for (int[] row : effortTo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.offer(new int[]{0, 0, 0});
        effortTo[0][0] = 0;
        boolean[][] visited = new boolean[rows][cols];
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int effort = current[2];
            if (visited[row][col]) {
                continue;
            }
            visited[row][col] = true;
            if (row == rows - 1 && col == cols - 1) {
                return effort;
            }
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]) {
                    int diff = Math.abs(heights[newRow][newCol] - heights[row][col]);
                    int newEffort = Math.max(effort, diff);
                    if (newEffort < effortTo[newRow][newCol]) {
                        effortTo[newRow][newCol] = newEffort;
                        queue.offer(new int[]{newRow, newCol, newEffort});
                    }
                }
            }
        }
        return 0; 
    }
}