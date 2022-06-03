package Day3.GridUniquePaths;

import java.util.Scanner;
/*
A robot is located at the top-left corner of a M*N grid. The Robot can only move either down or right.
The robot is trying to reach bottom-right corner of the grid.

Input:
3
2

Output:
Possible unique paths: 3

Time complexity: 2^n i.e Exponential in nature (Recursion)
Space complexity: Exponential because we will be using stack space in recursion
 */
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int [][] grid = new int[m][n];
        System.out.println("Possible unique paths: "+getCountOfUniquePaths(grid, 0,0, m-1, n-1));
    }

    private static int getCountOfUniquePaths(int [][] grid, int i, int j, int m, int n){
        if(i>m || j>n){
            return 0;
        }

        if(i==m && j==n){
            return 1;
        }

        return getCountOfUniquePaths(grid, i+1, j, m, n) + getCountOfUniquePaths(grid, i, j+1, m, n);
    }
}
