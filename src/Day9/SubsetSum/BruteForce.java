package Day9.SubsetSum;

import java.util.Scanner;
/*
Input:
Enter number of elements:
3
Enter elements:
5 2 1
Output:
Subset sums:
0 5 2 7 1 6 3 8

Input:
Enter number of elements:
2
Enter elements:
2 3
Output:
Subset sums:
0 2 3 5

Time complexity: O(n * 2^n)
2^n : It will generate 2^n subsets.
n : It need to check for each bit whether that bit is set or not.

Space complexity: O(1) - Not using extra space.
 */
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter elements: ");
        int [] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Subset sums: ");
        int [] sums = getSubsetSums(nums, n);
        for(int i=0;i<sums.length;i++){
            System.out.print(sums[i]+" ");
        }
    }

    private static int [] getSubsetSums(int [] nums, int n){
        int [] sums = new int[1<<n];
        for(int num=0; num <= (1<<n)-1 ;num++){
            int sum = 0;
            for(int i=0;i<n;i++){
                if( (num & (1<<i)) != 0){
                    sum += nums[i];
                }
            }
            sums[num] = sum;
        }

        return sums;
    }
}
