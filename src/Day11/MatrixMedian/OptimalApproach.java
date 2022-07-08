package Day11.MatrixMedian;

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

Time complexity: O(log 1e9) * O(n * log m)
log 1e9 - applying binary search on search space
n * logm - For n rows applying binary search on m columns.
Space complexity: O(1) - Not using extra space
 */
public class OptimalApproach {
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
        int low = 1;
        int high = 15; // Set high value based on constraints.
        while(low <= high){
            int mid = (low+high)/2;
            int count = 0;
            // Find how many elements are greater than or equal to mid
            for(int i=0;i<n;i++){
                count += getCountOfElements(matrix[i], mid);
            }

            if(count <= (n*m)/2){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low;
    }

    private static int getCountOfElements(int [] row, int num){
        int low = 0;
        int high = row.length-1;
        // Here we will find out index of the element which is immediate strictly greater than given mid. Which means elements just before that index are greater than or equal to mid.
        while(low<=high){
            int mid = (low+high)/2;
            if(row[mid] <= num){
                low  = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low;
    }
}