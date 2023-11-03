package dyi.leetcode.interfaces;

import java.util.List;

public interface LeetcodeExercise<ReturnType> {
    ReturnType exerciseLogic(Object[] args) throws Exception;

    static <ReturnType> List<ArgsAndExpected<ReturnType>> testCases() {
        throw new UnsupportedOperationException();
    }
}
