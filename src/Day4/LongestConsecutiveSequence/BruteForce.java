package Day4.LongestConsecutiveSequence;

import java.util.Arrays;
import java.util.Scanner;
/*
Input:
6
100 4 200 1 3 2

Output:
Count of longest consecutive sequence: 4

Input:
5
5 4 3 2 1

Output:
Count of longest consecutive sequence: 5

Time complexity: O(nlogn) + O(n)
O(nlogn) : For sorting the array
O(n) : Traverse through the array to find out longest consecutive sequence
Space complexity: O(n) : Since in merge sort we just temp array (Not necessary to tell in the interview).

 */
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Count of longest consecutive sequence: "+getConsecutiveSequence(nums, n));
    }

    private static int getConsecutiveSequence(int [] nums, int n){
        int longestConsecutiveSequence = 0;

        Arrays.sort(nums);
        int count = 1;
        for(int i=0;i<n;i++){
            if(i>0 && nums[i-1]+1==nums[i]){
                count++;
            }
            else{
                count = 1;
            }
            longestConsecutiveSequence = Math.max(count, longestConsecutiveSequence);
        }

        return longestConsecutiveSequence;
    }
}
