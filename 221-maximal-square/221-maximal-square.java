class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] prev = new int[cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            int[] curr = new int[cols + 1];
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1'){
                    curr[j] = Math.min(Math.min(curr[j - 1], prev[j]), prev[j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, curr[j]);
                }
            }
            prev = curr;
        }
        return maxsqlen * maxsqlen;
    }
}