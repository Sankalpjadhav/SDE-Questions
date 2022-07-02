package Day9.Subset2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/*
Nums array may contain duplicate.
NOTE: Solution must not have duplicates.
Input:
Enter number of elements:
1
Enter elements:
0
Subsets:
[][0]

Input:
Enter number of elements:
3
Enter elements:
1 2 2
Subsets:
[1, 2, 2][1][2, 2][2][][1, 2]

Time complexity: Overall O(k * 2^n)
O(2^n) for generating every subset and O(k)  to insert every subset in another data structure if the average length of every subset is k.

Space complexity: O(2^N * k) : to store every subset of average length k. Auxiliary space is O(n)  if n is the depth of the recursion tree.
 */
public class OptimalApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        int [] nums = new int[n];
        System.out.println("Enter elements: ");
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        getSubsets(0, new ArrayList<Integer>(), nums, subsets);
        System.out.println("Subsets: ");
        for(ArrayList<Integer> subset:subsets){
            System.out.print(subset);
        }
    }

    private static void getSubsets(int index, ArrayList<Integer> subset, int [] nums, ArrayList<ArrayList<Integer>> subsets){
        subsets.add(new ArrayList<>(subset));

        for(int i=index;i<nums.length;i++){
            if(i!=index && nums[i]==nums[i-1]) continue;
            subset.add(nums[i]);
            getSubsets(i+1, subset, nums, subsets);
            subset.remove(subset.size()-1);
        }
    }
}
