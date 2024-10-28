package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.base.ReturnImpl;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.interfaces.Return;

import java.util.Arrays;
import java.util.List;

public class MaxFreeTime extends AbstractLeetcodeExercise<String> {

    public MaxFreeTime(List<ArgsAndExpected<String>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    private String maxFreeTime(String[] arr) {
        List<Pair> list = Arrays.stream(arr)
                .map(s -> {
                    String[] tokens = s.split("-");
                    String start = tokens[0];
                    String end = tokens[1];

                    int startTs = convert(start);
                    int endTs = convert(end);

                    return new Pair(startTs, endTs);
                })
                .sorted().toList();


        int max = -1;

        for (int i = 0; i < list.size() - 1; i++) {

            Pair firstEvent = list.get(i);
            Pair secondEvent = list.get(i + 1);

            max = Math.max(max, secondEvent.x - firstEvent.y);
        }
        return String.format("%02d:%02d", max / 60, max % 60);
    }

    private int convert(String string) {
        if (string.contains("AM")) {
            String time = string.replace("AM", "");
            String[] hhAndMm = time.split(":");
            return (Integer.parseInt(hhAndMm[0]) * 60) + Integer.parseInt(hhAndMm[1]);
        } else if (string.contains("PM")) {
            String time = string.replace("PM", "");
            String[] hhAndMm = time.split(":");
            int hh = Integer.parseInt(hhAndMm[0]);
            if (hh != 12) {
                hh = hh + 12;
            }
            return (hh * 60) + Integer.parseInt(hhAndMm[1]);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Return<String> exerciseLogic(Object[] args) throws Exception {
        return new ReturnImpl<>(maxFreeTime((String[]) args));
    }

    public static class Pair implements Comparable<Pair> {
        public int x;
        public int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            return (this.x + "-" + this.y).compareTo(o.x + "-" + o.y);
        }
    }

    public static List<ArgsAndExpected> testCases() {
        String[] arr1 = {"12:15PM-02:00PM", "09:00AM-10:00AM", "10:30AM-12:00PM"};
        String[] arr2 = {"12:15PM-02:00PM", "09:00AM-12:11PM", "02:02PM-04:00PM"};
        return List.of(
                new ArgsAndExpectedImpl<>(arr1, "00:30"),
                new ArgsAndExpectedImpl<>(arr2, "00:04")
        );
    }
}
