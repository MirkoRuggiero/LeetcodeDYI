package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.base.TimedReturnImpl;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.interfaces.Return;
import dyi.leetcode.utils.Utils;

import java.util.List;

public class PivotIndex extends AbstractLeetcodeExercise<Integer> {

    public PivotIndex(List<ArgsAndExpected<Integer>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    @Override
    public Return<Integer> exerciseLogic(Object[] args) throws Exception {
        return pivotIndex((Integer[]) args);
    }

    public Return<Integer> pivotIndex(Integer[] nums) {
        TimedReturnImpl<Integer> timedReturn = new TimedReturnImpl<>();
        timedReturn.start();

        for (int i = 0; i < nums.length; i++) {
            int r = rightSum(nums, i);
            int l = leftSum(nums, i);
            if (r == l ) {
                timedReturn.setReturnValue(i);
                break;
            }
        }

        if (timedReturn.getReturnValue() == null) {
            timedReturn.setReturnValue(-1);
        }

        return timedReturn.stop();
    }
//        int pivotIdx = -1;
//        if (nums == null || nums.length == 0) {
//            return pivotIdx;
//        }
//
//        int len = nums.length;
//        int[] prefixSums = new int[len];
//        int sum = 0;
//        for (int i = 0; i < len; i++) {
//            sum += nums[i];
//            prefixSums[i] = sum;
//        }
//
//        for (int i = 0; i < len; i++) {
//            int leftSum = (i > 0) ? prefixSums[i - 1] : 0;
//            int rightSum = prefixSums[len - 1] - prefixSums[i];
//            if (leftSum == rightSum) {
//                pivotIdx = i;
//                break;
//            }
//        }
//        return pivotIdx;

    private int leftSum(Integer[] nums, int i) {
        int sum = 0;
        for (int idx = 0; idx < i; idx++) {
            sum += nums[idx];
        }
        return sum;
    }

    private int rightSum(Integer[] nums, int i) {
        int sum = 0;
        for (int idx = i + 1; idx < nums.length; idx++) {
            sum += nums[idx];
        }
        return sum;
    }

    public static List<ArgsAndExpected> testCases() {
        return List.of(
                new ArgsAndExpectedImpl(Utils.wrap(new Integer[]{1, 7, 3, 6, 5, 6}), 3),
                new ArgsAndExpectedImpl(Utils.wrap(new Integer[]{1, 2, 3}), -1),
                new ArgsAndExpectedImpl(Utils.wrap(new Integer[]{2, 1, -1}), -0)
        );
    }
}
