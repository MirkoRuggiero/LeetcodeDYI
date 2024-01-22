package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.base.TimedReturnImpl;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.interfaces.Return;
import dyi.leetcode.utils.Utils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MaxOperations extends AbstractLeetcodeExercise<Integer> {

    public MaxOperations(List<ArgsAndExpected<Integer>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    public Return<Integer> maxOperations(Integer[] nums, int k) {
        TimedReturnImpl<Integer> timedReturn = new TimedReturnImpl<>();
        timedReturn.start();

        int counter = 0;
        //keep output (which relies on provided args) clean!
        Integer[] copiedArray = new Integer[nums.length];
        System.arraycopy(nums, 0, copiedArray, 0, nums.length);

        List<Integer> l = Arrays.stream(copiedArray)
                .collect(Collectors.toCollection((LinkedList::new)));
        for (int i = 0; i < l.size(); i++) {
            int n = l.get(i);
            for (int j = i + 1; j < l.size(); j++) {
                if (l.get(j) + n == k) {
                    counter++;
                    l.remove(j);
                    l.remove(i);
                    i = -1;
                    break;
                }
            }
        }

        timedReturn.setReturnValue(counter);
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
