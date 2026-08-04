class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List< Integer> >reverse=new ArrayList<>();
        int v=graph.length;
        for(int i=0;i<v;i++){
            reverse.add(new ArrayList<>());

        }
        int [] indgree=new int[v];
        for(int i=0;i<v;i++){
            //i->it
            // it->i
            for(int it:graph[i]){
                reverse.get(it).add(i);
                indgree[i]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
       ArrayList<Integer> safe=new ArrayList<>();
        for(int i=0;i<v;i++){
            if(indgree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            safe.add(node);
            for(int it:reverse.get(node)){
                indgree[it]--;
                if(indgree[it]==0) q.add(it);
            }
        }
        Collections.sort(safe);
        return safe;
    }
}