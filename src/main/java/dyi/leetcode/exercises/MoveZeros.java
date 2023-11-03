package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.utils.Utils;

import java.util.Arrays;
import java.util.List;

public class MoveZeros extends AbstractLeetcodeExercise<Integer[]> {
//    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//    Note that you must do this in-place without making a copy of the array.
//
//
//
//    Example 1:
//
//    Input: nums = [0,1,0,3,12]
//    Output: [1,3,12,0,0]
//    Example 2:
//
//    Input: nums = [0]
//    Output: [0]

    public MoveZeros(List<ArgsAndExpected<Integer[]>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    @Override
    public Integer[] exerciseLogic(Object[] args) throws Exception {
        int[] nums = new int[args.length];

        for (int i = 0; i < args.length; i++) {
            nums[i] = (Integer) args[i];
        }
        return moveZeroes(nums);
    }

    private Integer[] moveZeroes(int[] nums) {

        int nonZeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                if (nonZeroIndex != i) {
                    nums[i] = 0;
                }
                nonZeroIndex++;
            }
        }

        return Arrays.stream(nums).boxed().toList().toArray(new Integer[0]);
    }

    public static List<ArgsAndExpected> testCases() {
        return List.of(
                new ArgsAndExpectedImpl(Utils.wrap(new Integer[]{0, 1, 0, 3, 12}), new Integer[]{1, 3, 12, 0, 0}),
                new ArgsAndExpectedImpl(Utils.wrap(new Integer[]{0, 0, 1}), new Integer[]{1, 0, 0}),
                new ArgsAndExpectedImpl(Utils.wrap(new Integer[]{0}), new Integer[]{0})
        );
    }
}
