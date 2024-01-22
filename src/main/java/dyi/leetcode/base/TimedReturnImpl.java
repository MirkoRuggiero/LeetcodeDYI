package dyi.leetcode.base;

import com.google.common.base.Stopwatch;
import dyi.leetcode.interfaces.Return.TimedReturn;

public class TimedReturnImpl<ReturnType> implements TimedReturn<ReturnType> {

    private ReturnType value;
    private final Stopwatch sw;

    public TimedReturnImpl(ReturnType value) {
        this.value = value;
        this.sw = Stopwatch.createUnstarted();
    }

    public TimedReturnImpl() {
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
    public TimedReturnImpl<ReturnType> stop() {
        if (sw.isRunning()) {
            sw.stop();
        }
        return this;
    }
}