package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.base.TimedReturn;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.interfaces.Return;
import dyi.leetcode.utils.Utils;

import java.util.Arrays;
import java.util.List;

public class MaxOperationsFaster extends AbstractLeetcodeExercise<Integer> {

    public MaxOperationsFaster(List<ArgsAndExpected<Integer>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    public Return<Integer> maxOperations(Integer[] nums, int k) {
        TimedReturn<Integer> timedReturn = new TimedReturn<>();
        timedReturn.start();

        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int count = 0;

        while (i < j && i < nums.length && j >= 0) {
            int sum = nums[i] + nums[j];
            if (sum == k) {
                count++;
                i++;
                j--;
            } else if (sum < k) {
                i++;
            } else if (sum > k) {
                j--;
            }
        }

        timedReturn.setReturnValue(count);
        return timedReturn.stop();
    }

    @Override
    public Return<Integer> exerciseLogic(Object[] args) throws Exception {
        Integer[] nums = (Integer[]) args[0];
        Integer k = (Integer) args[1];
        return maxOperations(nums, k);
    }

    public static List<ArgsAndExpected> testCases() {
        return List.of(
                new ArgsAndExpectedImpl<>(
                        Utils.wrap(new Integer[]{1, 2, 3, 4}, 5),
                        2),
                new ArgsAndExpectedImpl<>(
                        Utils.wrap(new Integer[]{3, 1, 3, 4, 3}, 6),
                        1),
                new ArgsAndExpectedImpl<>(
                        Utils.wrap(new Integer[]{4, 4, 1, 3, 1, 3, 2, 2, 5, 5, 1, 5, 2, 1, 2, 3, 5, 4}, 2),
                        2));
    }
}
