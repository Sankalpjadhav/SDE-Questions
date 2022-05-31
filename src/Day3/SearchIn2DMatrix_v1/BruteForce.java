package Day3.SearchIn2DMatrix_v1;
import java.util.Scanner;
/*
Important condition given:
- Every row and every column is sorted in increasing order

Input:
4
10 20 30 40
15 25 35 45
27 29 37 48
32 33 39 50

Target: 29


Output: Row: 2 Col: 1


Time complexity: O(n^2) for linearly traversing 2D matrix
Space complexity: O(1) Not using extra space

 */
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] matrix = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        int target = sc.nextInt();

        Pair index = getIndex(matrix, n, target);

        if(index.row==-1 && index.col==-1){
            System.out.println("Not found");
        }
        else{
            System.out.println("Row: "+index.row+" Col: "+index.col);
        }
    }

    private static Pair getIndex(int [][] matrix, int n, int target){
        Pair index = new Pair(-1, -1);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == target){
                    return new Pair(i, j);
                }
            }
        }
        return index;
    }
}


class Pair{
    int row;
    int col;

    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}