class MyHashMap {
    int[] entry;
    public MyHashMap() {
        entry = new int[1000005];
        Arrays.fill(entry,-1);
    }
    
    public void put(int key, int value) {
        entry[key] = value;
    }
    
    public int get(int key) {
        return entry[key];
    }
    
    public void remove(int key) {
        entry[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */