class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack();
        int j = 0;
        for(int it : pushed){
            stack.push(it);
            while(j < popped.length && !stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return j== popped.length;
    }
}