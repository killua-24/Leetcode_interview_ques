class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        
        for(int n : asteroids){
            if(n > 0)
                  st.push(n);
              else {
                  boolean flag = false;
                  while(st.size() > 0 && st.peek() > 0) {
                      if(st.peek() < Math.abs(n))
                          st.pop();
                      else if(st.peek() == Math.abs(n)) {
                          st.pop();
                          flag = true;
                          break;
                      }else {
                          flag = true;
                          break;
                      }
                  }
                  if(flag == false)
                      st.push(n);
              }
        }
        
        
        int[] ans = new int[st.size()];
        for(int i = ans.length - 1 ; i>= 0;i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}