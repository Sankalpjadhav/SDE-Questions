package Day1.SetMatrixZeroes;
import java.util.Scanner;
import static Day1.SetMatrixZeroes.BruteForce.printMatrix;
/*
Input:
3
4
0 1 2 0
3 4 5 2
1 3 1 5

Matrix Before:
0 1 2 0
3 4 5 2
1 3 1 5

Matrix after setting Zero:
0 0 0 0
0 4 5 0
0 3 1 0

Time complexity: O(n*m) + O(n*m) -> Traversing matrix 2 times
Space complexity : O(n) + O(m) -> Making use of row and col array
 */

public class BetterApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] matrix = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        printMatrix(matrix, n, m);
        setMatrixZeroes(matrix, n, m);
        System.out.println("Matrix after setting Zero: ");
        printMatrix(matrix, n, m);
    }

    private static void setMatrixZeroes(int [][] matrix, int n, int m){
        int [] row = new int[n];
        int [] col = new int[m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    row[i] = col[j] = -1;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(row[i]==-1 || col[j]==-1){
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
