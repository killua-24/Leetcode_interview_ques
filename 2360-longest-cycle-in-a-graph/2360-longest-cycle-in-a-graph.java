class Solution {
      int ans = -1;
    public int longestCycle(int[] edges) {
      
        int n = edges.length;
        boolean[] vis = new boolean[n];
        boolean[] dfsvis = new boolean[n];
        int dist[] = new int[n];
        for(int i = 0 ; i < n;i++){
            if(!vis[i]){
                dfs(edges , i , vis , dfsvis , dist , 0);
            }
        }
        
        return ans;
    }
    
    private void dfs(int[] edges , int node , boolean[] vis, boolean[] dfsvis , int[] d , int distance){
        if(node != -1){
            if(!vis[node]){
                vis[node] = true;
                dfsvis[node] = true;
                d[node] = distance;
                dfs(edges , edges[node] , vis ,dfsvis , d, distance + 1);
            }else if(dfsvis[node]){
                ans = Math.max(ans , distance - d[node]);
            }
            
            dfsvis[node] = false;
        }
    }
}