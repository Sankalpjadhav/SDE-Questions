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

Time complexity: O(n) : Traversing array only once by keeping track of minimum element to the left and calculating profit accordingly.
Space complexity : O(1) : Not using extra space.
 */
public class OptimalApproach {
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
        int minimum = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            if(arr[i]<minimum){
                minimum = arr[i];
            }
            else{
                maxProfit = Math.max(maxProfit, arr[i]-minimum);
            }
        }

        return maxProfit;
    }
}
