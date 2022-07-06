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

Time complexity: O(n!)
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

Space complexity: O(3*(2n-1)) - Making use of 3 boolean arrays i.e columnArray, leftDiagonal and rightDiagonal
 */
public class OptimalApproach {
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
        solveNQueens(board, result);
        System.out.println("NQueens placement: ");
        for(ArrayList<String> setup : result){
            System.out.println(setup);
        }
    }

    private static void solveNQueens(char [][] board, ArrayList<ArrayList<String>> result){
        int n = board.length;
        boolean [] columnArray = new boolean[n];
        boolean [] leftDiagonal = new boolean[2*n-1];
        boolean [] rightDiagonal = new boolean[2*n-1];
        placeNQueens(0, n, board, result, columnArray, leftDiagonal, rightDiagonal);
        return;
    }

    private static void placeNQueens(int row, int n, char[][] board, ArrayList<ArrayList<String>> result, boolean [] columnArray, boolean [] leftDiagonal, boolean [] rightDiagonal){
        if(row == n){
            result.add(constructString(board));
            return;
        }
        for(int col=0;col<board[0].length;col++){
            if(!columnArray[col] && !leftDiagonal[row-col+n-1] && !rightDiagonal[row+col]){
                columnArray[col] = true;
                leftDiagonal[row-col+n-1] = true;
                rightDiagonal[row+col] = true;
                board[row][col] = 'Q';
                placeNQueens(row+1, n, board, result, columnArray, leftDiagonal, rightDiagonal);
                columnArray[col] = false;
                leftDiagonal[row-col+n-1] = false;
                rightDiagonal[row+col] = false;
                board[row][col] = '.';
            }
        }
    }

    private static ArrayList<String> constructString(char [][] board){
        ArrayList<String> result = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            result.add(new String(board[i]));
        }
        return result;
    }
}
