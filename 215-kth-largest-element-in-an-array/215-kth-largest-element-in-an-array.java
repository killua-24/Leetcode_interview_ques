class Solution {
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
        // System.out.println(pivot + " " + Arrays.toString(a));
        return j-1;
        
    }
    public int findKthLargest(int[] nums, int k) {
        int index = nums.length-k;
        int l = 0;
        int r = nums.length - 1;
        
        while(l < r){
            int pivot = nums[r];
            int pi = partition(nums,pivot ,l,r);
            
            if(pi == index) break;
            
            else if(pi < index) l = pi + 1;
            
            else r = pi - 1;
        }
        return nums[index];
    }
}

    
   