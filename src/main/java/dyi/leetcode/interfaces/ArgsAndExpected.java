package dyi.leetcode.interfaces;

public interface ArgsAndExpected<ReturnType> {
    Object[] arguments();

    ReturnType expected();
}

