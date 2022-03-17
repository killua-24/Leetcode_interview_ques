class Solution {
    public int scoreOfParentheses(String s) {
        
        Stack<Integer> stack = new Stack();
        stack.push(0);
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(0);
               
            }else{
                int B = stack.pop();
                int A = stack.pop();
                stack.push(A + Math.max(2*B , 1));
            }
        }
        return stack.pop();
    }
}