package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.base.ReturnImpl;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.interfaces.Return;
import dyi.leetcode.utils.Utils;

import java.util.List;
import java.util.Stack;

public class RPNCalculator extends AbstractLeetcodeExercise<Double> {


    public RPNCalculator(List<ArgsAndExpected<Double>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    @Override
    public Return<Double> exerciseLogic(Object[] args) throws Exception {
        return new ReturnImpl<>(rpnCalculator((String[]) args));
    }

    private double rpnCalculator(String[] tokens) {
        Stack<Double> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    stack.push(stack.pop() + stack.pop());
                }
                case "-" -> {
                    double y = stack.pop();
                    double x = stack.pop();
                    stack.push(x - y);
                }
                case "*" -> {
                    stack.push(stack.pop() * stack.pop());
                }
                case "/" -> {
                    double y = stack.pop();
                    double x = stack.pop();
                    stack.push(x / y);
                }
                default -> stack.push(Double.parseDouble(token));
            }
        }
        return stack.pop();
    }

    public static List<ArgsAndExpected> testCases() {
        String[] expression1 = {"3", "4", "+", "2", "*", "7", "/"};
        String[] expression2 = {"5", "1", "2", "+", "4", "*", "+", "3", "-"};
        return List.of(
                new ArgsAndExpectedImpl<>(expression1, 2.0),
                new ArgsAndExpectedImpl<>(expression2, 14.0)
        );
    }
}
