package Day10.RatInMaze;

import java.util.ArrayList;
import java.util.Scanner;

/*
Maze has 0's and 1's
0 - Blockage
1 - No Blockage

Input:
Enter the size of the maze:
4
Enter obstructions as 0 and path as 1:
1 0 0 0
1 1 0 1
1 1 0 0
0 1 1 1

Output:
Possible paths:
DDRDRR
DRDDRR

Time complexity: 4^(n*n) : since we have 4 options(D,L,R,U) on each cell of n*n maze
Space complexity: O(n*n) + max Auxillary space of recursion tree i.e O(n*n)
O(n*n) - Visited matrix
 */
public class OneSolution {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter the size of the maze:");
        int n = sc.nextInt();
        int [][] maze = new int[n][n];
        System.out.println("Enter obstructions as 0 and path as 1:");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                maze[i][j] = sc.nextInt();
            }
        }
        ArrayList<String> paths = new ArrayList<>();
        if(maze[0][0]==0){
            return;
        }
        boolean [][] visited = new boolean[n][n];
        findPaths(0, 0, n-1, n-1, maze, paths, "", visited);
        System.out.println("Possible paths: ");
        for(String path: paths){
            System.out.println(path);
        }
    }

    private static void findPaths(int srcRow, int srcCol, int destRow, int destCol, int [][] maze, ArrayList<String> paths, String path, boolean[][] visited){
        if(srcRow==destRow && srcCol==destCol){
            paths.add(path);
            return;
        }
        // Down
        if(srcRow+1<=destRow && !visited[srcRow+1][srcCol] && maze[srcRow+1][srcCol] == 1){
            visited[srcRow+1][srcCol] = true;
            findPaths(srcRow+1, srcCol, destRow, destCol, maze, paths, path+"D", visited);
            visited[srcRow+1][srcCol] = false;
        }
        // Left
        if(srcCol-1>=0 && !visited[srcRow][srcCol-1] && maze[srcRow][srcCol-1] == 1){
            visited[srcRow][srcCol-1] = true;
            findPaths(srcRow, srcCol-1, destRow, destCol, maze, paths, path+"L", visited);
            visited[srcRow][srcCol-1] = false;
        }
        // Right
        if(srcCol+1<=destCol && !visited[srcRow][srcCol+1] && maze[srcRow][srcCol+1] == 1){
            visited[srcRow][srcCol+1] = true;
            findPaths(srcRow, srcCol+1, destRow, destCol, maze, paths, path+"R", visited);
            visited[srcRow][srcCol+1] = false;
        }
        // Up
        if(srcRow-1>=0 && !visited[srcRow-1][srcCol] && maze[srcRow-1][srcCol] == 1){
            visited[srcRow-1][srcCol] = true;
            findPaths(srcRow-1, srcCol, destRow, destCol, maze, paths, path+"U", visited);
            visited[srcRow-1][srcCol] = false;
        }
    }
}
