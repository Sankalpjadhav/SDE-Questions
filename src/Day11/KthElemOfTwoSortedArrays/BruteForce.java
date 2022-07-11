package Day11.KthElemOfTwoSortedArrays;

import java.util.ArrayList;
import java.util.Scanner;
/*
Input:
Enter number of elements of arr1 and arr2:
5 4
Enter elements of arr1 in sorted order:
2 3 6 7 9
Enter elements of arr2 in sorted order:
1 4 8 10
Enter the value of k:
5
Output:
Kth element of two sorted arrays: 6

Input:
Enter number of elements of arr1 and arr2:
5 5
Enter elements of arr1 in sorted order:
1 3 5 7 9
Enter elements of arr2 in sorted order:
2 4 6 8 10
Enter the value of k:
7
Output:
Kth element of two sorted arrays: 7

Time complexity: O(n1+n2) : Looping through arr1 and arr2
Space complexity: O(n1+n2): Storing all elements of arr1 and arr2
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
        System.out.println("Enter the value of k:");
        int k = sc.nextInt();
        System.out.println("Kth element of two sorted arrays: "+findKthElemOfTwoSortedArrays(arr1, arr2, n1, n2, k));
    }

    private static int findKthElemOfTwoSortedArrays(int [] arr1, int [] arr2, int n1, int n2, int k){
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
        return mergedArray.get(k-1);
    }
}
