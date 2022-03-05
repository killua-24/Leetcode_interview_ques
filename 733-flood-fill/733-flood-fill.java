class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
       if(newColor == image[sr][sc]) return image;
        dfs(image , sr , sc , newColor , image[sr][sc]);
        return image;
    }
    
    private void dfs(int[][] image, int i, int j, int newColor , int prevColor){
        if(image[i][j] != prevColor) return;
        
        image[i][j] = newColor;
        
        if(i + 1 < image.length) dfs(image , i+1,j,newColor , prevColor);
        if(j + 1 < image[0].length) dfs(image , i,j+1,newColor , prevColor);
        if(i >= 1) dfs(image , i-1,j,newColor , prevColor);
        if(j >= 1) dfs(image , i,j-1,newColor , prevColor);
        
    }
}