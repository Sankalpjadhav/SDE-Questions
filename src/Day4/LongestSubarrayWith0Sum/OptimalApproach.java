package Day4.LongestSubarrayWith0Sum;

import java.util.HashMap;
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

Time complexity: O(n * logn) : n for traversing entire array, logn for hashmap inorder to work get get operation.
Space complexity: O(n) : Using HashMap
 */
public class OptimalApproach {
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
        HashMap<Integer, Integer> map = new HashMap<>(); // <Summation, index>
        int countOfLongestSubarray = 0;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
            if(sum == 0){
                countOfLongestSubarray = i+1;
            }
            else{
                if(map.containsKey(sum)){
                    int previousIndex = map.get(sum);
                    countOfLongestSubarray = Math.max(countOfLongestSubarray, i-previousIndex);
                }
                else{
                    map.put(sum, i);
                }
            }
        }

        return countOfLongestSubarray;
    }
}
