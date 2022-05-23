package Day2.RotateImage;
import java.util.ArrayList;
import java.util.Scanner;
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
- Traverse matrix to store all elements in arraylist : O(n*n)
- Traverse matrix again in required direction to add elements from arraylist : O(n*n)

Space complexity: O(n*n) : Making use of arrayList to store all matrix elements.
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
        printMatrix(matrix, n);
        rotateMatrix(matrix, n);
        System.out.println("Image after rotation: ");
        printMatrix(matrix, n);
    }

    protected static void printMatrix(int [][] matrix, int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void rotateMatrix(int [][] matrix, int n){
        ArrayList<Integer> al = new ArrayList<Integer>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                al.add(matrix[i][j]);
            }
        }

        int i=0;

        for(int col=n-1;col>=0;col--){
            for(int row=0;row<n;row++){
                matrix[row][col] = al.get(i);
                i++;
            }
        }
    }
}
