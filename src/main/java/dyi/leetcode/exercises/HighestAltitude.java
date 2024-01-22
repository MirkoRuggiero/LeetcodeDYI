package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.base.TimedReturnImpl;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.interfaces.Return;
import dyi.leetcode.utils.Utils;

import java.util.List;

public class HighestAltitude extends AbstractLeetcodeExercise<Integer> {

    public HighestAltitude(List<ArgsAndExpected<Integer>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    public Return<Integer> largestAltitude(Integer[] gain) {
        TimedReturnImpl<Integer> timedReturn = new TimedReturnImpl<>();
        timedReturn.start();

        int currentAltitude = 0;
        int maxAltitude = 0;
        for (Integer integer : gain) {
            currentAltitude = currentAltitude + integer;
            maxAltitude = Math.max(maxAltitude, currentAltitude);
        }

        timedReturn.setReturnValue(maxAltitude);
        return timedReturn.stop();
    }

    @Override
    public Return<Integer> exerciseLogic(Object[] args) throws Exception {
        Integer[] array = (Integer[]) args;
        return largestAltitude(array);
    }

    public static List<ArgsAndExpected> testCases() {
        return List.of(
                new ArgsAndExpectedImpl(Utils.wrap(new Integer[]{-5, 1, 5, 0, -7}), 1),
                new ArgsAndExpectedImpl(Utils.wrap(new Integer[]{-4, -3, -2, -1, 4, 3, 2}), 0)
        );
    }
}
