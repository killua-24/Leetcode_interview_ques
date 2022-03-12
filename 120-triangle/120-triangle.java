class Solution {
    int n;
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int[] row : dp) Arrays.fill(row , -1);
        return solve(0 , 0 ,triangle ,triangle.size() ,dp);
        
    }
    
    int solve(int i , int j , List<List<Integer>> triangle ,int n , int[][] dp){
        if (i == n - 1)
            return triangle.get(i).get(j);

        if (dp[i][j] != -1)
            return dp[i][j];

        int down = triangle.get(i).get(j) + solve(i + 1, j, triangle, n,dp);
        int diagonal = triangle.get(i).get(j) + solve(i + 1, j + 1, triangle, n,dp);

        return dp[i][j] = Math.min(down, diagonal);
        
    }
}