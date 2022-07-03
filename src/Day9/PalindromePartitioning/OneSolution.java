package Day9.PalindromePartitioning;

import java.util.ArrayList;
import java.util.Scanner;
/*
Input:
Enter the String:
aab
Output:
Partitioning string:
[a, a, b] [aa, b]

Time complexity: O(2^n * n)
Here we are basically trying out every possible partition out there. For a string with length n, you will have 2^(n-1) ways to partition it. this is bcoz
a partition is equivalent in putting a '|' in between two chars. There are n-1 slots to place. There are only two choice for each slot -  to placing '|' or not placing a '|'.
thus 2^n-1 ways to place '|'s.
Then for each unique partitioning you have to traverse the entire string(in worst case when you have repeating chars) to make sure every partition is a palindrome.
So n*2^n-1 = O(n * 2^n)

Space complexity: N^2, where N is the length of String
 */
public class OneSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String str = sc.nextLine();
        ArrayList<ArrayList<String>> palindromePartitioningStrings = palindromePartitioning(str);
        System.out.println("Partitioning string: ");
        for(ArrayList<String> partitions: palindromePartitioningStrings){
            System.out.print(partitions+" ");
        }
    }

    private static ArrayList<ArrayList<String>> palindromePartitioning(String str){
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> currentList = new ArrayList<>();
        getPalindromePartitioningStrings(str, currentList, result);
        return result;
    }

    private static void getPalindromePartitioningStrings(String str, ArrayList<String> currentList, ArrayList<ArrayList<String>> result){
        if(str.length()==0){
            result.add(new ArrayList<>(currentList));
            return;
        }

        for(int i=0;i<str.length();i++){
            String prefixString = str.substring(0, i+1);
            String remainingString = str.substring(i+1);
            if(isPalindrome(prefixString)){
                currentList.add(prefixString);
                getPalindromePartitioningStrings(remainingString, currentList, result);
                currentList.remove(currentList.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String str){
        String reverseString  = "";
        for(int i=str.length()-1;i>=0;i--){
            reverseString += str.charAt(i);
        }
        if(reverseString.equals(str)){
            return true;
        }
        return false;
    }
}
