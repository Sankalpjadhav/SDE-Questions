package Day9.Subset2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
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

Time complexity: O(2^N) or O(2^N) + O(N)
O(N) - when interviewer asks us to convert it to ArrayList<ArrayList> instead of Set<ArrayList>

Space complexity: O(2^N) : It has 2^N subsets if there are no duplicates.
 */
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        int [] nums = new int[n];
        System.out.println("Enter elements: ");
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        Set<ArrayList<Integer>> subsets = new HashSet<ArrayList<Integer>>();
        getSubsets(0, new ArrayList<Integer>(), nums, subsets);
        System.out.println("Subsets: ");
        for(ArrayList<Integer> subset:subsets){
            System.out.print(subset);
        }
    }

    private static void getSubsets(int index, ArrayList<Integer> subset, int [] nums, Set<ArrayList<Integer>> subsets){
        if(index == nums.length){
            subsets.add(new ArrayList(subset));
            return;
        }
        subset.add(nums[index]);
        getSubsets(index + 1, subset, nums, subsets);
        subset.remove(subset.size()-1);
        // Not include
        getSubsets(index+1, subset, nums, subsets);
    }
}
