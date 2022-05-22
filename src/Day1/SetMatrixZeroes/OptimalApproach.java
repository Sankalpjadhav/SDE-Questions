package Day1.SetMatrixZeroes;
import java.util.Scanner;
import static Day1.SetMatrixZeroes.BruteForce.printMatrix;
/*
Input:
4
4
1 1 1 1
1 0 1 1
1 1 0 1
0 0 0 1

Before:
1 1 1 1
1 0 1 1
1 1 0 1
0 0 0 1

Matrix after setting Zero:
0 0 0 1
0 0 0 0
0 0 0 0
0 0 0 0

Time complexity = O(n*m) + O(n*m) -> Traversing matrix twice
Space complexity = O(1) -> Not using any extra space
 */
public class OptimalApproach {
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
        boolean col0 = false;

        for(int i=0;i<n;i++){
            if(matrix[i][0]==0) col0 = true;
            for(int j=1;j<m;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = -1;
                }
            }
        }

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=1;j--){
                if(matrix[i][0]==-1 || matrix[0][j]==-1){
                    matrix[i][j] = 0;
                }
            }
            if(col0==true) matrix[i][0] = 0;
        }
    }
}
