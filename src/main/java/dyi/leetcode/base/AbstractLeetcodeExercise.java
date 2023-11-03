package dyi.leetcode.base;


import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.interfaces.LeetcodeExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class AbstractLeetcodeExercise<ReturnType> implements LeetcodeExercise<ReturnType> {

    private final List<ArgsAndExpected<ReturnType>> argsAndExpecteds;

    public AbstractLeetcodeExercise(List<ArgsAndExpected<ReturnType>> argsAndExpecteds) throws Exception {
        this.argsAndExpecteds = argsAndExpecteds;
        ReturnType[] results = runExercise();

        for (int i = 0; i < results.length; i++) {
            ArgsAndExpected<ReturnType> argsAndExpected = argsAndExpecteds.get(i);
            System.out.printf("Test case %d: %s %n", i, Arrays.deepToString(argsAndExpected.arguments()));
            ReturnType result = results[i];
            Object expected = argsAndExpected.expected();
            boolean success;
            if (result instanceof Object[] resultArray) {
                success = Arrays.equals(resultArray, (Object[]) expected);
            } else {
                success = Objects.equals(result, expected);
            }

            String resultString = result instanceof Object[] ? Arrays.deepToString((Object[]) result) : result.toString();
            String expectedString = expected instanceof Object[] ? Arrays.deepToString((Object[]) expected) : expected.toString();
            System.out.printf(((success ? "Passed! " : "Failed! ") + String.format("Got %s as result", resultString)));
            if (!success) System.out.printf(", while %s was expected%n", expectedString);
            System.out.printf("%n%n");
        }
    }


    private ReturnType[] runExercise() throws Exception {
        Object[] results = new Object[argsAndExpecteds.size()];
        for (int i = 0; i < argsAndExpecteds.size(); i++) {
            results[i] = exerciseLogic(argsAndExpecteds.get(i).arguments());
        }
        return (ReturnType[]) results;
    }
}
