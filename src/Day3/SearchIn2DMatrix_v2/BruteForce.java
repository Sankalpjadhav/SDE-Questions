package Day3.SearchIn2DMatrix_v2;
import java.util.Scanner;
/*
Important conditions given:
- Every row is sorted in increasing order.
- The first integer of each row is greater than the last integer of the previous row.

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
        Index index = getIndex(matrix, n, target);

        if(index.row==-1 && index.col==-1){
            System.out.println("Not found");
        }
        else{
            System.out.println("Row: "+index.row+" Col: "+index.col);
        }
    }

    private static Index getIndex(int [][] matrix, int n, int target){
        Index index = new Index(-1,-1);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == target){
                    return new Index(i, j);
                }
            }
        }
        return index;
    }
}

class Index{
    int row;
    int col;
    public Index(int row, int col){
        this.row = row;
        this.col = col;
    }
}