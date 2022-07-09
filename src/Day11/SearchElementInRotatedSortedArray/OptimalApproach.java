package Day11.SearchElementInRotatedSortedArray;

import java.util.Scanner;

/*
        Enter number of elements: 7
        Enter elements of an array rotated in some pivot point:
        4 5 6 7 0 1 2
        Enter the target that need to be searched:
        0
        The index of the target element: 4

        Time complexity : O(logn) - Using binary search
        Space complexity: O(1) - Not using any extra space
*/
public class OptimalApproach {
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
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                index = mid;
                break;
            }
            // Now find out which half is sorted
            if(nums[low]<=nums[mid]){
                // Left half is sorted
                if(target>=nums[low] && target<=nums[mid]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{
                // Right half is sorted
                if(target>=nums[mid] && target<=nums[high]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return index;
    }
}
