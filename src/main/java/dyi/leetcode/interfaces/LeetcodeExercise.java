package dyi.leetcode.interfaces;

import java.util.List;

public interface LeetcodeExercise<ReturnType> {
    ReturnType exerciseLogic(Object[] args) throws Exception;

    static List<ArgsAndExpected> testCases() {
        throw new UnsupportedOperationException();
    }
}
