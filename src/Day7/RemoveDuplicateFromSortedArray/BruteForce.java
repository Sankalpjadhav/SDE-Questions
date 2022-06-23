package Day7.RemoveDuplicateFromSortedArray;

import java.util.Scanner;
import java.util.TreeSet;
/*
Input:
Enter number of elements:
7
Enter elements of array:
1 1 2 2 2 3 3
Output:
Array after remaining duplicate elements:
1 2 3

Input:
Enter number of elements:
3
Enter elements of array:
1 1 2
Output:
Array after remaining duplicate elements:
1 2

Time complexity: O(nlogn) + O(n)
O(nlogn) - for traversing entire array to add elements into TreeSet(O(n)). Also, adding operation in TreeSet takes O(logn) time
O(n) - To add again elements in array from TreeSet.
Space complexity: O(n) - Making use of TreeSet to store elements.
 */
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        int [] nums = new int[n];
        System.out.println("Enter elements of array: ");
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int kElements = removeDuplicates(nums, n);
        System.out.println("Array after remaining duplicate elements: ");
        for(int i=0;i<kElements;i++){
            System.out.print(nums[i]+" ");
        }
    }

    private static int removeDuplicates(int [] nums, int n){
        TreeSet<Integer> set = new TreeSet<>();
        int numberOfDistinctElements = 0;

        for(Integer element: nums){
            set.add(element);
        }
        numberOfDistinctElements = set.size();
        int i = 0;
        for(Integer element : set){
            nums[i++] = element;
        }
        return numberOfDistinctElements;
    }
}
