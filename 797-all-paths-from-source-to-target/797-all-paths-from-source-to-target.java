class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = graph.length;
        
        dfs(0, graph ,new ArrayList<>(), ans );
        return ans;
    }
    
    void dfs(int node , int[][] graph , List<Integer> paths , List<List<Integer>> ans ){
        if(node == graph.length - 1){
            paths.add(node);
            ans.add(new ArrayList<>(paths));
            paths.remove(paths.size()-1);
            return;
        }
        paths.add(node);
        for(int it : graph[node]){
            dfs(it , graph , paths,ans);   
        }
        paths.remove(paths.size()-1);
    }
}