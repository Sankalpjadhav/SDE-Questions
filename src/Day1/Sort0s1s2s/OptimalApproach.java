package Day1.Sort0s1s2s;
import java.util.Scanner;
import static Day1.Sort0s1s2s.BetterApproach.printArray;
/*
Input:
6
2 0 2 1 1 0

Before:
2 0 2 1 1 0

After sorting:
0 0 1 1 2 2

Time complexity: O(n) - Traversing array only once

Space complexity: O(1) : Not using extra space.
 */
public class OptimalApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        printArray(arr, n);
        DutchNationalFlagAlgo(arr, n);
        printArray(arr, n);
    }

    private static void DutchNationalFlagAlgo(int [] arr, int n){
        int low = 0, mid = 0;
        int high = n-1;
        while(mid<=high){
            if(arr[mid]==0){
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else if(arr[mid]==2){
                swap(arr, mid, high);
                high--;
            }
        }
    }

    private static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
