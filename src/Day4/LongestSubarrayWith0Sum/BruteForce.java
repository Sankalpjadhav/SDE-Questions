package Day4.LongestSubarrayWith0Sum;

import java.util.Scanner;
/*
Find longest/largest subarray with 0 sum.

Input:
8
15 -2 2 -8 1 7 10 23
   -----------
Output:
Count of longest subarray with 0 sum: 5

Input:
10
1 -1 3 2 -2 -8 1 7 -3 23
---------------------
Output:
Count of longest subarray with 0 sum: 9

Time complexity: O(n^3) : 3 Nested for loops
Space complexity: O(1) : Not using extra space

 */
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Count of longest subarray with 0 sum: "+getCountOfLongestSubarrayWithZeroSum(nums, n));
    }

    private static int getCountOfLongestSubarrayWithZeroSum(int [] nums, int n){
        int countOfLongestSubarray = 1;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int sum = 0;
                for(int k=i;k<=j;k++){
                    sum += nums[k];
                }
                if(sum == 0){
                    countOfLongestSubarray = Math.max(countOfLongestSubarray, j-i+1);
                }
            }
        }

        return countOfLongestSubarray;
    }
}
