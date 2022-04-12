class Solution {
    // < 2 == dies
    // 2, 3 == lives
    // > 3 == dies
    // == 3 == live
    public void gameOfLife(int[][] board) {
        int[][] newg = new int[board.length][board[0].length];
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(board[i][j] == 0){
                    checkZero(board,newg,i,j);
                }else{
                    checkOnes(board,newg,i,j);
                }
            }
        }
                
        for(int i=0; i<board.length; i++)
            for(int j=0; j<board[0].length; j++)
                board[i][j]=newg[i][j];
    }
        
    private void checkOnes(int[][] board , int[][] newg , int i , int j){
        int count = 0;
        
        if(i > 0 && board[i-1][j] == 1){
          count++;  
        }
        if(i > 0 && j > 0 && board[i-1][j-1] == 1){
          count++;  
        }
        if(i > 0 && j < board[0].length -1 && board[i-1][j+1] == 1){
          count++;  
        }
        if(i < board.length -1 && board[i+1][j] == 1){
          count++;  
        }
        if(i < board.length-1 && j > 0 && board[i+1][j - 1] == 1){
          count++;  
        }
        if(i < board.length -1 && j < board[0].length -1  && board[i+1][j+1] == 1){
          count++;  
        }
        if(j < board[0].length -1 && board[i][j+1] == 1){
          count++;  
        }
        if(j > 0 && board[i][j-1] == 1){
          count++;  
        }
        
        if(count < 2){
            newg[i][j] = 0;
        }else if(count > 3){
            newg[i][j] = 0;
        }else{
            newg[i][j] = 1;
        }
    }
    
    private void checkZero(int[][] board , int[][] newg , int i , int j){
        int count = 0;
        
        if(i > 0 && board[i-1][j] == 1){
          count++;  
        }
        if(i > 0 && j > 0 && board[i-1][j-1] == 1){
          count++;  
        }
        if(i > 0 && j < board[0].length -1 && board[i-1][j+1] == 1){
          count++;  
        }
        if(i < board.length -1 && board[i+1][j] == 1){
          count++;  
        }
        if(i < board.length-1 && j > 0 && board[i+1][j - 1] == 1){
          count++;  
        }
        if(i < board.length -1 && j < board[0].length -1  && board[i+1][j+1] == 1){
          count++;  
        }
        if(j < board[0].length -1 && board[i][j+1] == 1){
          count++;  
        }
        if(j > 0 && board[i][j-1] == 1){
          count++;  
        }
        
        if(count == 3){
            newg[i][j] = 1;
        }else {
            newg[i][j] = 0;
        }
    }
}