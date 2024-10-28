package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.base.ReturnImpl;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.interfaces.Return;
import dyi.leetcode.utils.Utils;

import java.util.List;

public class MCD extends AbstractLeetcodeExercise<Integer> {

    public MCD(List<ArgsAndExpected<Integer>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    @Override
    public Return<Integer> exerciseLogic(Object[] args) throws Exception {
        return new ReturnImpl<>(mcd((int) args[0], (int) args[1]));
    }

    private int mcd(int a, int b) {
        int mcd = 1;
        int c = 2;
        do {
            if (a % c == 0 && b % c == 0) {
                mcd = c;
            }
            c++;
        } while (c <= a && c <= b);

        return mcd;
    }

    public static List<ArgsAndExpected> testCases() {
        return List.of(
                new ArgsAndExpectedImpl<>(Utils.wrap(36, 54), 18),
                new ArgsAndExpectedImpl<>(Utils.wrap(7, 3), 1)
        );
    }
}
