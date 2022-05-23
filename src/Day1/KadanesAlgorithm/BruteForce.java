package Day1.KadanesAlgorithm;
import java.util.Scanner;
/*
Input:
9
2 1 -3 4 -1 2 1 -5 4

Maximum sub-array sum: 6

Time complexity: O(n^3) : Making use of 3 for loops.
Space complexity: O(1) : Not using extra space.
 */
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Maximum sub-array sum: "+kadanesAlgorithm(arr, n));
    }

    private static int kadanesAlgorithm(int [] arr, int n){
        if(arr.length==1){
            return arr[0];
        }

        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum = 0;
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                }
                if(sum > maxSum){
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }
}
