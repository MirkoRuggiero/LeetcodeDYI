package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.base.ReturnImpl;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.interfaces.Return;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EqualPairs extends AbstractLeetcodeExercise<Integer> {

    public EqualPairs(List<ArgsAndExpected<Integer>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    @Override
    public Return<Integer> exerciseLogic(Object[] args) throws Exception {
        return equalPairs((Integer[][]) args);
    }

    public Return<Integer> equalPairs(Integer[][] grid) {
        var returnImpl = new ReturnImpl<Integer>();

        int n = grid.length;

        var rows = new ArrayList<List<Integer>>();
        for (int r = 0; r < n; r++) {
            rows.add(Arrays.asList(grid[r]));
        }

        var cols = new ArrayList<List<Integer>>();

        for (int r = 0; r < n; r++) {
            var list = new ArrayList<Integer>();
            for (int c = 0; c < n; c++) {
                list.add(grid[c][r]);
            }
            cols.add(list);
        }

        int counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (rows.get(i).equals(cols.get(j))) {
                    counter++;
                }
            }
        }

        return returnImpl.setReturnValue(counter);
    }

    public static List<ArgsAndExpected> testCases() {
        return List.of(
                new ArgsAndExpectedImpl<>(new Integer[][]{{3, 1, 2, 2}, {1, 4, 4, 4}, {2, 4, 2, 2}, {2, 5, 2, 2}}, 3),
                new ArgsAndExpectedImpl<>(new Integer[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}, 1),
                new ArgsAndExpectedImpl<>(new Integer[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}}, 3),
                new ArgsAndExpectedImpl<>(new Integer[][]{{13, 13}, {13, 13}}, 4)
        );
    }
}
