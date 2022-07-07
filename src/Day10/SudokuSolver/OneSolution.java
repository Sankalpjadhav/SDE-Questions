package Day10.SudokuSolver;
/*
Time Complexity: O(9(n ^ 2)), in the worst case, for each cell in the n2 board, we have 9 possible numbers.

Space Complexity: O(1), since we are refilling the given board itself, there is no extra space required, so constant space complexity.
 */
public class OneSolution {

    public static void main(String[] args) {
        char[][] board = {
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };
        solveSudoku(board);
        System.out.println("Sudoku solved...");
        for(int i=0;i<board.length;i++){
            System.out.println(board[i]);
        }
    }

    private static void solveSudoku(char[][]board){
        solve(board);
    }

    private static boolean solve(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    for(char ch='1';ch<='9';ch++){
                        if(isValidToAdd(ch, board, i, j)){
                            board[i][j] = ch;
                            if(solve(board)==true){
                                return true;
                            }
                            else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidToAdd(char ch, char[][]board, int row, int col){
        for(int i=0;i<9;i++){
            // check row
            if(board[row][i] == ch){
                return false;
            }

            // check col
            if(board[i][col] == ch){
                return false;
            }

            // Check 3*3 block
            if(board[3*(row/3)+(i/3)][3*(col/3)+(i%3)] == ch){
                return false;
            }
        }
        return true;
    }
}
