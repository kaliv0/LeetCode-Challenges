/*
    1963. Minimum Number of Swaps to Make the String Balanced

    You are given a 0-indexed string s of even length n.
    The string consists of exactly n / 2 opening brackets '[' and n / 2 closing brackets ']'.
    A string is called balanced if and only if:
        -It is the empty string, or
        -It can be written as AB, where both A and B are balanced strings, or
        -It can be written as [C], where C is a balanced string.
    You may swap the brackets at any two indices any number of times.
    Return the minimum number of swaps to make s balanced.
 */


import java.util.Stack;

public class MinimumSwapsToMakeStringBalanced {

    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
//        String s = "][][";
//        String s = "]]][[[";
//        String s = "]][[";
//        String s="[[][]]";
        String s = "[]";

        int swapCount = countSwapsOpt(s);
        System.out.println(swapCount);
    }

    private static int countSwapsOpt(String s) {
        /*
            stack is used to "eliminate" all balanced substrings (nested and contiguous);
            it's guaranteed that every closing bracket has its opening counterpart
                => therefore we count only closing the ones that are encountered
                    before the opening brackets they should be paired with
                NB: since contiguous pairs are also allowed, we need only half of the possible swaps
                (rounded up to the closest whole number)
         */
        int swapCounter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else swapCounter++;
            }
        }
//        return (swapCounter + 1) / 2;
        return (int) Math.ceil(swapCounter / 2.0);
    }

    private static int countSwaps(String s) {
        char[] brackets = s.toCharArray();
        if (validateBrackets(brackets)) {
            return 0;
        }

        int halfLength = s.length() / 2;
        int leftIndex = 0;
        int rightIndex = s.length() - 1;
        int swapCounter = 0;
        while (leftIndex < halfLength && rightIndex >= halfLength) {
            if (brackets[leftIndex] == ']' && brackets[rightIndex] == '[') {
                swap(brackets, leftIndex, rightIndex);
                swapCounter++;
                if (validateBrackets(brackets)) {
                    break;
                }
                continue;
            }
            if (brackets[leftIndex] == '[') {
                leftIndex++;
            }
            if (brackets[rightIndex] == ']') {
                rightIndex--;
            }
        }
        return swapCounter;
    }

    private static boolean validateBrackets(char[] brackets) {
        for (char currBracket : brackets) {
            if (currBracket == '[') {
                stack.push(currBracket);
            } else if (currBracket == ']') {
                if (stack.empty()) {
                    return false;
                }
                stack.pop();
            }
        }
        boolean isValid = stack.empty();
        stack.clear();
        return isValid;
    }

    private static void swap(char[] brackets, int left, int right) {
        char temp = brackets[left];
        brackets[left] = brackets[right];
        brackets[right] = temp;
    }
}
