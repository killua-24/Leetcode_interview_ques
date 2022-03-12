class Solution {
    int total;
    public int findTargetSumWays(int[] nums, int target) {
        total = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length][2*total + 1];
        for(int[] row : dp) Arrays.fill(row , Integer.MIN_VALUE);
        return ways(nums , 0 , 0 ,target, dp);
        
    }
    
    private int ways(int[] nums,int ind , int sum , int target ,int[][] dp){
        if(ind == nums.length && sum != target) return 0;
        if(ind == nums.length && sum == target) return 1;
        if(dp[ind][sum + total] != Integer.MIN_VALUE) return dp[ind][sum +total];
        int count = 0;
        
        count = ways(nums, ind  + 1 , sum - nums[ind] , target, dp) + ways(nums, ind  + 1 , sum + nums[ind] , target, dp) ;
        
        return dp[ind][sum +total]  = count;
    }
}