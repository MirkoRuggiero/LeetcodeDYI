package dyi.leetcode.main;

import dyi.leetcode.exercises.*;
import dyi.leetcode.interfaces.ArgsAndExpected;

import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Class<?>, List<ArgsAndExpected>> exercises = Map.of(
            CanPlaceFlowers.class, CanPlaceFlowers.testCases(),
            KidsWithCandies.class, KidsWithCandies.testCases(),
            ProductExceptSelf.class, ProductExceptSelf.testCases(),
            TwoSum.class, TwoSum.testCases(),
            ReverseWords.class, ReverseWords.testCases(),
            ReverseVowels.class, ReverseVowels.testCases()
    );

    public static void main(String[] args) {
        for (Class<?> exerciseClass : exercises.keySet()) {
            System.out.println(pad("-----------------------Running " + exerciseClass.getSimpleName()));
            try {
                java.lang.reflect.Constructor<?> constructor = exerciseClass.getDeclaredConstructors()[0];

                List<ArgsAndExpected> argsAndExpecteds = exercises.get(exerciseClass);
                constructor.newInstance(argsAndExpecteds);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static String pad(String input) {
        int a = 90 - input.length();
        StringBuilder sb = new StringBuilder();
        while (a > 0) {
            sb.append("-");
            a--;
        }
        return input + sb;
    }
}
