package Day1.KadanesAlgorithm;
import java.util.Scanner;
/*
Input:
9
2 1 -3 4 -1 2 1 -5 4

Maximum sub-array sum: 6

Time complexity: O(n^2) : Making use of 2 for loops.
Space complexity: O(1) : Not using extra space.
 */
public class BetterApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Maximum sub-array sum: "+maxSubarray(arr, n));
    }

    private static int maxSubarray(int [] arr, int n){
        int maxSum = 0;

        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum+=arr[j];
                maxSum = Math.max(sum, maxSum);
            }
        }

        return maxSum;
    }
}
