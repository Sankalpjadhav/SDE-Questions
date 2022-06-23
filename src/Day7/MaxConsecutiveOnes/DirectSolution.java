package Day7.MaxConsecutiveOnes;

import java.util.Scanner;
/*
These kind of problems are warmup problems. Directly go ahead with optimal approach.
Input:
Enter number of elements:
6
Enter elements of array:
1 1 0 1 1 1
Output:
Maximum consecutive ones: 3

Time complexity: O(n) - We are traversing array elements only once
Space complexity: O(1) - Not using any extra space
 */
public class DirectSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        int [] nums = new int[n];
        System.out.println("Enter elements of array: ");
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int maxConsecutiveOnes = getConsecutiveOnes(nums, n);
        System.out.println("Maximum consecutive ones: "+maxConsecutiveOnes);
    }

    private static int getConsecutiveOnes(int [] nums, int n){
        int count = 0;
        int maxConsecutiveOnes = 0;
        for(int element : nums){
            if(element==1){
                count++;
                maxConsecutiveOnes = Math.max(maxConsecutiveOnes, count);
            }
            else{
                count = 0;
            }
        }
        return maxConsecutiveOnes;
    }
}
