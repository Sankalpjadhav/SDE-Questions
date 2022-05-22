package Day1.SetMatrixZeroes;

import java.util.Scanner;
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
 */
public class BruteForce {
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

    protected static void printMatrix(int [][] matrix, int n, int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void setMatrixZeroes(int [][] matrix, int n, int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    // Set entire row to some negative number
                    for(int k=0;k<m;k++){
                        if(matrix[i][k]!=0) {
                            matrix[i][k] = -1;
                        }
                    }
                    // Set entire col to some negative number
                    for(int l=0;l<n;l++){
                        if(matrix[l][j]!=0) {
                            matrix[l][j] = -1;
                        }
                    }
                }
            }
        }
        // Traverse matrix again and change values from -1 to 0
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
