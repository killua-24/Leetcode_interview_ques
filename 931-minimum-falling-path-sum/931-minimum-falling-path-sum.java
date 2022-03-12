class Solution {
    public int minFallingPathSum(int[][] m) {
        int min = Integer.MAX_VALUE;
        int n = m.length;
        int[][] dp = new int[n][n];
        for(int[] row : dp)
        Arrays.fill(row , Integer.MAX_VALUE);
        for(int j = 0 ; j < n ; j++){
            min = Math.min(min , f(0 , j , m ,n , dp));
        }
        return min;
    }
    
    int f(int i , int j , int[][] m , int n , int[][] dp){
        
        if(i == n-1 && (j >= 0 && j < n)){
            return m[i][j];
        }
        if(j < 0 || j >= n) return 1000007;
        
        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        int left = m[i][j] + f(i + 1 , j -1 , m , n,dp);
        int d = m[i][j] + f(i + 1 , j , m , n,dp);
        int right = m[i][j] + f(i + 1 , j+1 , m , n,dp);
        
        return dp[i][j] = Math.min(left , Math.min(d , right));
    }
}