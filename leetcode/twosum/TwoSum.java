package leetcode.twosum;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (hashMap.containsKey(comp) && hashMap.get(comp) != i) {
                return new int[]{i, hashMap.get(comp)};
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[][] nums = {{2, 7, 11, 15},
                {3, 2, 4},
                {3, 3}};

        int[][] output = {{0, 1}, {1, 2}, {0, 1}};

        int[] targets = {9, 6, 6};

        TwoSum sum = new TwoSum();
        for (int i = 0; i < 3; i++) {
            int[] result = sum.twoSum(nums[i], targets[i]);
            System.out.printf("Result for example %d : %s, expected : %s\n", i + 1, Arrays.toString(result), Arrays.toString(output[i]));
        }
    }
}
