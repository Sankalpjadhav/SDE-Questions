package Day9.CombinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
Each number in candidates can be used only once in the combination.
Also, in the question they haven't mentioned if there is duplicacy in candidates. So, we assume there is duplicacy and solve accordingly.

Input:
Enter number of candidates:
5
Enter candidates
2 5 2 1 2
Enter target value:
5
Unique combination of candidates:
[1, 2, 2] [5]

Time complexity: 2^n * k
2^n : Number of states possible
k : This was for putting a combination into another data structure

Space complexity: O(x*k)
x: x number of combinations
*/
public class OptimalApproach {
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
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        getCombinations(0, candidates, target, result, new ArrayList<Integer>());
        return result;
    }

    private static void getCombinations(int index, int [] candidates, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> combination){
        if(target==0){
            result.add(new ArrayList<Integer>(combination));
            return;
        }

        for(int i=index;i<candidates.length;i++){
            if(i!=index && candidates[i]==candidates[i-1]) continue;
            if(candidates[i] > target) break;

            combination.add(candidates[i]);
            getCombinations(i+1, candidates, target-candidates[i], result, combination);
            combination.remove(combination.size()-1);
        }
    }
}
