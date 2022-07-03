package Day9.KthPermutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
Enter the value of N and K
4
17
Kth permutation: 3412

Time complexity: O(n! * n) + O(n! log n!)
n! permutations possible
n - we will be storing deep copy of all the permuations
O(n! log n!) - Sorting n! permutations

Space complexity: n!
 */
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of N and K");
        int n = sc.nextInt();
        int k = sc.nextInt();
        String numbers = "";
        for(int i=1;i<=n;i++){
            numbers+=i;
        }
        String kthPermutation = KthPermutation(numbers, k);
        System.out.println("Kth permutation: "+kthPermutation);
    }

    private static String KthPermutation(String numbers, int k){
        ArrayList<String> permutations = new ArrayList<>();
        getKthPermutation(numbers, permutations, "");
        Collections.sort(permutations);
        return permutations.get(k-1);
    }

    private static void getKthPermutation(String numbers, ArrayList<String> permutations, String sequence){
        if(numbers.length()==0){
            permutations.add(sequence);
            return;
        }

        for(int i=0;i<numbers.length();i++){
            char ch = numbers.charAt(i);
            String remainingString = numbers.substring(0,i)+numbers.substring(i+1);
            getKthPermutation(remainingString, permutations, sequence+ch);
        }
    }
}
