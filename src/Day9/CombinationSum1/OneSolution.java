package Day9.CombinationSum1;

import java.util.ArrayList;
import java.util.Scanner;
/*
Given an array of distinct integer candidates and return the list of uniques combinations.

NOTE:
* Same candidate can be chosen any number of times.
* If in the question, they mentioned candidates can be duplicate instead of distinct then make use of set
i.e Set<Integer> set = new HashSet<>(candidates);
ArrayList<Integer> elements = new ArrayList<>(set);
and then use this elements instead of candidates in function.

Input:
Enter number of candidates:
3
Enter candidates
2 3 5
Enter target value:
7
Output:
Unique combination of candidates:
[2, 2, 3][2, 5]

Input:
Enter number of candidates:
3
Enter candidates
2 3 5
Enter target value:
8
Output:
Unique combination of candidates:
[2, 2, 2, 2][2, 3, 3][3, 5]

Time complexity: O(2^t) * k
O(2^t) - Just imagine you were not allowed to use same candidate multiple times then for every index we just have 2 options(pick and Non-pick), that makes time complexity 2^n
But in this case we have flexibility to use same candidate multiple times, so 2^t
k - Avg length of each and every combination generated is k to put into resultant data structure.

Space complexity: O(k*x)
k- Avg length
x- x number of combinations

 */
public class OneSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of candidates: ");
        int n = sc.nextInt();
        System.out.println("Enter candidates");
        int [] candidates = new int[n];
        for(int i=0;i<n;i++){
            candidates[i] = sc.nextInt();
        }
        System.out.println("Enter target value: ");
        int target = sc.nextInt();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        combinationSum(0, candidates, target, result, new ArrayList<Integer>());
        System.out.println("Unique combination of candidates: ");
        for(ArrayList<Integer> combination: result){
            System.out.print(combination);
        }
    }

    private static void combinationSum(int index, int [] candidates, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> combination){
        if(index == candidates.length){
            if(target == 0){
                result.add(new ArrayList<>(combination));
            }
            return;
        }

        if(candidates[index] <= target){
            combination.add(candidates[index]);
            combinationSum(index, candidates, target - candidates[index], result, combination);
            combination.remove(combination.size()-1);
        }
        combinationSum(index+1, candidates, target, result, combination);
    }
}
