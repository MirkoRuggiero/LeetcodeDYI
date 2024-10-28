package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.base.ReturnImpl;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.interfaces.Return;
import dyi.leetcode.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CloseString extends AbstractLeetcodeExercise<Boolean> {

    public CloseString(List<ArgsAndExpected<Boolean>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    public Return<Boolean> closeStrings(String word1, String word2) {
        var returnImpl = new ReturnImpl<Boolean>();

        if (word1.length() != word2.length()) {
            return returnImpl.setReturnValue(false);
        }

        var charFreq1 = new HashMap<Character, Integer>();
        for (Character c : word1.toCharArray()) {
            charFreq1.put(c, charFreq1.getOrDefault(c, 0) + 1);
        }

        var charFreq2 = new HashMap<Character, Integer>();
        for (Character c : word2.toCharArray()) {
            charFreq2.put(c, charFreq2.getOrDefault(c, 0) + 1);
        }

        if (!charFreq1.keySet().equals(charFreq2.keySet())) {
            return returnImpl.setReturnValue(false);
        }

        List<Integer> frequencies1 = new ArrayList<>(charFreq1.values());
        List<Integer> frequencies2 = new ArrayList<>(charFreq2.values());

        Collections.sort(frequencies1);
        Collections.sort(frequencies2);

        if (!frequencies1.equals(frequencies2)) {
            return returnImpl.setReturnValue(false);
        }

        return returnImpl.setReturnValue(true);
    }

    @Override
    public Return<Boolean> exerciseLogic(Object[] args) throws Exception {
        return closeStrings((String) args[0], (String) args[1]);
    }

    public static List<ArgsAndExpected> testCases() {
        return List.of(
                new ArgsAndExpectedImpl<>(Utils.wrap("abc", "bca"), true),
                new ArgsAndExpectedImpl<>(Utils.wrap("aaabbbbccddeeeeefffff", "aaaaabbcccdddeeeeffff"), false),
                new ArgsAndExpectedImpl<>(Utils.wrap("cabbba", "abbccc"), true));
    }
}
