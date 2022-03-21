class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
         int[] last = new int[26];
        for (int i = 0; i < s.length(); ++i)
            last[s.charAt(i) - 'a'] = i;
        
        int ind = 0 , max = 0;
        for (int i = 0; i < s.length(); ++i) {
            max = Math.max(max, last[s.charAt(i) - 'a']);
            if (i == max) {
                ans.add(i - ind + 1);
                ind = i + 1;
            }
        }
        
        return ans;
    }
}