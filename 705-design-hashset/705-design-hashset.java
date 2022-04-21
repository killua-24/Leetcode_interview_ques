class MyHashSet {
    int[] entry;
    public MyHashSet() {
       entry = new int[1000007];
    }
    
    public void add(int key) {
        entry[key]= 1;
    }
    
    public void remove(int key) {
        entry[key]= 0;
    }
    
    public boolean contains(int key) {
        return entry[key] == 1;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */