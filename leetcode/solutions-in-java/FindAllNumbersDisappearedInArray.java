/*
    448. Find All Numbers Disappeared in an Array

    Given an array nums of n integers where nums[i] is in the range [1, n],
    return an array of all the integers in the range [1, n] that do not appear in nums.
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindAllNumbersDisappearedInArray {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
//        int[] nums = new int[]{1, 1};
        System.out.println(findNumbersDiff(nums));
    }

    private static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNums = IntStream.rangeClosed(1, nums.length)
                .boxed().collect(Collectors.toList());

        int[] sortedNums = Arrays.stream(nums).distinct().sorted().toArray();
        int index = 0;
        for (int i = 0; i < missingNums.size(); i++) {
            if (missingNums.get(i) == sortedNums[index]) {
                missingNums.remove(i);
                i--;
                index++;
            }
            if (index == sortedNums.length) {
                break;
            }
        }
        return missingNums;
    }

    private static List<Integer> findNumbersDiff(int[] nums) {
        List<Integer> missingNums = IntStream.rangeClosed(1, nums.length)
                .boxed().collect(Collectors.toList());
        Arrays.stream(nums).forEach(n -> missingNums.set(n - 1, 0));
        return missingNums.stream().filter(n -> n > 0).collect(Collectors.toList());
    }
}
