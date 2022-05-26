package Day2.FindDuplicateNumber;

import java.util.Arrays;
import java.util.Scanner;
/*
Input:
10
2 5 9 6 4 3 8 9 7 1

Output:
Duplicate number: 9

Time complexity: O(nlogn) + O(n)
Space complexity: O(1) (Sorting takes extra space O(n))
 */
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Duplicate number: "+findDuplicateNumber(arr));
    }

    private static int findDuplicateNumber(int [] arr){
        int duplicateNumber = -1;
        int n = arr.length;
        Arrays.sort(arr);
        for(int i=1;i<n;i++){
            if(arr[i]==arr[i-1]){
                duplicateNumber = arr[i];
                break;
            }
        }
        return duplicateNumber;
    }
}
