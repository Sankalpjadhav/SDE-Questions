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
n loop

Space complexity: O(n) - visited array
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
        System.out.println("All permutations of a given array: ");
        ArrayList<ArrayList<Integer>> result = getPermutations(nums, n);
        for(ArrayList<Integer> permutation: result){
            System.out.print(permutation+" ");
        }
    }

    private static ArrayList<ArrayList<Integer>> getPermutations(int [] nums, int n){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean [] visited = new boolean[n];
        getAllPermutationsOfGivenArray(nums, result, new ArrayList<>(), visited);
        return result;
    }

    private static void getAllPermutationsOfGivenArray(int [] nums, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> permutation, boolean [] visited){
        if(permutation.size()==nums.length){
            result.add(new ArrayList<>(permutation));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                permutation.add(nums[i]);
                visited[i] = true;
                getAllPermutationsOfGivenArray(nums, result, permutation, visited);
                visited[i] = false;
                permutation.remove(permutation.size()-1);
            }
        }
    }
}
