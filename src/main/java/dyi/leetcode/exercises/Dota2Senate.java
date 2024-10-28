package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.base.ReturnImpl;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.interfaces.Return;
import dyi.leetcode.utils.Utils;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Dota2Senate extends AbstractLeetcodeExercise<String> {

    public Dota2Senate(List<ArgsAndExpected<String>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    @Override
    public Return<String> exerciseLogic(Object[] args) throws Exception {
        return predictPartyVictory((String) args[0]);
    }

    public Return<String> predictPartyVictory(String senate) {
        var ret = new ReturnImpl<String>();
        Queue<Integer> queueR = new ArrayDeque<>();
        Queue<Integer> queueD = new ArrayDeque<>();

        char[] charArray = senate.toCharArray();
        int n = charArray.length;

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'R') {
                queueR.add(i);
            } else if (charArray[i] == 'D') {
                queueD.add(i);
            }
        }

        while (!queueR.isEmpty() && !queueD.isEmpty()) {
            int r = queueR.peek();
            int d = queueD.peek();

            if (r < d) {
                queueD.poll();
                queueR.poll();
                queueR.add(n++);
            } else {
                queueR.poll();
                queueD.poll();
                queueD.add(n++);
            }
        }

        if (queueD.isEmpty()) {
            ret.setReturnValue("Radiant");
        }

        if (queueR.isEmpty()) {
            ret.setReturnValue("Dire");
        }

        return ret;
    }

    public static List<ArgsAndExpected> testCases() {
        return List.of(
                new ArgsAndExpectedImpl<>(Utils.wrap("RDD"), "Dire"),
                new ArgsAndExpectedImpl<>(Utils.wrap("RD"), "Radiant"),
                new ArgsAndExpectedImpl<>(Utils.wrap("DDRRR"), "Dire")
        );
    }
}
