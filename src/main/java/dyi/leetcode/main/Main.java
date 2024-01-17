package dyi.leetcode.main;

import dyi.leetcode.exercises.*;
import dyi.leetcode.interfaces.ArgsAndExpected;

import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<Class<?>, List<ArgsAndExpected>> exercises = Map.ofEntries(
            Map.entry(CanPlaceFlowers.class, CanPlaceFlowers.testCases()),
            Map.entry(KidsWithCandies.class, KidsWithCandies.testCases()),
            Map.entry(ProductExceptSelf.class, ProductExceptSelf.testCases()),
            Map.entry(TwoSum.class, TwoSum.testCases()),
            Map.entry(ReverseWords.class, ReverseWords.testCases()),
            Map.entry(ReverseVowels.class, ReverseVowels.testCases()),
            Map.entry(IncreasingTriplet.class, IncreasingTriplet.testCases()),
            Map.entry(StringCompression.class, StringCompression.testCases()),
            Map.entry(MoveZeros.class, MoveZeros.testCases()),
            Map.entry(IsSubsequence.class, IsSubsequence.testCases()),
            Map.entry(ContainerWithMostWater.class, ContainerWithMostWater.testCases()),
            Map.entry(MaxOperations.class, MaxOperations.testCases()),
            Map.entry(MaxOperationsFaster.class, MaxOperationsFaster.testCases())
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
