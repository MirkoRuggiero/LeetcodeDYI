package dyi.leetcode.base;

import dyi.leetcode.interfaces.Return;

public class ReturnImpl<ReturnType> implements Return<ReturnType> {

    private ReturnType value;

    public ReturnImpl() {
    }

    public ReturnImpl(ReturnType value) {
        this.value = value;
    }

    @Override
    public Return<ReturnType> setReturnValue(ReturnType value) {
        this.value = value;
        return this;
    }

    @Override
    public ReturnType getReturnValue() {
        return value;
    }

    @Override
    public Class<?> getReturnType() {
        return value.getClass();
    }
}
