class Solution {
    public boolean validPartition(int[] nums) {
        int[] dp = new int[nums.length]; 
        Arrays.fill(dp , -1);
        return helper(nums , 0 , dp) == 1;
    }
    
    private int helper(int[] nums , int i  ,int[] dp){
        if(i >= nums.length ) return 1;
        if(dp[i] != -1) return dp[i];
        if(i + 1 < nums.length && nums[i] == nums[i+1]){
            if(helper(nums,i+2 , dp) == 1) return dp[i] = 1;
            
            if(i + 2 < nums.length && nums[i+1] == nums[i+2]){
                if(helper(nums, i+3,dp) == 1) return dp[i] = 1;
            }
        }
        
        if(i+2 < nums.length && nums[i+1] - nums[i] == 1 && nums[i+2] - nums[i+1] ==1 ){
            if(helper(nums , i+3,dp) == 1) return dp[i] = 1;
        }
        return dp[i] = 0;
    }
}