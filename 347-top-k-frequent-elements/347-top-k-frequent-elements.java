class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int n : nums){
            map.put(n , map.getOrDefault(n,0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        
        for(var e : map.entrySet()){
            pq.add(e.getKey());
            while(pq.size() > k) pq.poll();
        }
        
        int[] ans = new int[k];
        
        for(int i = 0 ; i < k ; i++){
            ans[i] = pq.poll();
        }
        return ans;
    }
}