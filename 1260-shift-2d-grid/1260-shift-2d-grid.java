class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length ;
        int n= grid[0].length;
        int shift = k % (m*n);
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ;i < m; i++){
            List<Integer> rows = new ArrayList<>();
            for(int j = 0 ; j < n ;j++) rows.add(1005);
            ans.add(rows);
        }
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ;j++){
                int shifted = shift + (i*n + j);
                int x = (shifted /n) % m ;
                int y = shifted %n ;
                ans.get(x).set(y , grid[i][j]);
            }
        }
        return ans;
    }
}