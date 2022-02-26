class Solution {
    public int shortestPathLength(int[][] graph) {
        if (graph.length == 1) {
            return 0;
        }
        
        int n = graph.length;
        int target = (1 << n) - 1;
        boolean[][] visited = new boolean[n][target];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            queue.offer(new int[]{i, 1 << i});
        }
        int step = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; ++i) {
                int[] cur = queue.poll();
                int node = cur[0];
                int state = cur[1];
                if (state == target) {
                    return step;
                }
                if (visited[node][state]) {
                    continue;
                }
                visited[node][state] = true;
                for (int next : graph[node]) {
                    queue.offer(new int[]{next, state | (1 << next)});
                }
            }
            step++;
        }
        return -1;
    }
}