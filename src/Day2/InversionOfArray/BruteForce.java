package Day2.InversionOfArray;
import java.util.Scanner;
/*
Input:
4
8 4 2 1

Output:
Inversion Count: 6

Time complexity: O(n^2) : Using two for loops
Space complexity: O(1) : Not using extra space
 */
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Inversion Count: "+getInversionCount(arr, n));
    }

    private static int getInversionCount(int [] arr, int n){
        int count = 0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i] > arr[j]){
                    count++;
                }
            }
        }

        return count;
    }
}
