package Day3.GridUniquePaths;

import java.util.Arrays;
import java.util.Scanner;
/*
A robot is located at the top-left corner of a M*N grid. The Robot can only move either down or right.
The robot is trying to reach bottom-right corner of the grid.

Input:
3
2

Output:
Possible unique paths: 3

Input:
3
3

Output:
Possible unique paths: 6

Time complexity: O(m*n) Memoization: Apart from m*n states there wont be any further recursive calls
Space complexity: O(m*n) use of Memoization hash table + O(m*n) stack space for recursion
 */
public class BetterApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int [][] grid = new int[m][n];
        int [][] memoize = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(memoize[i], -1);
        }
        System.out.println("Possible unique paths: "+getCountOfUniquePaths(grid, 0,0, m-1, n-1, memoize));
    }

    private static int getCountOfUniquePaths(int [][] grid, int i, int j, int m, int n, int [][] memoize){
        if(i>m || j>n){
            return 0;
        }
        if(i==m && j==n){
            return 1;
        }
        if(memoize[i][j]!=-1){
            return memoize[i][j];
        }

        return memoize[i][j] = getCountOfUniquePaths(grid, i+1, j, m, n, memoize) + getCountOfUniquePaths(grid, i, j+1, m, n, memoize);
    }
}
