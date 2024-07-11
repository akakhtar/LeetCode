class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
           // Form a graph
         int V = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int indeg[] = new int[V];
        for(int i = 0;i<V;i++){
            for(int it : adj.get(i)){
                indeg[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<V;i++)
         if(indeg[i] == 0) q.add(i);

         int count = 0; 
         int topo[] = new int[V];
         while(!q.isEmpty()){
            int node = q.poll();
            topo[V-count-1] = node;
            count++;
            for(int it : adj.get(node)){
                indeg[it]--;
                if(indeg[it] == 0) q.add(it);
            }
         }

         if(count == V) return topo;
         int res[] = {};
         return res;

    }
}