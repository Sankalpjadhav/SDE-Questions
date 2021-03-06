package Day11.FindElementThatAppearsOnce;

import java.util.Scanner;
/*
You are given a sorted array consisting of only integers, where every element appears twice except one element which appears exactly once.
Input:
Enter number of elements of a sorted array:
9
Enter elements:
1 1 2 3 3 4 4 8 8
Output:
The element that appears once: 2

Input:
Enter number of elements of a sorted array:
9
Enter elements:
1 1 3 3 4 4 5 5 6
Output:
The element that appears once: 6

Time complexity: O(n)
We are using property of XOR that when we XOR two same elements, we get 0. So if we XOR all elements of sorted array then we get element which appears once.
Space complexity: O(1) - Not using extra space.
 */
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements of a sorted array: ");
        int n = sc.nextInt();
        int [] nums = new int[n];
        System.out.println("Enter elements: ");
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("The element that appears once: "+getElementThatAppearsOnce(nums, n));
    }

    private static int getElementThatAppearsOnce(int [] nums, int n){
        int result = 0;
        for(int element:nums){
            result = result ^ element;
        }
        return result;
    }
}
