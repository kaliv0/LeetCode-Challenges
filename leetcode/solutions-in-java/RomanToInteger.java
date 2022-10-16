/*
    13. Roman to Integer

    Given a roman numeral, convert it to an integer.
 */

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
//        String s = "III";
//        String s = "LVIII";
        String s = "MCMXCIV";

        System.out.println(convertNumber(s));
    }

    private static int convertNumber(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        int prevNum = 0;
        int currNum;
        for (int i = s.length() - 1; i >= 0; i--) {
            currNum = map.get(s.charAt(i));
            if (currNum < prevNum) {
                result -= currNum;
            } else {
                result += currNum;
            }
            prevNum = currNum;
        }
        return result;
    }
}
