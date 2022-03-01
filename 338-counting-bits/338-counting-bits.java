class Solution {
    public int[] countBits(int n) {
        List<Integer> al = new ArrayList<>();
        
        for(int i = 0 ; i <= n ;i++){
            String bin = Integer.toBinaryString(i);
            int cnt = 0;
            for(char c : bin.toCharArray()){
                if(c == '1') cnt++;
            }
            al.add(cnt);
        }
        
        int[] arr = al.stream().mapToInt(i -> i).toArray();
        return arr;
    }
}