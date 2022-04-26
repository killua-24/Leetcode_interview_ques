class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        
        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> (a.getKey() - b.getKey()));;
        boolean[] vis = new boolean[n];
        
        heap.add(new Pair(0, 0));
        int totalCost = 0 , edges = 0;
        
        while (edges < n) {
            Pair<Integer, Integer> topElement = heap.poll();
            
            int cost = topElement.getKey();
            int node = topElement.getValue();
            
            if (vis[node]) {
                continue;
            }
            
            vis[node] = true;
            totalCost += cost;
            edges++;
            
            for (int it = 0; it < n; ++it) {
                // If next node is not in MST, then edge from curr node
                // to next node can be pushed in the priority queue.
                if (!vis[it]) {
                    int newCost = Math.abs(points[node][0] - points[it][0]) + 
                                     Math.abs(points[node][1] - points[it][1]);
        
                    heap.add(new Pair(newCost, it));
                }
            }
        }
        
        return totalCost;
    }
}