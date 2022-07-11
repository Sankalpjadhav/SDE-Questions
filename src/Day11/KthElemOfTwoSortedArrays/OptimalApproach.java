package Day11.KthElemOfTwoSortedArrays;

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

Time complexity: O(log min(n1,n2)) : Applying binary search on smaller array
Space complexity: O(1): Not using extra space
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
        System.out.println("Enter the value of k:");
        int k = sc.nextInt();
        System.out.println("Kth element of two sorted arrays: "+findKthElemOfTwoSortedArrays(arr1, arr2, n1, n2, k));
    }

    private static int findKthElemOfTwoSortedArrays(int [] arr1, int [] arr2, int n1, int n2, int k){
        if(n2<n1){
            return findKthElemOfTwoSortedArrays(arr2, arr1, n2, n1, k);
        }
        int low = Math.max(0,k-n2);
        int high = Math.min(k,n1);

        while(low<=high){
            int cut1 = (low+high)/2;
            int cut2 = k-cut1;

            int left1 = cut1==0 ? Integer.MIN_VALUE : arr1[cut1-1];
            int left2 = cut2==0 ? Integer.MIN_VALUE : arr2[cut2-1];
            int right1 = cut1==n1 ? Integer.MAX_VALUE : arr1[cut1];
            int right2 = cut2==n2 ? Integer.MAX_VALUE : arr2[cut2];

            if(left1<=right2 && left2<=right1){
                return Math.max(left1, left2);
            }
            else if(left1>right2){
                high = cut1-1;
            }
            else{
                low = cut1+1;
            }
        }

        return 0; // This will never be executed
    }
}
