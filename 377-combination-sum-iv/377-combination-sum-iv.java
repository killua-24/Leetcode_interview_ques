class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(nums.length == 1) return nums[0] > target ? 0 : 1;
        int[] dp = new int[target +1];
        Arrays.fill(dp,-1);
        dp[0] = 1;
        for(int t = 1 ; t <= target ; t++){
            int ans = 0;
            for(int i = 0 ; i < nums.length ;i++){
                if(nums[i] > t) continue;
                ans += dp[ t - nums[i] ];
            }
            dp[t] = ans;
        }
        
        return dp[target];
     
    }
    
    private int helper( int[] nums, int t , int[] dp){
        if(dp[t] != -1) return dp[t];
        
        if(t == 0){
            return 1;
        } 
        int ans = 0;
        for(int i = 0 ; i < nums.length ;i++){
            if(nums[i] > t) continue;
            ans += helper( nums , t - nums[i] , dp);
        }
        dp[t] = ans;
        return ans;
    }
}