class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer , Integer> mapIndexes = new HashMap<>();
        int[] ans = {-1,-1};
        for(int i = 0 ; i < nums.length ; i++){
            if(mapIndexes.containsKey(target - nums[i])){
                ans[0] = mapIndexes.get(target - nums[i]);
                ans[1]= i;
                return ans;
            }
            mapIndexes.put(nums[i] , i);
            
        }
        return ans;
    }
}