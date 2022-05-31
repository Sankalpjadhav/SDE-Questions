package Day3.SearchIn2DMatrix_v2;
import java.util.Scanner;

/*
Important conditions given:
- Every row is sorted in increasing order.
- The first integer of each row is greater than the last integer of the previous row.

Input:
4
10 20 30 40
15 25 35 45
27 29 37 48
32 33 39 50

Target: 39

Output: Row: 3 Col: 2

Input:
4
10 20 30 40
15 25 35 45
27 29 37 48
32 33 39 50

Target: 28

Output: Not found

Time complexity: O(n * logn) Applying binary search on n rows to find target element
Space complexity: O(1) Not using extra space
 */
public class BetterApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] matrix = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        int target = sc.nextInt();

        Index index = getIndex(matrix, n, target);

        if(index.row==-1 && index.col==-1){
            System.out.println("Not found");
        }
        else{
            System.out.println("Row: "+index.row+" Col: "+index.col);
        }
    }

    private static Index getIndex(int [][] matrix, int n, int target){
        Index index = new Index(-1, -1);

        for(int i=0;i<n;i++){
            int low = 0;
            int high  = matrix[0].length-1;

            while(low<=high){
                int mid = (low+high)/2;
                if(matrix[i][mid]==target){
                    return new Index(i, mid);
                }
                else if(matrix[i][mid]<target){
                    low = mid+1;
                }
                else{ // matrix[i][mid] > target
                    high = mid-1;
                }
            }
        }
        return index;
    }
}
