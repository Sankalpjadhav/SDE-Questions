package Day8.MinimumNumberOfCoinsGreedily;

import java.util.ArrayList;
import java.util.Scanner;
/*
Input:
Enter a value to make change:
49
Output:
Minimum number of coins and/or notes needed to make change: [20, 20, 5, 2, 2]

Time complexity: O(Value) at worst case
Space complexity: O(1)
 */
public class OptimalApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a value to make change: ");
        int value = sc.nextInt();
        int [] denominations = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        System.out.println("Minimum number of coins and/or notes needed to make change: "+getMinimumCoinsOrNotes(value, denominations));
    }

    private static ArrayList<Integer> getMinimumCoinsOrNotes(int value, int [] denominations){
        ArrayList<Integer> result = new ArrayList<Integer>();
        int numberOfDenominations = denominations.length;
        for(int i=numberOfDenominations-1;i>=0;i--){
            while(value >= denominations[i]){
                value -= denominations[i];
                result.add(denominations[i]);
            }
        }
        return result;
    }
}
