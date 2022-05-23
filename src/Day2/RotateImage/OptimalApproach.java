package Day2.RotateImage;
import java.util.Scanner;
import static Day2.RotateImage.BruteForce.printMatrix;
/*
Input:
3
1 2 3
4 5 6
7 8 9

Before:
1 2 3
4 5 6
7 8 9

Image after rotation:
7 4 1
8 5 2
9 6 3

Time complexity: 2 * O(n*n)
- Transpose of matrix : O(n*n)
- Reverse matrix : O(n*n)

Space complexity: O(1) : Not using any extra space
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
        printMatrix(matrix, n);
        rotateMatrix(matrix, n);
        System.out.println("Image after rotation: ");
        printMatrix(matrix, n);
    }

    private static void rotateMatrix(int [][] matrix, int n){
        transposeMatrix(matrix, n);
        reverseMatrix(matrix, n);
    }

    private static void transposeMatrix(int [][] matrix, int n){
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private static void reverseMatrix(int [][] matrix, int n){
        for(int i=0;i<n;i++){
            int low = 0;
            int high = n-1;

            while(low<high){
                int temp = matrix[i][low];
                matrix[i][low] = matrix[i][high];
                matrix[i][high] = temp;
                low++;
                high--;
            }
        }
    }
}
