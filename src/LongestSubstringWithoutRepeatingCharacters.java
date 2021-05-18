import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * https://leetcode.com/problems/longest-substring-without-repeating-characters/.
     *
     * Given a string s, find the length of the longest substring without repeating characters.
     *
     * Example 1:
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     *
     * Example 2:
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     *
     * Example 3:
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     *
     * Example 4:
     * Input: s = ""
     * Output: 0
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> chars = new HashSet<>();
        int start = 0;
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            while (!chars.add(ch)) {
                chars.remove(s.charAt(start++));
            }
            longest = Math.max(longest, i - start + 1);
        }
        return longest;
    }

    public static void main(String[] args) {
        // Expects results as 3.
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        // Expects results as 1.
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        // Expects results as 3.
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        // Expects results as 0.
        System.out.println(lengthOfLongestSubstring(""));
    }
}
