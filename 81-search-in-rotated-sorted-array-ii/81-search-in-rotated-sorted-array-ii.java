class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 1){
            return target == nums[0];
        }
        
        int pivot = findPivot(nums)==-1? nums.length-1: findPivot(nums);
        
        if(nums[pivot] == target){
            return true;
        }
        
        if(target >= nums[0]){
            if(binarySearch(nums,target,0,pivot) != -1)
                return true;
        }else{
            if(binarySearch(nums,target,pivot+1,nums.length-1) != -1)
                return true;
        }
        
        return false;
        
    }
    
    int findPivot(int[] arr){
        int start = 0;
        int end = arr.length-1;
        
        while(start <=  end){
            int mid = start + (end - start )/2;
            
            if(mid < end &&arr[mid] > arr[mid+1]){
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid-1]){
                return mid-1;
            }
            if(arr[start] == arr[mid] && arr[mid] == arr[end]){
                if(start < arr.length -1 && arr[start] > arr[start +1]){
                   return start; 
                }
                start++;
                if(end > 0 && arr[end] < arr[end -1]){
                   return end-1; 
                }
                end--;
            }else{
            
            if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])){
                start = mid+1;
            }else{
                end = mid -1;
            }
        }
        }
            return -1;
    
    }
    
    int binarySearch(int[] arr,int target, int start, int end){
        while(start <=  end){
            int mid = start + (end - start )/2;
            
            if(arr[mid] == target) return target;
            else if(arr[mid] < target){
                start = mid + 1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }
}