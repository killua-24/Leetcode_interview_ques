class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf =  new UnionFind(s.length());
        for(List<Integer> pair : pairs){
            uf.union(pair.get(0), pair.get(1));
        }
        
         Map<Integer,PriorityQueue<Character>> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            int r = uf.findPar(i);
            map.putIfAbsent(r,new PriorityQueue<Character>());
            map.get(r).offer(s.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            int r = uf.findPar(i);
            sb.append(map.get(r).poll());
        }
        return sb.toString();
        
    }
    
    class UnionFind{
        private int[] root;
        private int[] rank;
        
        public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++)
            root[i] = i;
    }

	public int findPar(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = findPar(root[x]);
    }

	public void union(int x, int y) {
        int rootX = findPar(x);
        int rootY = findPar(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }
        
    }
}