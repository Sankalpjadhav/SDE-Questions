package Day4.SubarrayWithGivenXOR;

import java.util.Scanner;
/*
Count number of subarrays having XOR of their elements as m

Input:
5
4 2 2 6 4
m = 6

Output:
Count of subarrays with given XOR: 4

Time complexity: O(n^3) : Using 3 nested for loops to generate all the subarrays and then calculation XOR.
Space complexity: O(1) : Not using extra space.
 */
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        System.out.println("Count of subarrays with given XOR: "+getCountOfSubarraysWithGivenXOR(nums, n, m));
    }

    private static int getCountOfSubarraysWithGivenXOR(int [] nums, int n, int m){
        int countOfSubarraysWithGivenXOR = 0;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int prefixXOR = 0;
                for(int k=i;k<=j;k++){
                    prefixXOR = prefixXOR ^ nums[k];
                }
                if(prefixXOR == m){
                    countOfSubarraysWithGivenXOR++;
                }
            }
        }

        return countOfSubarraysWithGivenXOR;
    }
}
