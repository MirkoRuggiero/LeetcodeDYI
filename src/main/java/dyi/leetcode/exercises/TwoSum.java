package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.base.TimedReturn;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.interfaces.Return;
import dyi.leetcode.utils.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum extends AbstractLeetcodeExercise<Integer[]> {


    public TwoSum(List<ArgsAndExpected<Integer[]>> argsAndExpected) throws Exception {
        super(argsAndExpected);
    }

    @Override
    public Return<Integer[]> exerciseLogic(Object[] args) {
        Integer[] nums = (Integer[]) args[0];
        Integer target = (Integer) args[1];
        return twoSum(nums, target);
    }

    private Return<Integer[]> twoSum(Integer[] nums, Integer target) {
        TimedReturn<Integer[]> timedReturn = new TimedReturn<>();
        timedReturn.start();

        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                timedReturn.setReturnValue(new Integer[]{numMap.get(complement), i});
                return timedReturn.stop();
            }
            numMap.put(nums[i], i);
        }
        timedReturn.setReturnValue(new Integer[]{});
        return timedReturn.stop();
    }

    public static List<ArgsAndExpected> testCases() {
        return List.of(
                new ArgsAndExpectedImpl(Utils.wrap(new Integer[]{3, 3}, 6), new Integer[]{0, 1}),
                new ArgsAndExpectedImpl(Utils.wrap(new Integer[]{3, 2, 4}, 6), new Integer[]{1, 2}),
                new ArgsAndExpectedImpl(Utils.wrap(new Integer[]{2, 11, 15, 7}, 9), new Integer[]{0, 3})
        );
    }

}
