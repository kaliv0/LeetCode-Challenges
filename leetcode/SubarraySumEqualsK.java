import java.util.HashMap;
import java.util.Map;

/*
    560. Subarray Sum Equals K

    Given an array of integers nums and an integer k,
    return the total number of subarrays whose sum equals to k.

    A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class SubarraySumEqualsK {
    public static void main(String[] args) {
//        int[] nums = new int[]{1, 1, 1};
//        int k = 2;

//        int[] nums = new int[]{1, 2, 3};
//        int k = 3;

//        int[] nums = new int[]{1, 2, 1, 2, 1};
//        int k = 3;

//        int[] nums = new int[]{-1, 1, 0};
//        int k = 0;

//        int[] nums = new int[]{-1, -1, 1};
//        int k = 0;

//        int[] nums = new int[]{100, 1, 2, 3, 4};
//        int k = 6;//

        int[] nums = new int[]{0, 0};
        int k = 0;

        System.out.println(processArrayOpt(nums, k));
    }

    private static int processArrayOpt(int[] nums, int k) {
        /*
            Loop through array once.
            Use "accumulator" variable (as in a reduce function) to sum all numbers.
            Track every state of the accumulator as a key in a hashmap
            and keep count of how many times that state is encountered
            (could be multiple times due to zeros negative numbers and zeros).
            If the current state minus k gives us a key that is present in the map
            this means that from the past state up to the present one has been accumulated a sum equal to k-
            therefore increment the counter with the value associated with that key.
            The hashmap starts with (0, 1) since the array could start with a number
            (or a sequence of numbers with sum) equal to k
            i.e. n-k would lead us back to zero as a key
         */
        int sum = 0;
        int counter = 0;
        Map<Integer, Integer> stateMap = new HashMap<>();
        stateMap.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (stateMap.containsKey(sum - k)) {
                counter += stateMap.get(sum - k);
            }
            stateMap.put(sum, stateMap.getOrDefault(sum, 0) + 1);
        }
        return counter;
    }

    private static int processArray(int[] nums, int k) {
        //brute force version -> O(n**2)
        int counter = 0;
        int currentSum;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == k) {
                counter++;
            }
            currentSum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                currentSum += nums[j];
                if (currentSum != k) {
                    continue;
                }
                counter++;
            }
        }
        if (nums[nums.length - 1] == k) {
            counter++;
        }
        return counter;
    }
}
