/*
    496. Next Greater Element I

    The next greater element of some element x in an array is the first greater element
    that is to the right of x in the same array.
    You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
    For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j]
    and determine the next greater element of nums2[j] in nums2.
    If there is no next greater element, then the answer for this query is -1.
    Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 */

import javax.sound.midi.Track;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.IntStream;

public class NextGreaterElement_I {
    public static void main(String[] args) {
//        var nums1 = new int[]{4, 1, 2};
//        var nums2 = new int[]{1, 3, 4, 2};
        var nums1 = new int[]{1, 3, 5, 2, 4};
        var nums2 = new int[]{6, 5, 4, 3, 2, 1, 7};

        System.out.println(Arrays.toString(optProcessArrays(nums1, nums2)));
    }

    private static int[] processArrays(int[] nums1, int[] nums2) {
        var num = 0;
        var isPresent = false;
        //loop through first array
        for (int i = 0; i < nums1.length; i++) {
            num = nums1[i];
            isPresent = false;
            for (int j = 0; j < nums2.length; j++) {
                //find corresponding number in second array
                if (nums2[j] == num) {
                    //check if any of subsequent number is greater
                    for (int k = j + 1; k < nums2.length; k++) {
                        if (nums2[k] > nums2[j]) {
                            nums1[i] = nums2[k];
                            isPresent = true;
                            break;
                        }
                    }
                    if (!isPresent) {
                        //if no greater number is found
                        nums1[i] = -1;
                        break;
                    }
                }
            }
        }
        return nums1;
    }

    private static int[] optProcessArrays(int[] nums1, int[] nums2) {
        //loop through second array, create map with greater element for each number (if any)
        var map = new HashMap<Integer, Integer>();
        var stack = new Stack<Integer>();
        for (var num : nums2) {
            //use a stack to track all numbers,
            //when a greater number is found, pop from stack and store in map
            //corresponding pair -> number and greater one
            while (!stack.empty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        //loop through first array and read from map if greater number is present
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}
