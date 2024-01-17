package dyi.leetcode.interfaces;

import com.google.common.base.Stopwatch;

public interface Return<ReturnType> {

    void setReturnValue(ReturnType value);

    ReturnType getReturnValue();

    Class<?> getReturnType();

    Stopwatch took();

    void start();

    Return<ReturnType> stop();
}
