package Day4.LongestSubstringWithoutRepeatingChars;

import java.util.HashMap;
import java.util.Scanner;
/*
In Better approach, we were traversing the characters twice. In this approach we will directly jump left pointer to previously repeated character + 1.
Input: abcabcbb
Output: Count of longest substring without repeating characters: 3 (abc)

Input: abdahvckahp
Count of longest substring without repeating characters: 7 (bdahvck)

Time complexity: O(n)
O(n) : To traverse entire string using right pointer.
Space complexity: O(n) : Using HashMap to store characters along with index.
 */
public class OptimalApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Count of longest substring without repeating characters: "+getCountOfLongestSubstring(str));
    }

    private static int getCountOfLongestSubstring(String str) {
        int countLongestSubstring = 0;
        int length = str.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        while(right < length){
            if(map.containsKey(str.charAt(right))){
                left = Math.max(left, map.get(str.charAt(right))+1);
            }
            map.put(str.charAt(right), right);
            countLongestSubstring = Math.max(countLongestSubstring, right-left+1);
            right++;
        }
        return countLongestSubstring;
    }
}
