class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        for(int i = 0;i<n;i++) {
            color[i] = -1;
        }
        for(int i = 0;i<n;i++) {
            if(color[i] == -1) {
                if(!bfs(graph, i, color )) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean bfs(int[][] adj, int node, int color[] ) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 1;
        while(!q.isEmpty()) {
            Integer nde = q.poll();

            for(Integer it: adj[nde]) {
                if(color[it] == -1) {
                    color[it] = 1 - color[nde];
                    q.add(it);
                }
                else if(color[it] == color[nde]) {
                    return false;
                }
            }
        }
        return true;
    }
}