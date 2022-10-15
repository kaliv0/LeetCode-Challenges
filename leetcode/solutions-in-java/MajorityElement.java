/*
    169. Majority Element

    Given an array nums of size n, return the majority element.
    The majority element is the element that appears more than ⌊n / 2⌋ times.
    You may assume that the majority element always exists in the array.
 */

import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
//        var nums = new int[]{3, 2, 3};
        var nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(optValidate(nums));
    }

    private static int validate(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        var result = 0;
        for (var num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length / 2) {
                result = num;
                break;
            }
        }
        return result;
    }

    //Boyer-Moore Voting approach
    private static int optValidate(int[] nums) {
        var candidate = 0;
        var counter = 0;
        for (var num : nums) {
            if (counter == 0) {
                candidate = num;
            }
            if (candidate == num) {
                counter++;
            }
            if (candidate != num) {
                counter--;
            }
        }
        return candidate;
    }
}
