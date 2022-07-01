package Day9.SubsetSum;

import java.util.ArrayList;
import java.util.Scanner;
/*
Input:
Enter number of elements:
3
Enter elements:
5 2 1
Output:
Subset sums:
8 7 6 5 3 2 1 0

Input:
Enter number of elements:
2
Enter elements:
2 3
Output:
Subset sums:
5 2 3 0

Time complexity: O(2^n) - For recursive approach
Space complexity: O(2^n) - Recursive stack space
 */
public class OptimalApproach {
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
        ArrayList<Integer> sums = getSubsetSums(nums, n, 0, 0, new ArrayList<Integer>());
        for(int sum: sums){
            System.out.print(sum+" ");
        }
    }

    private static ArrayList<Integer> getSubsetSums(int [] nums, int n, int index, int sum, ArrayList<Integer> sums){
        if(index==n){
            sums.add(sum);
            return sums;
        }

        //Include
        getSubsetSums(nums, n, index+1, sum+nums[index], sums);
        //Exclude
        getSubsetSums(nums, n, index+1, sum+0, sums);
        return sums;
    }
}
