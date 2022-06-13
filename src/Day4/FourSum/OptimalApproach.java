package Day4.FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
Return all unique quadruplets

Input:
6
1 0 -1 0 -2 2
Target: 0

Output:
Quadruplets:
[-2, -1, 1, 2]
[-2, 0, 0, 2]
[-1, 0, 0, 1]

Time complexity: O(nlogn) + O(n^3)
O(nlogn) : For sorting.
O(n^3): 2 for loops with two pointers approach.

Space complexity: O(1): Not using extra space.
 */
public class OptimalApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        ArrayList<ArrayList<Integer>> quads = getQuadruplets(nums, n, target);

        System.out.println("Quadruplets: ");
        for(ArrayList<Integer> quad: quads){
            System.out.println("["+quad.get(0)+", "+quad.get(1)+", "+quad.get(2)+", "+quad.get(3)+"]");
        }
    }

    private static ArrayList<ArrayList<Integer>> getQuadruplets(int [] nums, int n, int target) {
        ArrayList<ArrayList<Integer>> quads = new ArrayList<>();

        Arrays.sort(nums);

        for (int i=0; i<n;i++) {
            if(i!=0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n;j++) {
                if (j!=i+1 && nums[j]==nums[j-1]) continue;
                int twoSum = target - (nums[i] + nums[j]);
                int left = j+1;
                int right = n-1;

                while(left<right){
                    if(nums[left] + nums[right] == twoSum){
                        ArrayList<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[left]);
                        quad.add(nums[right]);
                        quads.add(quad);
                        left++;
                        right--;

                        while(left<right && nums[left]==nums[left-1]){
                            left++;
                        }
                        while(left<right && nums[right]==nums[right+1]){
                            right--;
                        }
                    }
                    else if(nums[left]+nums[right] < twoSum){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
        }
        return quads;
    }
}
