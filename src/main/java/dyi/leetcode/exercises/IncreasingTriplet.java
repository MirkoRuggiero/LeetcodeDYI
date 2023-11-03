package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.utils.Utils;

import java.util.List;

public class IncreasingTriplet extends AbstractLeetcodeExercise<Boolean> {
    public IncreasingTriplet(List<ArgsAndExpected<Boolean>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    @Override
    public Boolean exerciseLogic(Object[] args) {
        Integer[] nums = new Integer[args.length];

        for (int i = 0; i < args.length; i++) {
            nums[i] = (Integer) args[i];
        }
        return increasingTriplet(nums);
    }

    private Boolean increasingTriplet(Integer[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }

        return false;
    }

    public static List<ArgsAndExpected> testCases() {
        return List.of(
                new ArgsAndExpectedImpl(Utils.wrap(new Integer[]{1, 2, 3, 4, 5}), true),
                new ArgsAndExpectedImpl(Utils.wrap(new Integer[]{5, 4, 3, 2, 1}), false),
                new ArgsAndExpectedImpl(Utils.wrap(new Integer[]{2, 1, 5, 0, 4, 6}), true),
                new ArgsAndExpectedImpl(Utils.wrap(new Integer[]{20, 100, 10, 12, 5, 13}), true)
        );
    }
}
