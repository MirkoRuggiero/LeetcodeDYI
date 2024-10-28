package dyi.leetcode.exercises;

import java.util.Stack;

public class LargestArea { //TODO convert to leetcode exercise
    public static int arrayChallenge(int[] heights) {
        // Stack to store indices of the bars
        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;
        int index = 0;

        // Traverse the array
        while (index < heights.length) {
            // If the current bar is higher than the bar at stack's top or stack is empty, push it to the stack
            if (stack.isEmpty() || heights[index] >= heights[stack.peek()]) {
                stack.push(index++);
            } else {
                // Pop the top bar and calculate the area
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? index : index - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
        }

        // Now pop the remaining bars in the stack and calculate the area for each
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? index : index - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] bars = {2, 1, 3, 4, 1};
        System.out.println("The largest area is: " + arrayChallenge(bars));
    }
}
