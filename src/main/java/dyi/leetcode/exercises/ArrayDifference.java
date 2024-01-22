package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.base.TimedReturnImpl;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.interfaces.Return;
import dyi.leetcode.utils.Utils;

import java.util.*;

public class ArrayDifference extends AbstractLeetcodeExercise<List<List<Integer>>> {

    public ArrayDifference(List<ArgsAndExpected<List<List<Integer>>>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    public Return<List<List<Integer>>> findDifference(Integer[] nums1, Integer[] nums2) {
        var timedReturn = new TimedReturnImpl<List<List<Integer>>>();
        timedReturn.start();

        List<List<Integer>> result = new ArrayList<>();

        Set<Integer> set0 = new HashSet<>(nums1.length);

        set0.addAll(Arrays.asList(nums1));
        for (int k : nums2) {
            set0.remove(k);
        }
        result.add(set0.stream().toList());
        set0.clear();

        set0.addAll(Arrays.asList(nums2));
        for (int j : nums1) {
            set0.remove(j);
        }
        new HashSet<Integer>(new HashMap<Integer, Integer>().values());
        result.add(set0.stream().toList());
        timedReturn.setReturnValue(result);
        return timedReturn.stop();
    }

    @Override
    public Return<List<List<Integer>>> exerciseLogic(Object[] args) throws Exception {
        Integer[] arr1 = (Integer[]) args[0];
        Integer[] arr2 = (Integer[]) args[1];
        return findDifference(arr1, arr2);
    }

    public static List<ArgsAndExpected> testCases() {
        return List.of(
                new ArgsAndExpectedImpl(Utils.wrap(new Integer[]{1, 2, 3}, new Integer[]{2, 4, 6}),
                        List.of(List.of(1, 3), List.of(4, 6)))
        );
    }
}
