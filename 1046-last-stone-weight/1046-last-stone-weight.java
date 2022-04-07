class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int s : stones) pq.add(s);
        
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            if(a != b){
                pq.add(a-b);
            }
        }
        return pq.peek() == null ? 0 : pq.poll();
    }
}