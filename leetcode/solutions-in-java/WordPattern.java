/*
    290. Word Pattern

    Given a pattern and a string s, find if s follows the same pattern.
    Here follow means a full match,
    such that there is a bijection between a letter in pattern and a non-empty word in s.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordPattern {
    public static void main(String[] args) {
//        String pattern = "abba";
//        String s = "dog cat cat dog";
//        String s = "dog cat cat cow";
//        String s = "dog dog dog dog";

        String pattern = "a";
        String s = "a";
        System.out.println(evaluateOpt(pattern, s));
    }

    private static boolean evaluate(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            //there are two situations where the mapping would return false:
            //if equal keys point to different values
            char currChar = pattern.charAt(i);
            String currWord = words[i];
            if (map.containsKey(currChar)) {
                if (!Objects.equals(map.get(currChar), currWord)) {
                    return false;
                }
                continue;
            }
            //if equal values are associated with different keys
            if (map.containsValue(currWord)) {
                return false;
            }
            map.put(currChar, currWord);
        }
        return true;
    }

    //optimized version would be if both keys and values are associated with
    //the index they are encountered for the first time
    private static boolean evaluateOpt(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        //NB: when the put method of Java's hashMap is used
        //it returns the previous value associated the key or null
        Map<Character, Integer> charMap = new HashMap<>();
        Map<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character currChar = pattern.charAt(i);
            String currWord = words[i];
            if (!Objects.equals(charMap.put(currChar, i), wordMap.put(currWord, i))) {
                return false;
            }
        }
        return true;
    }
}
