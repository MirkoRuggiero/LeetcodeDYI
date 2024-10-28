package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.base.ReturnImpl;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.interfaces.Return;
import dyi.leetcode.utils.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PermutationStep extends AbstractLeetcodeExercise<Integer> {

    public PermutationStep(List<ArgsAndExpected<Integer>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    @Override
    public Return<Integer> exerciseLogic(Object[] args) throws Exception {
        return new ReturnImpl<>(nextPermutation((Integer) args[0]));
    }

    private int nextPermutation(int num) {
        char[] array = Integer.toString(num).toCharArray();

        Character[] chars = new Character[array.length];
        for (int i = 0; i < array.length; i++) {
            chars[i] = array[i];
        }

        for (int i = chars.length - 1; i >= 1; i--) {
            char a = chars[i];
            char b = chars[i - 1];
            if (a > b) {
                chars[i] = b;
                chars[i - 1] = a;
                Character[] root = Arrays.copyOfRange(chars, 0, i);
                Character[] remaining = Arrays.copyOfRange(chars, i, chars.length);
                Arrays.sort(remaining);
                return Integer.parseInt(
                        Stream.concat(Arrays.stream(root), Arrays.stream(remaining))
                                .map(Object::toString)
                                .collect(Collectors.joining("")));
            }
        }
        return -1;
    }


    public static List<ArgsAndExpected> testCases() {
        return List.of(
                new ArgsAndExpectedImpl<>(Utils.wrap(Integer.valueOf(123)), Integer.valueOf(132)),
                new ArgsAndExpectedImpl<>(Utils.wrap(Integer.valueOf(11121)), Integer.valueOf(11211)),
                new ArgsAndExpectedImpl<>(Utils.wrap(Integer.valueOf(41352)), Integer.valueOf(41523)),
                new ArgsAndExpectedImpl<>(Utils.wrap(Integer.valueOf(999)), Integer.valueOf(-1))
        );
    }
}
