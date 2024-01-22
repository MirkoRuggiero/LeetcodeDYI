package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.base.TimedReturnImpl;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.interfaces.Return;
import dyi.leetcode.utils.Utils;

import java.util.Arrays;
import java.util.List;

public class ReverseWords extends AbstractLeetcodeExercise<String> {
    public ReverseWords(List<ArgsAndExpected<String>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    @Override
    public Return<String> exerciseLogic(Object[] args) {
        String s = (String) args[0];
        return reverseWords(s);
    }

    private Return<String> reverseWords(String s) {
        TimedReturnImpl<String> timedReturn = new TimedReturnImpl<>();
        timedReturn.start();

        List<String> words = Arrays.stream(s.trim().split(" ")).filter(w -> !w.isBlank()).toList();
        StringBuilder sb = new StringBuilder(words.getLast());
        for (int i = words.size() - 2; i >= 0; i--) {
            sb.append(" ").append(words.get(i));
        }
        timedReturn.setReturnValue(new String(sb.toString()));
        return timedReturn.stop();
    }

    public static List<ArgsAndExpected> testCases() {
        return List.of(
                new ArgsAndExpectedImpl(Utils.wrap("a good   example"), "example good a"),
                new ArgsAndExpectedImpl(Utils.wrap("hello world "), "world hello"),
                new ArgsAndExpectedImpl(Utils.wrap("the pen      is on the table"), "table the on is pen the")
        );
    }
}
