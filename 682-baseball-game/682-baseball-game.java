class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack();
        
        for(String s : ops){
            // System.out.println(st);
            if(s.equals("C")){
                st.pop();
            }else if(s.equals("D")){
                int n = st.peek();
                
                n = n*2;
                st.push(n);
            }else if(s.equals("+")){
                int b = st.pop();
                int a = st.pop();
                int c = a+b;
                st.push(a);
                st.push(b);
                st.push(c);
            }else{
                st.push(Integer.valueOf(s));
            }
        }
        int total = 0;
        while(!st.isEmpty()){
            total += st.pop();
        }
        return total;
    }
}