class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<List<int[]>> adj =new ArrayList<>();
        for (int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] time :times){
            int u=time[0];
            int v=time[1];
            int w=time[2];
            adj.get(u).add(new int[]{v,w});
        }
        int [] dis =new int [n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[k]=0;
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[0]-b[0]);
        q.offer(new int []{0,k});
        while(!q.isEmpty()){
            int [] curr=q.poll();
            int currDis=curr[0];
            int Node=curr[1];
            if(currDis>dis[Node]) continue;
            for(int [] neighbour: adj.get(Node)){
                int currNode = neighbour[0];
                int weight=neighbour[1];
                if(dis[Node] +weight < dis[currNode]){
                    dis[currNode]=dis[Node]+weight;
                    q.offer(new int [] {dis[currNode],currNode});
                }
            }
        }
        int maxWeight=0;
        for(int i=1;i<=n;i++){
            if(dis[i]==Integer.MAX_VALUE){
                return -1;
            }
            maxWeight=Math.max(maxWeight,dis[i]);
        }
        return maxWeight;
    }
}