package Day7.RainTrappingProblem;

import java.util.Scanner;
/*
Enter number of heights:
12
Enter heights:
0 1 0 2 1 0 1 3 2 1 2 1
The units of water that can be trapped after raining: 6

Time complexity: O(n^2)
O(n) - For traversing each index to find ot how many units of water it can store.
O(n) - For each index, we will traversing entire array to find out leftMax and rightMax.

Space complexity: O(1) - Not using extra space.
 */
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of heights: ");
        int n = sc.nextInt();
        int [] heights = new int[n];
        System.out.println("Enter heights: ");
        for(int i=0;i<n;i++){
            heights[i] = sc.nextInt();
        }
        System.out.println("The units of water that can be trapped after raining: "+calculateRainTrapping(heights, n));
    }

    private static int calculateRainTrapping(int [] heights, int n){
        int totalUnits = 0;

        for(int i=1;i<n-1;i++){
            int leftMax = heights[i];
            for(int j=0;j<i;j++){
                leftMax = Math.max(leftMax, heights[j]);
            }
            int rightMax = heights[i];
            for(int k=i+1;k<n-1;k++){
                rightMax = Math.max(rightMax, heights[k]);
            }
            totalUnits += Math.min(leftMax, rightMax) - heights[i];
        }

        return totalUnits;
    }
}
