package Day7.RainTrappingProblem;

import java.util.Scanner;

/*
Enter number of heights:
12
Enter heights:
0 1 0 2 1 0 1 3 2 1 2 1
The units of water that can be trapped after raining: 6

Time complexity: O(n) - Traversing only once using two pointers approach
Space complexity: O(1) - Not using extra space
 */
public class OptimalApproach {
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
        int low = 0;
        int high = n-1;
        int leftMax = 0;
        int rightMax= 0;
        while(low < high){
            if(heights[low] <= heights[high])
            {
                if(heights[low] > leftMax){
                    leftMax = heights[low];
                }
                else{
                    totalUnits += leftMax - heights[low];
                }
                low++;
            }
            else{
                if(heights[high] > rightMax){
                    rightMax = heights[high];
                }
                else{
                    totalUnits += rightMax - heights[high];
                }
                high--;
            }
        }
        return totalUnits;
    }
}
