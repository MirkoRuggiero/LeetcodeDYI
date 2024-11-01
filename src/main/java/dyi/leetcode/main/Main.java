package dyi.leetcode.main;

import dyi.leetcode.exercises.RPNCalculator;
import dyi.leetcode.exercises.TwinSumLinkedList;
import dyi.leetcode.interfaces.ArgsAndExpected;

import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<Class<?>, List<ArgsAndExpected>> exercises = Map.ofEntries(
//            Map.entry(CanPlaceFlowers.class, CanPlaceFlowers.testCases()),
//            Map.entry(KidsWithCandies.class, KidsWithCandies.testCases()),
//            Map.entry(ProductExceptSelf.class, ProductExceptSelf.testCases()),
//            Map.entry(TwoSum.class, TwoSum.testCases()),
//            Map.entry(ReverseWords.class, ReverseWords.testCases()),
//            Map.entry(ReverseVowels.class, ReverseVowels.testCases()),
//            Map.entry(IncreasingTriplet.class, IncreasingTriplet.testCases()),
//            Map.entry(StringCompression.class, StringCompression.testCases()),
//            Map.entry(MoveZeros.class, MoveZeros.testCases()),
//            Map.entry(IsSubsequence.class, IsSubsequence.testCases()),
//            Map.entry(ContainerWithMostWater.class, ContainerWithMostWater.testCases()),
//            Map.entry(MaxOperations.class, MaxOperations.testCases()),
//            Map.entry(MaxOperationsFaster.class, MaxOperationsFaster.testCases())
//            Map.entry(HighestAltitude.class, HighestAltitude.testCases()),
//            Map.entry(PivotIndex.class, PivotIndex.testCases()),
//            Map.entry(ArrayDifference.class, ArrayDifference.testCases()),
//            Map.entry(UniqueOccurences.class, UniqueOccurences.testCases()),
//            Map.entry(CloseString.class, CloseString.testCases()),
//            Map.entry(EqualPairs.class, EqualPairs.testCases()),
//            Map.entry(Dota2Senate.class, Dota2Senate.testCases()),
//            Map.entry(DeleteMiddle.class, DeleteMiddle.testCases()),
//            Map.entry(OddEvenLinkedList.class, OddEvenLinkedList.testCases()),
//            Map.entry(MaxFreeTime.class, MaxFreeTime.testCases()),
//            Map.entry(MCD.class, MCD.testCases()),
//            Map.entry(PermutationStep.class, PermutationStep.testCases()),
//            Map.entry(HTMLParser.class, HTMLParser.testCases()),
//            Map.entry(RPNCalculator.class, RPNCalculator.testCases()),
            Map.entry(TwinSumLinkedList.class, TwinSumLinkedList.testCases())
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
