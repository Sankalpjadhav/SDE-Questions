package Day1.NextPermutation;
import java.util.Scanner;
/*
Input:
5
1 3 5 4 2

Number:
13542

Next Permutation of given number :
14235

Time complexity: O(3n)
- O(n) : For linearly traversing the array from back to find first breakpoint i.e index1.
- O(n) : For linearly traversing the array from back to find element which is slightly greater than first breakpoint element.
- O(n) : Reversing right half of the array i.e to to the right of index1. But, in worst case it can take O(n)

Space complexity: O(1) : Not using extra space.
 */
public class OptimalApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        printArray(arr, n);
        nextPermutation(arr, n);
        System.out.println("Next Permutation of given number :");
        printArray(arr, n);
    }

    protected static void printArray(int [] arr, int n){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    private static void nextPermutation(int [] arr, int n){
        if(arr.length==0 || arr.length==1){
            return;
        }

        int index1 = arr.length-2;
        while(index1>=0 && arr[index1]>=arr[index1+1]){
            index1--;
        }

        if(index1>=0){
            int index2 = arr.length-1;
            while(arr[index2]<=arr[index1]){
                index2--;
            }
            swap(arr, index1, index2);
        }
        reverse(arr, index1+1, arr.length-1);
    }

    private static void swap(int [] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static void reverse(int [] arr, int i, int j){
        while(i<j){
            swap(arr, i++, j--);
        }
    }
}
