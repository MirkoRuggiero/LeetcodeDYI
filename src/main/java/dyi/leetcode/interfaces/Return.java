package dyi.leetcode.interfaces;

import com.google.common.base.Stopwatch;

import java.util.Arrays;
import java.util.Objects;

public interface Return<ReturnType> {

    Return<ReturnType> setReturnValue(ReturnType value);

    ReturnType getReturnValue();

    Class<?> getReturnType();

    default void log(Object expected) {
        boolean success;
        if (getReturnValue() instanceof Object[] resultArray) {
            success = Arrays.equals(resultArray, (Object[]) expected);
        } else {
            success = Objects.equals(getReturnValue(), expected);
        }
        String resultString = getReturnValue() instanceof Object[] ?
                Arrays.deepToString((Object[]) getReturnValue()) :
                getReturnValue() != null ? getReturnValue().toString() : "";
        String expectedString = expected instanceof Object[] ? Arrays.deepToString((Object[]) expected) :
                expected != null ? expected.toString() : "";
        System.out.printf(((success ? "Passed! " : "Failed! ") + String.format("Got %s as result", resultString)));
        if (!success) System.out.printf(", while %s was expected", expectedString);
        System.out.printf("%n%n");
    }

    interface TimedReturn<ReturnType> extends Return<ReturnType> {

        Stopwatch took();

        void start();

        Return<ReturnType> stop();

        @Override
        default void log(Object expected) {
            Return.super.log(expected);
            System.out.printf("%nTook %s%n", took());
            System.out.printf("%n%n");
        }
    }
}
