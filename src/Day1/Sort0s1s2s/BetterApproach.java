package Day1.Sort0s1s2s;
import java.util.Scanner;
/*
Input:
6
2 0 2 1 1 0

Before:
2 0 2 1 1 0

After sorting:
0 0 1 1 2 2

Time complexity: O(2*n)
- Traversing array to count number of 0's, 1's and 2's : O(n)
- Traversing array to add 0's, 1's and 2's : O(n)

Space complexity: O(1) : Not using extra space.
 */
public class BetterApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        printArray(arr, n);
        countingSort(arr, n);
        printArray(arr, n);
    }

    protected static void printArray(int [] arr, int n){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    private static void countingSort(int [] arr, int n){
        int countOf0s = 0;
        int countOf1s = 0;
        int countOf2s = 0;

        for(int i=0;i<n;i++){
            if(arr[i]==0){
                countOf0s++;
            }
            else if(arr[i]==1){
                countOf1s++;
            }
            else if(arr[i]==2){
                countOf2s++;
            }
        }
        int i=0;
        while(countOf0s>0){
            arr[i++] = 0;
            countOf0s--;
        }

        while(countOf1s>0){
            arr[i++] = 1;
            countOf1s--;
        }

        while(countOf2s>0){
            arr[i++] = 2;
            countOf2s--;
        }
    }
}
