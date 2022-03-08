class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums , 0 , nums.length -1);
    }
    
    private int mergeSort(int[] nums , int left , int right){
        if(left >= right) return 0;
        int mid = (left + right)/2;
        int inv = mergeSort(nums , left , mid);
        inv += mergeSort(nums , mid + 1 , right);
        inv += merge(nums , left , mid , right);
        
        return inv;
    }
    
    private int merge(int[] nums , int low , int mid , int high){
        int cnt = 0;
        int j = mid + 1;
        for(int i = low ; i <= mid ; i++){
            while(j <= high && nums[i] > (2 * (long)nums[j])){
                j++;
            }
            cnt += j - (mid+1);
        }
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid+1;
        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp.add(nums[left++]);
            }else{
                temp.add(nums[right++]);
            }
        }
        
         while(left <= mid ){
             temp.add(nums[left++]);
         }
        while(right <= high){
             temp.add(nums[right++]);
        }
        
        for(int i = low ; i <= high ; i++){
            nums[i] = temp.get(i - low);
        }
        return cnt;
    }
}