package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.utils.Utils;

import java.util.List;

public class CanPlaceFlowers extends AbstractLeetcodeExercise<Boolean> {


    public CanPlaceFlowers(List<ArgsAndExpected<Boolean>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    @Override
    public Boolean exerciseLogic(Object[] args) {
        Integer[] flowerbed = (Integer[]) args[0];
        Integer n = (Integer) args[1];
        return canPlaceFlowers(n, flowerbed);
    }


    public static List<ArgsAndExpected> testCases() {
        return List.of(
                new ArgsAndExpectedImpl<>(Utils.wrap(new Integer[]{1, 0, 0, 0, 1}, 1), true),
                new ArgsAndExpectedImpl<>(Utils.wrap(new Integer[]{1, 0, 0, 0, 1}, 2), false));
    }

    private Boolean canPlaceFlowers(Integer n, Integer[] flowerbed) {
        int planted = 0;
        if (planted == n) {
            return true;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0
                    && (i == flowerbed.length - 1 || i + 1 < flowerbed.length && flowerbed[i + 1] == 0)
                    && (i == 0 || (i - 1 > 0 && flowerbed[i - 1] == 0))) {
                planted++;
                flowerbed[i] = 1;
                if (planted == n) {
                    return true;
                }
            }
        }
        return false;
    }
}
