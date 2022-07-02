package Day9.CombinationSum2;

import java.util.*;

/*
Each number in candidates can be used only once in the combination.
Also, in the question they haven't mentioned if there is duplicacy in candidates. So, we assume there is duplicacy and solve accordingly.

Input:
Enter number of candidates:
7
Enter candidates
10 1 2 7 6 1 5
Enter target value:
8
Unique combination of candidates:
[1, 2, 5] [1, 1, 6] [2, 6] [1, 7]

Time complexity: 2^n * k * logn
2^n : Number of states possible
k : This was for putting a combination into another data structure
logn : combination is added into set, it will take logn to arrange accordingly

Space complexity: O(n*k)
*/
public class BruteForce {
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
        ArrayList<ArrayList<Integer>> result = combinationSum(candidates, target);
        System.out.println("Unique combination of candidates: ");
        for(ArrayList<Integer> combination: result){
            System.out.print(combination+" ");
        }
    }

    private static ArrayList<ArrayList<Integer>> combinationSum(int [] candidates, int target){
        Set<ArrayList<Integer>> result = new HashSet<>();
        getCombinations(0, candidates, target, result, new ArrayList<Integer>());
        return new ArrayList<>(result);
    }

    private static void getCombinations(int index, int [] candidates, int target, Set<ArrayList<Integer>> result, ArrayList<Integer> combination){
        if(index == candidates.length){
            if(target == 0){
                result.add(new ArrayList<>(combination));
            }
            return;
        }

        if(candidates[index]<=target){
            combination.add(candidates[index]);
            getCombinations(index+1, candidates, target - candidates[index], result, combination);
            combination.remove(combination.size()-1);
        }
        getCombinations(index+1, candidates, target, result, combination);
    }
}
