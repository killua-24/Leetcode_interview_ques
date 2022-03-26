class Node{
    Node[] links = new Node[2];
    public Node(){}
    boolean containsKey(int ind){
        return (links[ind] != null);
    }
    
    Node get(int ind){
         return links[ind];
    }
    
    void put(int ind , Node node){
        links[ind] = node;
    }
} 

class Trie{
    static Node root;
    public Trie(){
        root = new Node();
    }
    
    public void insert(int num){
        Node node = root;
        for(int i = 31 ; i >= 0 ; i--){
            int bit = (num >> i) & 1;
            if(!node.containsKey(bit)) node.put(bit,new Node());
            node = node.get(bit);
        }
    }
    
    public int getMax(int num){
        Node node = root;
        int maxNum = 0;
        for(int i = 31 ; i >= 0 ; i--){
            int bit = (num >> i) & 1;
            if(node.containsKey(1 - bit)) {
                maxNum = maxNum | (1<<i);
                 node = node.get(1-bit);
            }else
            node = node.get(bit);
        }
        return maxNum;
    }
}

class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
    Trie trie = new Trie();
    HashMap<int[], Integer> map = new HashMap<>();
    for(int i=0; i<queries.length; i++){
        map.put(queries[i], i);
    }
    
    Arrays.sort(nums);
    Arrays.sort(queries, (a, b) -> a[1] - b[1]);
    
    int ans[] = new int[queries.length];
    int indx = 0;
    for(int i=0; i<queries.length; i++){
        while(indx < nums.length && nums[indx] <= queries[i][1]){
            trie.insert(nums[indx]);
            indx++;
        }
        
        if(nums[0]>queries[i][1])
            ans[map.get(queries[i])] = -1;
        else{
            int num = trie.getMax(queries[i][0]);
            ans[map.get(queries[i])] = num;
        }
    }
    
    return ans;
    }
}