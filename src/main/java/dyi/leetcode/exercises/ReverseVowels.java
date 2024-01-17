package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.base.TimedReturn;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.interfaces.Return;
import dyi.leetcode.utils.Utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ReverseVowels extends AbstractLeetcodeExercise<String> {
    public ReverseVowels(List<ArgsAndExpected<String>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    @Override
    public Return<String> exerciseLogic(Object[] args) {
        String s = (String) args[0];
        return reverseVowels(s);
    }

    private Return<String> reverseVowels(String s) {
        TimedReturn<String> timedReturn = new TimedReturn<>();
        timedReturn.start();

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Queue<Character> vowelsFound = new LinkedList<>();
        char[] charArray = s.toCharArray();
        char[] charArrayLowerCased = s.toLowerCase().toCharArray();
        s = null;
        System.gc();
        for (int i = 0; i < charArray.length; i++) {
            if (vowels.contains(charArrayLowerCased[i])) {
                vowelsFound.add(charArray[i]);
            }
        }
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (vowels.contains(charArrayLowerCased[i])) {
                charArray[i] = vowelsFound.poll();
            }
        }
        timedReturn.setReturnValue(new String(charArray));
        return timedReturn.stop();
    }

    public static List<ArgsAndExpected> testCases() {
        return List.of(
                new ArgsAndExpectedImpl(Utils.wrap("hello"), "holle"),
                new ArgsAndExpectedImpl(Utils.wrap("leetcode"), "leotcede"),
                new ArgsAndExpectedImpl(Utils.wrap("ai"), "ia")
        );
    }
}
