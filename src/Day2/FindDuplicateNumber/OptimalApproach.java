package Day2.FindDuplicateNumber;

import java.util.Scanner;

/*
Input:
10
2 5 9 6 4 3 8 9 7 1

Output:
Duplicate number: 9

Time complexity: O(n) : Using slow fast pointer method
Space complexity: O(1) Not using any extra space
 */
public class OptimalApproach {
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
        int slow = arr[0];
        int fast = arr[0];

        do{
            slow = arr[slow];
            fast = arr[arr[fast]];
        }while(slow!=fast);

        fast = arr[0];

        while(slow!=fast){
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow; // return fast
    }
}
