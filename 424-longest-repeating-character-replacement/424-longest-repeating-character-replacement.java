class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        int right=0;
        int repeated=Integer.MIN_VALUE;
        int maxi=Integer.MIN_VALUE;
        HashMap<Character,Integer>map=new HashMap<>();
        
        while(right<s.length()){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            repeated=Math.max(repeated,map.get(s.charAt(right)));
            if(right-left+1-repeated > k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
            }
            maxi=Math.max(maxi,right-left+1);
            right++;
        }
        return maxi;
    }
}