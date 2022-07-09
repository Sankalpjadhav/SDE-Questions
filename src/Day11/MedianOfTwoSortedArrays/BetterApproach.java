package Day11.MedianOfTwoSortedArrays;

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

Time complexity: O(n1+n2) - Basically comparing by merging all n1+n2 elements
Space complexity: O(1) - Not using extra space
 */
public class BetterApproach {
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

    private static double findMedianOfTwoSortedArrays(int [] arr1, int [] arr2, int m, int n) {
        int i = 0;

        // Current index of input array ar2[]
        int j = 0;
        int count;
        int m1 = -1, m2 = -1;

        // Since there are (n+m) elements,
        // There are following two cases
        // if n+m is odd then the middle
        //index is median i.e. (m+n)/2
        if ((m + n) % 2 == 1) {
            for (count = 0;
                 count <= (n + m) / 2;
                 count++) {
                if (i != n && j != m) {
                    m1 = (arr1[i] > arr2[j]) ?
                            arr2[j++] : arr1[i++];
                } else if (i < n) {
                    m1 = arr1[i++];
                }

                // for case when j<m,
                else {
                    m1 = arr2[j++];
                }
            }
            return m1;
        }

        // median will be average of elements
        // at index ((m+n)/2 - 1) and (m+n)/2
        // in the array obtained after merging
        // ar1 and ar2
        else {
            for (count = 0;
                 count <= (n + m) / 2;
                 count++) {
                m2 = m1; // ***IMP***
                if (i != n && j != m) {
                    m1 = (arr1[i] > arr2[j]) ?
                            arr2[j++] : arr1[i++];
                } else if (i < n) {
                    m1 = arr1[i++];
                }

                // for case when j<m,
                else {
                    m1 = arr2[j++];
                }
            }
            return (m1 + m2) / 2;
        }
    }
}
