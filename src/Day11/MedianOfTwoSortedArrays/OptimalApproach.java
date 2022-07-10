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

Time complexity: O(log min(n1, n2)) - because we are always making sure we apply binary search on small array
Space complexity: O(1) - Not using extra space
 */
public class OptimalApproach {
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
        if(n2 < n1){
            return findMedianOfTwoSortedArrays(arr2, arr1, n2, n1);
        }
        int low = 0;
        int high = n1; // You might be wondering it should be n1-1, but we need to consider this as a partition index

        while(low<=high){
            int cut1 = (low+high)/2;
            int cut2 = (n1+n2+1)/2 - cut1;

            int left1 = cut1==0 ? Integer.MIN_VALUE : arr1[cut1-1];
            int left2 = cut2==0 ? Integer.MIN_VALUE : arr2[cut2-1];

            int right1 = cut1==n1 ? Integer.MAX_VALUE : arr1[cut1];
            int right2 = cut2==n2 ? Integer.MAX_VALUE : arr2[cut2];

            if(left1<=right2 && left2<=right1) {
                if ((n1 + n2) % 2 == 0) {
                    // Even
                    return (Math.max(left1,left2) + Math.min(right1,right2))/2;
                }
                else{
                    // Odd
                    return Math.max(left1, left2);
                }
            }
            else if(left1 > right2){
                high = cut1-1;
            }
            else{
                low = cut1+1;
            }
        }

        return 0.0;
    }
}
