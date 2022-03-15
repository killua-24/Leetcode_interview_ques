class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int st= 0 , end = n-1;
        
        while(st <= end){
            int mid = st + (end - st)/2;
            if (nums[st] == target) return st;
            if (nums[end] == target) return end;
            if(nums[mid] == target) return mid;
            if(nums[mid] >= nums[st]){
                if(target < nums[mid] && target >= nums[st]){
                    end = mid -1;
                }else{
                    st = mid + 1;
                }
            }
            if(nums[mid] <= nums[end]){
                if(target > nums[mid] && target <= nums[end]){
                    st = mid + 1;
                    
                }else{
                   end = mid -1;
                }
            }
        }
        return -1;
    }
}
