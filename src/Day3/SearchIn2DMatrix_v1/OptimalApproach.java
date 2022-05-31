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

Target: 35

Output: Row: 1 Col: 2

Input:
4
10 20 30 40
15 25 35 45
27 29 37 48
32 33 39 50

Target: 28

Output: Not found

Time complexity: O(n) Slightly greater than O(n)
Space complexity: O(1) Not using extra space
 */

public class OptimalApproach {
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

    private static Pair getIndex(int[][] matrix, int n, int target){
        Pair index = new Pair(-1, -1);
        int i = 0, j = n-1;
        while((i<n) && (j>=0)){
            if(matrix[i][j] == target){
                return new Pair(i, j);
            }
            else if(matrix[i][j] < target){
                i++;
            }
            else{ // matrix[i][j] > target
                j--;
            }
        }
        return index;
    }
}
