package dyi.leetcode.base;

import com.google.common.base.Stopwatch;
import dyi.leetcode.interfaces.Return;

public class TimedReturn<ReturnType> implements Return<ReturnType> {

    private ReturnType value;
    private final Stopwatch sw;

    public TimedReturn(ReturnType value) {
        this.value = value;
        this.sw = Stopwatch.createUnstarted();
    }

    public TimedReturn() {
        this.sw = Stopwatch.createUnstarted();
    }

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

    @Override
    public Stopwatch took() {
        return sw;
    }

    @Override
    public void start() {
        sw.start();
    }

    @Override
    public TimedReturn<ReturnType> stop() {
        sw.stop();
        return this;
    }
}
