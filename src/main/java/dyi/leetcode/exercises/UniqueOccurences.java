package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.base.TimedReturnImpl;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.interfaces.Return;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class UniqueOccurences extends AbstractLeetcodeExercise<Boolean> {

    public UniqueOccurences(List<ArgsAndExpected<Boolean>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    public Return<Boolean> uniqueOccurrences(Integer[] arr) {
        var timedReturn = new TimedReturnImpl<Boolean>();
        timedReturn.start();

        var map = new HashMap<Integer, Integer>();
        for (int j : arr) {
            if (map.containsKey(j)) {
                map.put(j, map.get(j) + 1);
            } else {
                map.put(j, 1);
            }
        }
        int n = map.size();
        int n2 = new HashSet<>(map.values()).size();

        timedReturn.setReturnValue(n == n2);
        return timedReturn.stop();
    }

    @Override
    public Return<Boolean> exerciseLogic(Object[] args) throws Exception {
        return uniqueOccurrences((Integer[]) args);
    }

    public static List<ArgsAndExpected> testCases() {
        return List.of(
                new ArgsAndExpectedImpl<>(
                        new Integer[]{1, 2, 2, 1, 1, 3},
                        true),
                new ArgsAndExpectedImpl<>(
                        new Integer[]{1, 2},
                        false),
                new ArgsAndExpectedImpl<>(
                        new Integer[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0},
                        true));
    }
}
