class Solution {
    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        int sum = 0;
        for(int n : nums) sum ^= n;
        
        int rightMostBit = sum & (-sum);
        
        for(int n : nums){
            if((n & rightMostBit) == 0){
                ans[0] ^= n;
            }else{
                 ans[1] ^= n;
            }
        }
        
        return ans;
    }
}