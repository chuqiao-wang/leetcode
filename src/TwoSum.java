import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * https://leetcode.com/problems/two-sum/.
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up
     * to target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * You can return the answer in any order.
     *
     * Example 1:
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
     *
     * Example 2:
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     *
     * Example 3:
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIdx = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            Integer idx = numToIdx.get(target - nums[i]);
            if (idx != null) {
                res[0] = idx;
                res[1] = i;
                return res;
            }
            numToIdx.put(nums[i], i);
        }

        // The better way is to throw exception since question says have exactly one solution,
        // but Leetcode doesn't accept the "exception way", so return initial array as [0, 0].
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {2,7,11,15};
        // Expects the result as [0, 1].
        System.out.println(Arrays.toString(TwoSum.twoSum(arr1, /* target= */ 9)));

        // Expects the result as [1, 2].
        int[] arr2 = new int[] {3,2,4};
        System.out.println(Arrays.toString(TwoSum.twoSum(arr2, /* target= */ 6)));

        // Expects the result as [0, 1].
        int[] arr3 = new int[] {3,3};
        System.out.println(Arrays.toString(TwoSum.twoSum(arr3, /* target= */ 6)));

    }
}
