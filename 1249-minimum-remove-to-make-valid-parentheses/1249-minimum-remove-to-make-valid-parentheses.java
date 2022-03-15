class Solution {
    class Pair{
        char c ;
        int ind ;
        
        Pair(char c , int ind){
            this.c = c;
            this.ind = ind;
        }
    }
    public String minRemoveToMakeValid(String s) {
        Stack<Pair> st = new Stack();
        Map<Character , Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            
            if(c == '('){
                st.push(new Pair(c , i));
            }else if(c == ')'){
                if(!st.isEmpty() && st.peek().c == '(' ){
                    st.pop();
                }else{
                    st.push(new Pair(c , i));
                }
            }
        }
        StringBuilder sb = new StringBuilder(s);
        while(!st.isEmpty()){
            Pair rem = st.pop();
            sb.deleteCharAt(rem.ind);
        }
        return sb.toString();
    }
}