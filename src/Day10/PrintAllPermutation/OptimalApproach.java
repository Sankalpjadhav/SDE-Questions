package Day10.PrintAllPermutation;

import java.util.ArrayList;
import java.util.Scanner;
/*
Input:
Enter number of elements:
3
Enter elements:
1 2 3
All permutations of a given array:
[1, 2, 3] [1, 3, 2] [2, 1, 3] [2, 3, 1] [3, 1, 2] [3, 2, 1]

Time complexity: O(n! * n)
n! permutations/states we will be generating
n - For trying out all the options

Space complexity: O(1)
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
        System.out.println("All permutations of a given array: ");
        ArrayList<ArrayList<Integer>> result = getPermutations(nums, n);
        for(ArrayList<Integer> permutation: result){
            System.out.print(permutation+" ");
        }
    }

    private static ArrayList<ArrayList<Integer>> getPermutations(int [] nums, int n){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        getAllPermutationsOfGivenArray(0, nums, result);
        return result;
    }

    private static void getAllPermutationsOfGivenArray(int index, int [] nums, ArrayList<ArrayList<Integer>> result){
        if(index == nums.length){
            ArrayList<Integer> permutation = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                permutation.add(nums[i]);
            }
            result.add(new ArrayList<>(permutation));
            return;
        }

        for(int i=index;i<nums.length;i++){
            swap(i, index, nums);
            getAllPermutationsOfGivenArray(index+1, nums, result);
            swap(i, index, nums);
        }
    }

    private static void swap(int i, int j, int [] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
