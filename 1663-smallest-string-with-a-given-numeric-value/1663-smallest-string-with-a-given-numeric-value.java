class Solution {
    public String getSmallestString(int n, int k) {
        int sum = 0 , i = n;
        StringBuilder sb = new StringBuilder();;
        while(true){
            i--;
            if(sum + 26 + i >= k){
                sb.append((char)((k - (sum + i)) + 96));
                break;
            }
            sb.append('z');
            sum += 26;
        }
        
        while(i > 0){
            sb.append('a');
            i--;
        }
        return sb.reverse().toString();
    }
}