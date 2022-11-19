/*
    1930. Unique Length-3 Palindromic Subsequences

    Given a string s, return the number of unique palindromes
    of length three that are a subsequence of s.
    Note that even if there are multiple ways to obtain the same subsequence,
    it is still only counted once.

    A palindrome is a string that reads the same forwards and backwards.
    A subsequence of a string is a new string generated from the original string
    with some characters (can be none) deleted without changing the relative order
    of the remaining characters.
 */

import java.util.*;
import java.util.stream.Collectors;

public class UniqueLengthThreePalindromicSubsequences {
    public static void main(String[] args) {
//        String s = "aabca";
//        String s = "adc";
        String s = "bbcbaba";

        int subsequenceCount = manageStringOpt(s);
        System.out.println(subsequenceCount);
    }

    private static int manageString(String s) {
        /*
            to obtain substrings => take char from left side, find same char on far right side,
            find all unique chars in between
                => their number corresponds to possible palindromic combinations

            keep count of already used chars from left side
         */

        Set<Character> usedChars = new HashSet<>();
        Set<Character> uniqueChars = new HashSet<>();
        int charCount = 0;
        char left;
        String currSubstr;
        for (int i = 0; i < s.length() - 2; i++) {
            left = s.charAt(i);
            if (usedChars.contains(left)) {
                continue;
            }
            for (int j = s.length() - 1; j > 1; j--) {
                if (s.charAt(j) == left && j - i > 1) {
                    currSubstr = s.substring(i + 1, j);
//                    uniqueChars = currSubstr
//                            .chars()
//                            .mapToObj(e -> (char) e)
//                            .collect(Collectors.toSet());
                    if (i > 0) {
                        uniqueChars.clear();
                    }
                    for (int k = 0; k < currSubstr.length(); k++) {
                        uniqueChars.add(currSubstr.charAt(k));
                    }
                    charCount += uniqueChars.size();
                    usedChars.add(left);
                    break;
                }
            }
        }
        return charCount;
    }

    private static int manageStringOpt(String s) {
        /*
            second approach:
            read string once, create map with char-list of indices
            loop through map
                => if list.size > 1
                    => take first and last index
                        =>if last - first > 1 => search for chars in between

            chars in middle:
            loop through map
                => if list contains char > first && char < last
         */
        Map<Character, List<Integer>> charIndices = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (!charIndices.containsKey(currChar)) {
                charIndices.put(currChar, new ArrayList<>());
            }
            charIndices.get(currChar).add(i);
        }

        int totalCount = 0;
        for (Character charKey : charIndices.keySet()) {
            List<Integer> currIndices = charIndices.get(charKey);
            int first = currIndices.get(0);
            int last = currIndices.get(currIndices.size() - 1);
            if (currIndices.size() == 1
                    || last - first == 1) {
                continue;
            }
            for (List<Integer> indexList : charIndices.values()) {
                if (indexList.stream().anyMatch(c -> c > first && c < last)) {
                    totalCount++;
                }
            }
        }
        return totalCount;
    }
}
