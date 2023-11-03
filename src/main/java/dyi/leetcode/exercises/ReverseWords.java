package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.utils.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWords extends AbstractLeetcodeExercise<String> {
    public ReverseWords(List<ArgsAndExpected<String>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    @Override
    public String exerciseLogic(Object[] args) {
        String s = (String) args[0];
        return reverseWords(s);
    }

    private String reverseWords(String s) {
        List<String> words = Arrays.stream(s.trim().split(" ")).filter(w -> !w.isBlank()).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder(words.getLast());
        for (int i = words.size() - 2; i >= 0; i--) {
            sb.append(" ").append(words.get(i));
        }
        return sb.toString();
    }

    public static List<ArgsAndExpected> testCases() {
        return List.of(
                new ArgsAndExpectedImpl(Utils.wrap("a good   example"), "example good a"),
                new ArgsAndExpectedImpl(Utils.wrap("hello world "), "world hello"),
                new ArgsAndExpectedImpl(Utils.wrap("the pen      is on the table"), "table the on is pen the")
        );
    }
}
