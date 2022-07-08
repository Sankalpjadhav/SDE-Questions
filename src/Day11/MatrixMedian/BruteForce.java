package Day11.MatrixMedian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
Given a n*m matrix in which each row is sorted. Find and return the overall median of matrix

NOTE: N*M is odd and 1<=matrix[i]<=10^9

Enter dimensions of a matrix: N*M
3 3
Enter elements of a matrix:
1 3 6
2 6 9
3 6 9
Matrix median: 6

Time complexity: O(n*m) + O(n*m log n*m)
n*m - To add matrix elements into arraylist
n*m log n*m - To sort arraylist
Space complexity: O(n*m) - Making use of arraylist
 */
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter dimensions of a matrix: N*M");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] matrix = new int[n][m];
        System.out.println("Enter elements of a matrix: ");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int median = findMedian(matrix, n, m);
        System.out.println("Matrix median: "+median);
    }

    private static int findMedian(int [][] matrix, int n, int m){
        ArrayList<Integer> matrixElements = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrixElements.add(matrix[i][j]);
            }
        }
        Collections.sort(matrixElements);
        return matrixElements.get(n*m/2);
    }
}
