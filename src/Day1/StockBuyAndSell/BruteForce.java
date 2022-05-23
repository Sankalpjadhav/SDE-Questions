package Day1.StockBuyAndSell;
import java.util.Scanner;
/*
Input:
6
7 1 5 3 6 4

Max profit that can be earned: 5

Input:
5
7 6 4 3 1

Max profit that can be earned: 0

Time complexity: O(n^2) : Using two nested for loops.
Space complexity : O(1) : Not using extra space.
 */
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Max profit that can be earned: "+stockBuyAndSell(arr, n));
    }

    private static int stockBuyAndSell(int [] arr, int n)
    {
        int maxProfit = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int profit = arr[j]-arr[i];
                maxProfit = Math.max(profit, maxProfit);
            }
        }

        return maxProfit;
    }
}
