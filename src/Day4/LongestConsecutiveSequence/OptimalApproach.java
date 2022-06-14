package Day4.LongestConsecutiveSequence;
import java.util.HashSet;
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

Time complexity: O(n) + O(n) + O(n)
O(n) : Is for adding elements into hashset
O(n) : Traverse through the array to find out longest consecutive sequence
O(n) : Traversing num+1 element in hashset if it exist
Space complexity: O(n) : Making use of HashSet to store elements.

 */
public class OptimalApproach {
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

        if(nums.length == 0){
            return 0;
        }

        HashSet<Integer> set = new HashSet<Integer>();

        for(int num: nums){
            set.add(num);
        }

        int longestConsecutiveSequence  = 1;
        for(int num: nums){
            if(!set.contains(num-1)){
                int currentNum = num;
                int count = 1;
                while(set.contains(currentNum+1)){
                    currentNum = currentNum+1;
                    count++;
                }
                longestConsecutiveSequence = Math.max(longestConsecutiveSequence, count);
            }
        }

        return longestConsecutiveSequence;
    }
}
