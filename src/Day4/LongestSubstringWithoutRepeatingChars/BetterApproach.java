package Day4.LongestSubstringWithoutRepeatingChars;

import java.util.HashSet;
import java.util.Scanner;
/*
Input: abcabcbb
Output: Count of longest substring without repeating characters: 3 (abc)

Input: abdahvckahp
Count of longest substring without repeating characters: 7 (bdahvck)

Time complexity: O(n) + O(n)
O(n) : To traverse entire string using right pointer.
O(n) : using while loop to move left pointer as long as the repeated character is removed from set.
Space complexity: O(n) : Using hashset to store characters.
 */
public class BetterApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Count of longest substring without repeating characters: "+getCountOfLongestSubstring(str));
    }

    private static int getCountOfLongestSubstring(String str){
        int countLongestSubstring = 0;
        int length = str.length();
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0;
        while(right < length){
            if(set.contains(str.charAt(right))){
                while(set.contains(str.charAt(right))){
                    set.remove(str.charAt(left));
                    left++;
                }
            }
            set.add(str.charAt(right));
            countLongestSubstring = Math.max(countLongestSubstring, right-left+1);
            right++;
        }

        return countLongestSubstring;
    }
}
