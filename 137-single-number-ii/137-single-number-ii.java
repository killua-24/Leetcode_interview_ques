class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();
        
        for(int n : nums){
            map.put(n , map.getOrDefault(n,0)+1);
        }
        int single = 0;
        for(int n : nums){
            if(map.get(n)== 1) single = n;
        }
        return single;
    }
}