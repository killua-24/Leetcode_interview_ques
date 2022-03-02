class Solution {
    public int findTheWinner(int n, int k) {
        if(n == 1) return n;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n ; i++){
            q.add(i);
        }
        
        while(q.size() != 1){
            int steps = k;
            while(steps-- > 1){
                int skip = q.poll();
                q.add(skip);
            }
            q.poll();
        }
        return q.peek();
    }
}