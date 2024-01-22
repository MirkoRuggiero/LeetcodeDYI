package dyi.leetcode.base;

import com.google.common.base.Stopwatch;
import dyi.leetcode.interfaces.Return;

public class ReturnImpl<ReturnType> implements Return<ReturnType> {

    private ReturnType value;

    @Override
    public void setReturnValue(ReturnType value) {
        this.value = value;
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
