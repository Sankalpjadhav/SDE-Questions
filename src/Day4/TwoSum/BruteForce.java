package Day4.TwoSum;

import java.util.Scanner;
/*
Each input would have exactly one solution.

Note: We need to return indices not actual numbers that add up to a given target.

Input:
4
7 2 15 11
9

Output: [0, 1]

Time complexity: O(n^2) i.e for every element we are looking for target-firstElement to the right side of the element.
Space complexity: O(1) : Not using any extra space.
 */
public class BruteForce {
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
        Pair indices = new Pair(-1, -1);

        for(int i=0;i<n;i++){
            int remainingTarget = target - nums[i];
            for(int j=i+1;j<n;j++){
                if(nums[j] == remainingTarget){
                    indices.indexone = i;
                    indices.indexTwo = j;
                    break; // As mentioned in the question that it contains exactly one solution.
                }
            }
        }

        return indices;
    }
}

class Pair{
    int indexone;
    int indexTwo;

    public Pair(int indexone, int indexTwo){
        this.indexone = indexone;
        this.indexTwo = indexTwo;
    }
}
