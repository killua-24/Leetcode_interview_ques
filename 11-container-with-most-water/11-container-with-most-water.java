class Solution {
    public int maxArea(int[] height) {
        int maxW = Integer.MIN_VALUE;
        int i = 0 , j = height.length -1;
        
        while(i < j){
            int curr = Math.min(height[i] , height[j]) * (j - i);
            if(height[i] > height[j]){
                j--;
            }else{
                i++;
            }
            if(curr > maxW) maxW = curr;
        }
        return maxW;
    }
}