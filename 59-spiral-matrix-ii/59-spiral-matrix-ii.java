class Solution {
    public int[][] generateMatrix(int n) {
        int minR = 0 , minC = 0 , maxR= n-1, maxC = n-1, cnt = 1 , total = n*n;
        boolean fl = true;
        int[][] mat = new int[n][n];
        while(fl){
            fl = false;
           for(int col = minC;col <= maxC && cnt <= total ; col++){
               mat[minR][col] = cnt++;
               fl = true;
           } 
            minR++;
            for(int row = minR;row <= maxR && cnt <= total ; row++){
               mat[row][maxC] = cnt++;
               fl = true;
           }
           maxC--;
            for(int col = maxC;col >= minC && cnt <= total ; col--){
               mat[maxR][col] = cnt++;
               fl = true;
           }
            maxR--;
            for(int row = maxR;row >= minR && cnt <= total ; row--){
               mat[row][minC] = cnt++;
               fl = true;
           }
            minC++;
        }
        return mat;
    }
}