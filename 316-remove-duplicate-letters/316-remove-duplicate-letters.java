class Solution {
    public String removeDuplicateLetters(String s) {
        int[] ind = new int[26];
        for (int i = 0; i < s.length(); i++){
            ind[s.charAt(i) - 'a'] = i;
        }
        
        boolean[] mark = new boolean[26]; 
        Stack<Integer> st = new Stack();
        
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            if (mark[curr]) continue; 
            while (!st.isEmpty() && st.peek() > curr && i < ind[st.peek()]){
                mark[st.pop()] = false; 
            }
            st.push(curr);
            mark[curr] = true; 
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty())
            sb.append((char) (st.pop() + 'a'));
        return sb.reverse().toString();
    }
} 