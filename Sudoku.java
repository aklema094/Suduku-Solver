public class Sudoku{
    public static boolean isSafe(int[][] board, int row, int col, int digit){
        for(int i =0; i<9 ;i++){
          if(board[row][i]== digit || board[i][col] == digit){
            return false;
          }
        }
        int sr = (row/3)*3;
        int sc = (col/3)*3;
         
         for(int j = sr; j<=sr+2; j++){
           for(int k = sc; k<=sc+2; k++){
             if(board[j][k] == digit){
               return false;
             }
           }
         }
       return true;
     }
   
    public static boolean helpar(int[][] board, int row, int col){
       if (row == 9) { // Base case: Successfully filled all rows
       return true;
   }
   
   
   int nRow = row;
   int nCol = col + 1;
   
   if (nCol == 9) { 
       nRow = row + 1;
       nCol = 0;
   }
   
   
       if(board[row][col] != 0){
           return helpar(board, nRow, nCol);
       }
       for(int digit = 1; digit <= 9; digit++){
           if(isSafe(board,row,col,digit)){
               board[row][col] = digit;
             if(helpar(board,nRow, nCol)){
           return true;
        }
        board[row][col] = 0;
           }
       }
     return false;
   
   }

   public static void main(String[] args) {
    int[][] board = {
        {5, 3, 0, 0, 7, 0, 0, 0, 0},
        {6, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 9, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 6, 0, 0, 0, 3},
        {4, 0, 0, 8, 0, 3, 0, 0, 1},
        {7, 0, 0, 0, 2, 0, 0, 0, 6},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };

     if(helpar(board, 0, 0)){
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
     }else{
        System.out.println("No solution exit");
     }



   }
}