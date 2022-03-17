class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack();
        Map<Integer , Integer> map = new HashMap<>();
     
        for(int i =  nums2.length - 1 ; i>= 0 ; i--){
            while(!stack.isEmpty() && stack.peek() <= nums2[i]) stack.pop();
            
            int nex = stack.isEmpty() ? -1 : stack.peek();
            map.put(nums2[i] , nex);
            stack.push(nums2[i]);
        }
    
        int[] ans = new int[nums1.length];
        int ind = 0;
        for(int it : nums1){
            ans[ind++] = map.get(it);
        }
        
        return ans;
    }
}