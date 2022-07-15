class Solution {
   private boolean isVowel(char c){
        return (c=='a' || c=='e' || c=='i' || c=='o' || c=='u');
    }
    
    public int maxVowels(String s, int k) {
        int i=0,j=0,vcount=0,res=0;
        
        while(j<s.length()){
            
            if(isVowel(s.charAt(j))){
                vcount++;
            }
            
            if(j-i+1 < k){
                j++;
            }
            
            else if(j-i+1 == k){
                
                res=Math.max(res,vcount);
                
                if(isVowel(s.charAt(i))){
                    vcount--;
                }
                
                i++;
                j++;
            }
        }
        
        return res;
    }
}