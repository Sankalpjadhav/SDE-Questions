package Day4.LongestSubstringWithoutRepeatingChars;

import java.util.HashSet;
import java.util.Scanner;
/*

Input: abcabcbb
Output: Count of longest substring without repeating characters: 3 (abc)

Input: abdahvckahp
Count of longest substring without repeating characters: 7 (bdahvck)

Time complexity: O(n^3) : Using 2 nested for loops to generate all substrings and then calculating substrings without repeated characters.
Space complexity: O(n) : Using hashset to store substrings.
 */
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Count of longest substring without repeating characters: "+getCountOfLongestSubstring(str));
    }

    private static int getCountOfLongestSubstring(String str){
        int countOfLongestSubstring = 0;
        HashSet<Character> set;
        int n = str.length();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                 set = new HashSet<>();
                for(int k=i;k<=j;k++){
                    set.add(str.charAt(k));
                }
                if(set.size()==(j-i+1)){
                    countOfLongestSubstring = Math.max(countOfLongestSubstring, j-i+1);
                }
            }
        }

        return countOfLongestSubstring;
    }
}
