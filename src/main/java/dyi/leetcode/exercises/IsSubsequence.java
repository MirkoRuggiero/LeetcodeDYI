package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.base.TimedReturn;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.interfaces.Return;
import dyi.leetcode.utils.Utils;

import java.util.List;

public class IsSubsequence extends AbstractLeetcodeExercise<Boolean> {

    public IsSubsequence(List<ArgsAndExpected<Boolean>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    @Override
    public Return<Boolean> exerciseLogic(Object[] args) throws Exception {
        String s = (String) args[0];

        String t = (String) args[1];

        return isSubsequence(s, t);
    }

    public Return<Boolean> isSubsequence(String s, String t) {
        TimedReturn<Boolean> timedReturn = new TimedReturn<>();
        timedReturn.start();

        int currentIndex = -1;

        for (char sChar : s.toCharArray()) {
            currentIndex = findCharInStringStartingFromPosition(sChar, t, currentIndex);
            if (currentIndex == -1) {
                timedReturn.setReturnValue(false);
                return timedReturn.stop();
            }
        }
        timedReturn.setReturnValue(true);
        return timedReturn.stop();
    }

    private int findCharInStringStartingFromPosition(char sChar, String t, int currentIndex) {
        if (currentIndex == -1) {
            return t.indexOf(sChar);
        }
        for (int i = currentIndex + 1; i < t.length(); i++) {
            if (t.charAt(i) == sChar) {
                return i;
            }
        }
        return -1;
    }

    public static List<ArgsAndExpected> testCases() {
        return List.of(
                new ArgsAndExpectedImpl<>(
                        Utils.wrap("abc", "ahbgdc"),
                        true),
                new ArgsAndExpectedImpl<>(
                        Utils.wrap("axc", "ahbgdc"),
                        false),
                new ArgsAndExpectedImpl<>(
                        Utils.wrap("acb", "ahbgdc"),
                        false),
                new ArgsAndExpectedImpl<>(
                        Utils.wrap("ab", "baab"),
                        true));
    }
}
