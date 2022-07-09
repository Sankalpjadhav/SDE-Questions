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

Why we are assigning high as n-2 bcoz to take care of condition when the element that appears once is positioned at the end of the array.

Time complexity: O(logn) - We are applying binary search.
Space complexity: O(1) - Not using extra space.
 */
public class OptimalApproach {
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
        if(n == 1){
            return nums[0];
        }
        int low = 0;
        int high = n-2;

        while(low <= high){
            int mid = (low+high)/2;
            if(mid % 2 == 0){
                if(nums[mid] == nums[mid+1]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
            else{
                if(nums[mid] == nums[mid-1]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return nums[low];
    }
}
