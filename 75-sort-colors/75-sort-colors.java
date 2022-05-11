class Solution {
    public void sortColors(int[] a) {
        int n = a.length;
        int low = 0;
        int high = n-1;
        int mid = 0, temp = 0;
        
        while(mid <= high){
            switch(a[mid]){
            
                case 0:{
                    temp = a[mid];
                    a[mid] = a[low];
                    a[low] = temp;
                    low++;
                    mid++;
                    break;
                }
                case 1:{
                    mid++;
                    break;
                }
                case 2:{
                    temp = a[mid];
                    a[mid] = a[high];
                    a[high] = temp;
                    high--;
                    break;
                }
            }
        }
    }
}