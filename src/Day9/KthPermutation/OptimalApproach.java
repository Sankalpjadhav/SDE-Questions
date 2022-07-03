package Day9.KthPermutation;

import java.util.ArrayList;
import java.util.Scanner;
/*
Enter the value of N and K
4
17
Kth permutation: 3412

Time complexity: O(n*n)
n - we have n=4 that means we definitely need to find out n numbers
n - we need to remove one number from numbers which is O(n) in nature

Space complexity: O(n) - Using arraylist to store numbers
 */
public class OptimalApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of N and K");
        int n = sc.nextInt();
        int k = sc.nextInt();
        String kthPermutation = kthPermutation(n, k);
        System.out.println("Kth permutation: "+kthPermutation);
    }

    private static String kthPermutation(int n, int k){
        String result = "";
        int fact = 1;
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i=1;i<n;i++){ // imp condition: observer closely
            fact = fact*i;
            numbers.add(i);
        }
        numbers.add(n);
        k = k-1;
        while(true){
            result += numbers.get(k/fact);
            numbers.remove(k/fact);
            if(numbers.size() ==0){
                break;
            }
            k = k % fact;
            fact = fact/numbers.size();
        }
        return result;
    }
}
