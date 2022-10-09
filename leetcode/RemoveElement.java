import java.util.Arrays;

/*
    27. Remove Element

    Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
    The relative order of the elements may be changed.
    Since it is impossible to change the length of the array in some languages,
    you must instead have the result be placed in the first part of the array nums.
    More formally, if there are k elements after removing the duplicates,
    then the first k elements of nums should hold the final result.
    It does not matter what you leave beyond the first k elements.

    Return k after placing the final result in the first k slots of nums.
    Do not allocate extra space for another array.
    You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class RemoveElement {
    public static void main(String[] args) {
//        int[] nums = new int[]{3, 2, 2, 3};
//        int val = 3;

        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;

        int k = filter(nums, val);
        System.out.println(Arrays.toString(nums));
        System.out.println(k);
    }

    private static int filter(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
