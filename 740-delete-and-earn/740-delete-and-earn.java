class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();
        int max = 0;
        for(int n : nums) {
            map.put(n , map.getOrDefault(n,0)+n);
            max = Math.max(max , n);
        }
        
        
        int secPrev = 0;
        int prev = map.getOrDefault(1,0);
        
        for(int n = 2 ; n < max + 1; n++){
            int temp = prev;
            prev = Math.max(prev , secPrev + map.getOrDefault(n , 0));
            secPrev = temp;
        }
        return prev;
    }
}