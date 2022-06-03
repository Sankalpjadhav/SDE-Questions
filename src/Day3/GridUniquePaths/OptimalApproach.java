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

Time complexity: O(m*n) Tabulation
Space complexity: O(m*n) use of Tabulation hash table
 */
public class OptimalApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int [][] grid = new int[m][n];
        int [][] memoize = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(memoize[i], -1);
        }
        System.out.println("Possible unique paths: "+getCountOfUniquePaths(grid, m-1, n-1, memoize));
    }

    private static int getCountOfUniquePaths(int [][] grid, int m, int n, int [][] memoize){
        int [][] dp = new int[m+1][n+1];
        for(int i=0;i<m;i++){
            dp[i][n] = 1;
        }
        for(int j=0;j<m;j++){
            dp[m][j] = 1;
        }
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }

        return dp[0][0];
    }

}
