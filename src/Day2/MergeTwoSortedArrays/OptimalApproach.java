package Day2.MergeTwoSortedArrays;

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

Time complexity: O(n) : Basically traversing Arr1 once.
Space complexity: O(1) : Not using any extra space.
 */
public class OptimalApproach {
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
        mergeTwoSortedArrays(arr1, arr2, m-1);
        printArray(arr1);
    }

    protected static void printArray(int [] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void mergeTwoSortedArrays(int [] arr1, int [] arr2, int index1){
        int index2 = arr2.length-1;
        int index = arr1.length-1;

        while(index>=0){
            if(index1<0){
                arr1[index] = arr2[index2];
                index2--;
            }
            else if(index2<0){
                arr1[index] = arr1[index1];
                index1--;
            }
            else{
                if(arr1[index1] < arr2[index2]){
                    arr1[index] = arr2[index2];
                    index2--;
                }
                else{
                    arr1[index] = arr1[index1];
                    index1--;
                }
            }
            index--;
        }
    }
}
