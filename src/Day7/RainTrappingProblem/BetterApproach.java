package Day7.RainTrappingProblem;

import java.util.Scanner;

/*
Enter number of heights:
12
Enter heights:
0 1 0 2 1 0 1 3 2 1 2 1
The units of water that can be trapped after raining: 6

Time complexity: O(n) + O(n) + O(n)
O(n) - To calculate prefixMax
O(n) - To calculate suffixMax
O(n) - For traversing each index to find ot how many units of water it can store.

Space complexity: O(n) + O(n)
O(n) - prefixMax
O(n) - suffixMax
 */
public class BetterApproach {
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
        int [] prefixMax = calculateLeftMax(heights, n);
        int [] suffixMax = calculateRightMax(heights, n);

        for(int i=0;i<n;i++){
            totalUnits += Math.min(prefixMax[i], suffixMax[i]) - heights[i];
        }

        return totalUnits;
    }

    private static int[] calculateLeftMax(int [] heights, int n){
        int [] prefixMax = new int[n];
        int leftMax = 0;
        for(int i=0;i<n;i++){
            if(heights[i]>=leftMax){
                leftMax = heights[i];
            }
            prefixMax[i] = leftMax;
        }
        return prefixMax;
    }

    private static int[] calculateRightMax(int [] heights, int n){
        int [] suffixMax = new int[n];
        int rightMax = 0;
        for(int i=n-1;i>=0;i--){
            if(heights[i]>=rightMax){
                rightMax = heights[i];
            }
            suffixMax[i] = rightMax;
        }
        return suffixMax;
    }
}
