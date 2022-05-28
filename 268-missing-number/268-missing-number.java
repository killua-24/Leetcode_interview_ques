class Solution {
    public int missingNumber(int[] nums) {
         int ind = 0 , n = nums.length;
        
        while(ind < n){
            int correct = nums[ind];
            
            if(nums[ind] < n && nums[ind] != nums[correct]){
                swap(nums ,correct , ind);
            }else ind++;
        }
        int ans = n;
        for(int index = 0 ; index < n ; index++){
            if(index != nums[index]) ans = index;
        }
        return ans;
        
    }
    
    void swap(int[] nums , int x , int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}