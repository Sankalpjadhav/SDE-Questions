package Day3.SearchIn2DMatrix_v2;
import java.util.Scanner;

/*
Important conditions given:
- Every row is sorted in increasing order.
- The first integer of each row is greater than the last integer of the previous row.

Input:
nRows: 3
mCold: 4

1 3 5 7
10 11 16 20
23 30 34 50

Target: 30

Output: Row: 2 Col: 1

Input:
4
4
10 20 30 40
15 25 35 45
27 29 37 48
32 33 39 50

Target: 28

Output: Not found

Time complexity: O(log n*m ) Applying binary search on whole 2D matrix at once
Space complexity: O(1) Not using extra space
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

        int target = sc.nextInt();

        Index index = getIndex(matrix, n, m, target);

        if(index.row==-1 && index.col==-1){
            System.out.println("Not found");
        }
        else{
            System.out.println("Row: "+index.row+" Col: "+index.col);
        }
    }

    private static Index getIndex(int [][] matrix, int nRows, int mCols, int target){
        Index index = new Index(-1, -1);
        int left = 0;
        int right = nRows * mCols - 1;

        while(left<=right){
            int mid = left + (right-left)/2;
            int row = mid / mCols;
            int col = mid % mCols;

            if(matrix[row][col] == target){
                return new Index(row,col);
            }
            else if(matrix[row][col] < target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return index;
    }
}
