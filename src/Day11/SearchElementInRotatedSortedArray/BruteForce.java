package Day11.SearchElementInRotatedSortedArray;

import java.util.Scanner;
/*
Enter number of elements: 7
Enter elements of an array rotated in some pivot point:
4 5 6 7 0 1 2
Enter the target that need to be searched:
0
The index of the target element: 4

Time complexity : O(n) - Using linear search to find the index of the target element
Space complexity: O(1) - Not using any extra space
 */
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int [] nums = new int[n];
        System.out.println("Enter elements of an array rotated in some pivot point: ");
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter the target that need to be searched: ");
        int target = sc.nextInt();
        System.out.println("The index of the target element: "+searchElementInRotatedArray(nums, n, target));
    }

    private static int searchElementInRotatedArray(int [] nums, int n, int target){
        int index = -1;
        for(int i=0;i<n;i++){
            if(nums[i]==target){
                index = i;
                break;
            }
        }
        return index;
    }
}
