package Day2.MergeTwoSortedArrays;

import java.util.Arrays;
import java.util.Scanner;
/*
Input:
1 2 3
2 5 6

Before:
Arr1 : 1 2 3 0 0 0
Arr2 : 2 5 6

After Merging:
Arr1 : 1 2 2 3 5 6

Time complexity: O(nlogn) + O(2n) : Sorting and traversing array to copy elements .
Space complexity: O(n) : Using extra space.
 */
import static Day2.MergeTwoSortedArrays.OptimalApproach.printArray;

public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] arr1 = new int[6];
        int m = 3;
        for(int i=0;i<m;i++){
            arr1[i] = sc.nextInt();
        }
        int [] arr2 = new int[3];
        for(int i=0;i<arr2.length;i++){
            arr2[i] = sc.nextInt();
        }
        mergeTwoSortedArrays(arr1, arr2, m);
        printArray(arr1);
    }

    private static void mergeTwoSortedArrays(int [] arr1, int [] arr2, int index1){
        int index = arr1.length;
        int index2 = arr2.length;
        int [] res = new int[index];
        int k = 0;
        for(int i=0;i<index1;i++){
           res[k++] = arr1[i];
        }
        for(int i=0;i<index2;i++){
            res[k++] = arr2[i];
        }
        Arrays.sort(res);

        for(int i=0;i<index;i++){
            arr1[i] = res[i];
        }
    }
}
