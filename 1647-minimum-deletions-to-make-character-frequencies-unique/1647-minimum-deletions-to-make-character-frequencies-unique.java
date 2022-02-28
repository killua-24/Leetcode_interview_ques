class Solution {
    public int minDeletions(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        int cnt = 0;
        for(char ch : map.keySet()) {
            int freq = map.get(ch);
            if(!set.contains(freq)) set.add(freq);
            else {
                while(set.contains(freq) && freq > 0) {
                    cnt++;
                    freq--;
                } 
                if(freq > 0) set.add(freq);
            }
        }
        
        return cnt;
    }
}