package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.base.TimedReturnImpl;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.interfaces.Return;
import dyi.leetcode.utils.Utils;

import java.util.List;

public class ContainerWithMostWater extends AbstractLeetcodeExercise<Integer> {

    public ContainerWithMostWater(List<ArgsAndExpected<Integer>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    public Return<Integer> maxArea(Integer[] height) {
        TimedReturnImpl<Integer> timedReturn = new TimedReturnImpl<>();
        timedReturn.start();

        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            int area = h * w;
            System.out.printf("idx1 and idx2 [%d, %d]%n", left, right);
            System.out.printf("h1 and h2 [%d, %d]%n", height[left], height[right]);
            System.out.printf("Container volume: %d * %d = %d%n", Math.min(height[left], height[right]), w, area);
            max = Math.max(max, area);

            if (height[left] < height[right]) left++;
            else if (height[left] >= height[right]) right--;
        }

        timedReturn.setReturnValue(max);
        return timedReturn.stop();
    }

    @Override
    public Return<Integer> exerciseLogic(Object[] args) throws Exception {
        Integer[] heights = (Integer[]) args;
        return maxArea(heights);
    }

    public static List<ArgsAndExpected> testCases() {
        return List.of(
                new ArgsAndExpectedImpl<>(
                        Utils.wrap(new Integer[]{1, 8, 6, 2, 5, 4, 8, 3, 7}),
                        49)
        );
    }
}
