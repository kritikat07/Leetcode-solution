class Solution {
    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adj.get(flight[0]).add(
                    new int[]{flight[1], flight[2]}
            );
        }
        PriorityQueue<int[]> q =
                new PriorityQueue<>(
                        (a, b) -> a[1] - b[1]
                );
        q.add(new int[]{src, 0, 0});
        int[] bestStops = new int[n];
        Arrays.fill(bestStops, Integer.MAX_VALUE);
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int city = current[0];
            int cost = current[1];
            int stops = current[2];
            if (city == dst) {
                return cost;
            }
            if (stops > k || stops >= bestStops[city]) {
                continue;
            }
            bestStops[city] = stops;
            for (int[] neighbour : adj.get(city)) {
                  q.add(new int[]{
                        neighbour[0],
                        cost + neighbour[1],
                        stops + 1
                });
            }
        }
        return -1;
    }
}