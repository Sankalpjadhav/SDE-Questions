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

Time complexity: O(nlogn) + O(n^3 * logn)
O(nlogn) : For sorting.
O(n^3 * logn): 3 for loops with binary search.

Space complexity: O(1): Not using extra space.
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

        ArrayList<Quadruples> quads = getQuadruplets(nums, n, target);

        System.out.println("Quadruplets: ");
        for(Quadruples quad: quads){
            System.out.println("["+quad.numOne+", "+quad.numTwo+", "+quad.numThree+", "+quad.numFour+"]");
        }
    }

    private static ArrayList<Quadruples> getQuadruplets(int [] nums, int n, int target){
        ArrayList<Quadruples> quads = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n;j++){
                if(j!=i+1 && nums[j]==nums[j-1]) continue;
                for(int k=j+1;k<n;k++){
                    if(k!=j+1 && nums[k]==nums[k-1]) continue;
                    int remainingTarget = target - (nums[i]+nums[j]+nums[k]);
                    // Apply binary search
                    int left = k+1;
                    int right = n-1;

                    while(left <= right){
                        int mid = (left+right)/2;
                        if(nums[mid] == remainingTarget){
                            quads.add(new Quadruples(nums[i], nums[j], nums[k], nums[mid]));
                            break;
                        }
                        else if(nums[mid] < remainingTarget){
                            left = mid+1;
                        }
                        else{
                            right = mid-1;
                        }
                    }
                }
            }
        }

        return quads;
    }
}

class Quadruples{
    int numOne;
    int numTwo;
    int numThree;
    int numFour;

    public Quadruples(int numOne, int numTwo, int numThree, int numFour){
        this.numOne = numOne;
        this.numTwo = numTwo;
        this.numThree = numThree;
        this.numFour = numFour;
    }
}