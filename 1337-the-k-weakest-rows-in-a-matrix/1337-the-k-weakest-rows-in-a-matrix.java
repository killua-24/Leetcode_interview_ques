class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ans = new int[k];
        int[][] freq = new int[mat.length][2];
        int ind = 0;
        for(int[] row : mat){
            for(int it : row){
                if(it == 1) freq[ind][0]++;
                else break;
            }
            freq[ind][1] = ind;
            ind++;
        }
     
        Arrays.sort(freq , (a,b) -> a[0] - b[0]);
 
        for(int i = 0 ; i < k ; i++){
            ans[i] = freq[i][1];
        }
            return ans;
    }
}