package Day10.NQueens;

import java.util.ArrayList;
import java.util.Scanner;
/*
Input:
Enter number of Queens:
4
Output:
NQueens placement:
[.Q.., ...Q, Q..., ..Q.]
[..Q., Q..., ...Q, .Q..]

Time complexity: O(n! * 3n)
n! - Let us consider our queen is a "rook", meaning we need not take care of diagonal constraints.
Let us take an example where N=4, supposed we want to fill 2D matrix, x represents vacant position while | represent taken position.

At start, we have:
x x x x
x x x x
x x x x
x x x x

Lets start filling row-wise meaning will select one location in each row then move forward to the next row.
For the first row, since none of them are filled, we have 4 options. For the second, we have 3 options as one
of the col will be filled by 0th row. Similarly, for the third row, we have 2 options, and for the  last row,
we are left with just 1 option.

Therefore, Total options = 4*3*2*1 = 24 (4!)
Now, this was the case when our queen was a rook. Since we have more constraints in case of a queen.
Complexity  should be less than O(n!) in terms of actual number of operations.

3n - Everytime we are checking for left diagonal, right diagonal and column just above the current queen placement.

Space complexity: O(1) - Not using any extra space. Recursion Stack space will be there O(n).
 */
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Queens:");
        int nQueens = sc.nextInt();
        char [][] board = new char[nQueens][nQueens];
        for(int i=0;i<nQueens;i++){
            for(int j=0;j<nQueens;j++){
                board[i][j] = '.';
            }
        }
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        solveNQueens(0, board, result);
        System.out.println("NQueens placement: ");
        for(ArrayList<String> setup : result){
            System.out.println(setup);
        }
    }

    private static void solveNQueens(int row, char [][] board, ArrayList<ArrayList<String>> result){
        if(row== board.length){
            result.add(constructString(board));
            return;
        }

        for(int col=0;col<board.length;col++){
            if(isSafeToPlace(row, col, board)){
                board[row][col] = 'Q';
                solveNQueens(row+1, board, result);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafeToPlace(int row, int col, char [][] board){
        int r = row;
        int c = col;
        // Checking column
        while(r>=0){
            if(board[r][c]=='Q'){
                return false;
            }
            r--;
        }

        r = row;
        c = col;
        // Checking left diagonal
        while(r>=0 && c>=0){
            if(board[r][c]=='Q'){
                return false;
            }
            r--;
            c--;
        }

        r = row;
        c = col;
        // Checking right diagonal
        while(r>=0 && c<=board[0].length-1){
            if(board[r][c]=='Q'){
                return false;
            }
            r--;
            c++;
        }

        return true;
    }

    private static ArrayList<String> constructString(char [][] board){
        ArrayList<String> result = new ArrayList<>();
        for(int row=0;row<board.length;row++){
            result.add(new String(board[row]));
        }
        return result;
    }
}
