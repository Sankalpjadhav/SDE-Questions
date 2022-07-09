package Day11.MedianOfTwoSortedArrays;

import java.util.ArrayList;
import java.util.Scanner;
/*
Input:
Enter number of elements of arr1 and arr2:
2 1
Enter elements of arr1 in sorted order:
1 3
Enter elements of arr2 in sorted order:
2
Output:
Median of two sorted arrays: 2.0

Input:
Enter number of elements of arr1 and arr2:
6 4
Enter elements of arr1 in sorted order:
1 3 4 7 10 12
Enter elements of arr2 in sorted order:
2 3 6 15
Output:
Median of two sorted arrays: 5.0

Input:
Enter number of elements of arr1 and arr2:
3 2
Enter elements of arr1 in sorted order:
1 3 5
Enter elements of arr2 in sorted order:
2 7
Output:
Median of two sorted arrays: 3.0

Time complexity: O(n1+n2) - Adding all elements from arr1 and arr2 into arraylist by merging in sorted order
Space complexity: O(n1+n2) - Making use of arraylist to store n1+n2 elements
 */
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements of arr1 and arr2: ");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int [] arr1 = new int[n1];
        int [] arr2 = new int[n2];
        System.out.println("Enter elements of arr1 in sorted order: ");
        for(int i=0;i<n1;i++){
            arr1[i] = sc.nextInt();
        }
        System.out.println("Enter elements of arr2 in sorted order: ");
        for(int i=0;i<n2;i++){
            arr2[i] = sc.nextInt();
        }
        System.out.println("Median of two sorted arrays: "+findMedianOfTwoSortedArrays(arr1, arr2, n1, n2));
    }

    private static double findMedianOfTwoSortedArrays(int [] arr1, int [] arr2, int n1, int n2){
        ArrayList<Integer> mergedArray = new ArrayList<>();
        int ptr1 = 0;
        int ptr2 = 0;

        while(ptr1<n1 && ptr2<n2){
            if(arr1[ptr1]<=arr2[ptr2]){
                mergedArray.add(arr1[ptr1]);
                ptr1++;
            }
            else{
                mergedArray.add(arr2[ptr2]);
                ptr2++;
            }
        }
        while(ptr1<n1){
            mergedArray.add(arr1[ptr1]);
            ptr1++;
        }
        while(ptr2<n2){
            mergedArray.add(arr2[ptr2]);
            ptr2++;
        }
        if((n1+n2)%2==0){
            // Even
            int index = (n1+n2)/2 - 1;
            int elem1 = mergedArray.get(index);
            int elem2 = mergedArray.get(index+1);
            return (elem1+elem2)/2;
        }
        // Odd
        return mergedArray.get((n1+n2)/2);
    }
}
