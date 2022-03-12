class Solution {
    public int minFallingPathSum(int[][] m) {
        int n = m.length;
        if(n==1) return m[0][0];
         int[][] dp = new int[n][n];
        for(int[] row : dp)
        Arrays.fill(row , Integer.MAX_VALUE);
         int min = Integer.MAX_VALUE;
        for(int j = 0 ; j < n ; j++){
            min = Math.min(min ,f(0,j , m ,n , dp));
        }
        return min;
    }
    
    int f(int  i , int last , int[][] m , int n, int[][] dp ){
        if(i == n-1 ){
            int min = 10000009;
           for(int j = 0 ; j < n ; j++){
            if(j != last)
                min = Math.min(min , m[i][j]);
            }
            return min;
        }
        if(dp[i][last] !=  Integer.MAX_VALUE) return dp[i][last];
        int min = 10000009;
        for(int j = 0 ; j < n ; j++){
            if(j != last)
            min = Math.min(min , m[i][j] + f(i+1,j,m,n,dp));
        }
            
        return dp[i][last] = min;
    }
}