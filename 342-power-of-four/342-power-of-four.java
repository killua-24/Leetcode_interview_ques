class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0){
            return false; 
        }
        int a = (int)Math.ceil(Math.log(n)/Math.log(4));
        int b = (int)Math.floor(Math.log(n)/Math.log(4));
        
        return a==b;
    }
}