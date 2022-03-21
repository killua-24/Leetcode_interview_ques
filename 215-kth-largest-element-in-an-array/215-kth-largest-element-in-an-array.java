class Solution {
    private final Random rnd = new Random();
    private void swap(int[] a, int x, int y){
       int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
    private int partition(int[] a, int pivot , int l, int r){
        
        int j = l;
        
        for(int i = l; i <= r ; i++){
            if(a[i] <= pivot){
                swap(a,i,j++);
            }
        }
        
        return j-1;
        
    }
    public int findKthLargest(int[] nums, int k) {
        int index = nums.length-k;
        int l = 0;
        int r = nums.length - 1;
        
        while(l < r){
            int pivot = nums[r];
            int high = partition(nums,pivot ,l,r);
            
            if(high == index) break;
            
            else if(high < index) l = high + 1;
            
            else r = high - 1;
        }
        return nums[index];
    }
}

    
   