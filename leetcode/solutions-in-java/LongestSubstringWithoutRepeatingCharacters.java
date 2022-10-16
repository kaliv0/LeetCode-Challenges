/*
    3. Longest Substring Without Repeating Characters

    Given a string s, find the length of the longest substring without repeating characters.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
//        String s = "abcabcbb";
//        String s = "bbbbb";
//        String s = "pwwkew";
//        String s = "aab";
//        String s = "dvdf";
//        String s = "abba";
        String s = " ";
        System.out.println(findSubstringOpt(s));
    }

    private static int findSubstring(String s) {
        List<Character> chars = new ArrayList<>();
        int maxSize = 0;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (chars.contains(currChar)) {
                maxSize = Math.max(maxSize, chars.size());
                chars.removeAll(chars.subList(0, chars.indexOf(currChar) + 1));
            }
            chars.add(currChar);
        }
        maxSize = Math.max(maxSize, chars.size());
        return maxSize;
    }

    //sliding window approach
    private static int findSubstringOpt(String s) {
        int start = 0;
        int end = 0;
        int size = 0;
        Map<Character, Integer> seen = new HashMap<>();
        while (start < s.length() && end < s.length()) {
            char current = s.charAt(end);
            if (seen.containsKey(current)) {
                start = Math.max(start, seen.get(current) + 1);
            }
            seen.put(current, end);
            size = Math.max(size, end - start + 1);
            end++;
        }
        return size;
    }
}
