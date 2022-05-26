package Day2.FindDuplicateNumber;

import java.util.Scanner;

/*
Input:
10
2 5 9 6 4 3 8 9 7 1

Output:
Duplicate number: 9

Time complexity: O(n)
Space complexity: O(n) Making use of frequency array
 */
public class BetterApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Duplicate number: "+findDuplicateNumber(arr, n));
    }

    private static int findDuplicateNumber(int [] arr, int n){
        int [] freqArray = new int[n];

        for(int i=0;i<n;i++){
            if(freqArray[arr[i]]==1){
                return arr[i];
            }
            else {
                freqArray[arr[i]] = 1;
            }
        }
        return -1;
    }
}
