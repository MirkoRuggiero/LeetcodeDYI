package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.base.TimedReturnImpl;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.interfaces.Return;
import dyi.leetcode.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies extends AbstractLeetcodeExercise<List<Boolean>> {

    public KidsWithCandies(List<ArgsAndExpected<List<Boolean>>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    @Override
    public Return<List<Boolean>> exerciseLogic(Object[] args) {
        Integer[] candies = (Integer[]) args[0];
        Integer extraCandies = (Integer) args[1];
        return kidsWithCandies(candies, extraCandies);
    }


    public static List<ArgsAndExpected> testCases() {
        return List.of(
                new ArgsAndExpectedImpl<>(
                        Utils.wrap(new Integer[]{2, 3, 5, 1, 3}, 3),
                        List.of(true, true, true, false, true)));
    }

    private Return<List<Boolean>> kidsWithCandies(Integer[] candies, Integer extraCandies) {
        TimedReturnImpl<List<Boolean>> timedReturn = new TimedReturnImpl<>();
        timedReturn.start();

        List<Boolean> list = new ArrayList<>(candies.length);
        int max = findMax(candies);
        for (int i = 0; i < candies.length; i++) {
            list.add(calculateIfRicher(candies[i], extraCandies, max));
        }

        timedReturn.setReturnValue(list);
        return timedReturn.stop();
    }

    private int findMax(Integer[] candies) {
        int max = -1;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        return max;
    }

    private boolean calculateIfRicher(Integer candy, Integer extraCandies, Integer max) {
        return candy + extraCandies >= max;
    }
}
