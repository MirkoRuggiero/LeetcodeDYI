package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.base.TimedReturnImpl;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.interfaces.Return;
import dyi.leetcode.utils.Utils;

import java.util.List;

public class ProductExceptSelf extends AbstractLeetcodeExercise<Integer[]> {

    public ProductExceptSelf(List<ArgsAndExpected<Integer[]>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    @Override
    public Return<Integer[]> exerciseLogic(Object[] args) {
        Integer[] nums = new Integer[args.length];

        for (int i = 0; i < args.length; i++) {
            nums[i] = (Integer) args[i];
        }
        return productExceptSelf(nums);
    }

    private Return<Integer[]> productExceptSelf(Integer[] nums) {
        TimedReturnImpl<Integer[]> timedReturn = new TimedReturnImpl<>();
        timedReturn.start();

        final int size = nums.length;
        if (size == 0) {
            timedReturn.setReturnValue(new Integer[0]);
            return timedReturn.stop();
        }
        final Integer[] answer = new Integer[size];
        final Integer[] prefix = new Integer[size];
        prefix[0] = 1;
        for (int i = 1; i < size; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        int suffixProduct = 1;
        for (int i = size - 1; i >= 0; i--) {
            answer[i] = prefix[i] * suffixProduct;
            suffixProduct *= nums[i];
        }
        timedReturn.setReturnValue(answer);
        return timedReturn.stop();
    }

    public static List<ArgsAndExpected> testCases() {
        return List.of(
                new ArgsAndExpectedImpl<>(Utils.wrap(new Integer[]{1, 2, 3, 4}), new Integer[]{24, 12, 8, 6}),
                new ArgsAndExpectedImpl<>(Utils.wrap(new Integer[]{-1, 1, 0, -3, 3}), new Integer[]{0, 0, 9, 0, 0}));
    }
}
