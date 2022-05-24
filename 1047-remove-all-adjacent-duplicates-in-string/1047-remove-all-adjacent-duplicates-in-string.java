class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack();
        
        for(char c: s.toCharArray()){
            
            if(!st.isEmpty() && c == st.peek()){
                st.pop();
            }else{
                st.push(c);
            }
            
            
        }
        
        String ans = "";
        while(!st.isEmpty()){
            ans = st.pop() + ans; 
        }
        
        return ans;
    }
}