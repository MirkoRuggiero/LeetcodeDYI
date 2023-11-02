package dyi.leetcode.base;


import dyi.leetcode.interfaces.ArgsAndExpected;

public class ArgsAndExpectedImpl<ReturnType> implements ArgsAndExpected<ReturnType> {
    private final Object[] arguments;
    private final ReturnType expected;

    public ArgsAndExpectedImpl(Object[] arguments, ReturnType expected) {
        this.arguments = arguments;
        this.expected = expected;
    }

    @Override
    public Object[] arguments() {
        return arguments;
    }

    @Override
    public ReturnType expected() {
        return expected;
    }
}
