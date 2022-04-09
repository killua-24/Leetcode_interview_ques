class Solution {
    public int arraySign(int[] nums) {
        boolean zero  = false;
        int neg = 0;
        for(int n : nums){
            if(n < 0) neg++;
            else if(n == 0) zero = true;
        }
        
        if(zero) return 0;
        return neg % 2 == 0 ? 1 : -1;
    }
}