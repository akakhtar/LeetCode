class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            addEdge(adj, i, i + 1);
        }

        int[] result = new int[queries.length];
        for (int k = 0; k < queries.length; k++) {
            int u = queries[k][0], v = queries[k][1];
            addEdge(adj, u, v);
            // Perform BFS from node 0 to update distances
            Queue<Integer> q = new LinkedList<>();
            q.offer(0);
            boolean[] visited = new boolean[n];
            visited[0] = true;

            while (!q.isEmpty()) {
                int node = q.poll();
                for (int neighbor : adj.get(node)) {
                    if (!visited[neighbor]) {
                        distance[neighbor] = distance[node] + 1;
                        visited[neighbor] = true;
                        q.offer(neighbor);
                    }
                }
            }

            result[k] = distance[n - 1] == Integer.MAX_VALUE ? -1 : distance[n - 1];
        }

        return result;
    }

    void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }
}