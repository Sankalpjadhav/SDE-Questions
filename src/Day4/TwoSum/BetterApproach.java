package Day4.TwoSum;

import java.util.HashMap;
import java.util.Scanner;

/*
Each input would have exactly one solution.

Note: We need to return indices not actual numbers that add up to a given target.

Input:
4
7 2 15 11
9

Output: [0, 1]

Time complexity: O(n) i.e We are only traversing array elements once.
Space complexity: O(1) : Making use of hashmap to store element and its index.
*/
public class BetterApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];

        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        Pair result = getIndices(nums, n, target);

        System.out.println("["+ result.indexone+", "+ result.indexTwo+"]");
    }

    private static Pair getIndices(int [] nums, int n, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        Pair indices = new Pair(-1, -1);

        for(int i=0;i<n;i++){
            int remainingTarget = target - nums[i];
            if(map.containsKey(remainingTarget)){
                indices.indexone = i;
                indices.indexTwo = map.get(remainingTarget);
                break;
            }
            map.put(nums[i], i);
        }

        return indices;
    }
}
