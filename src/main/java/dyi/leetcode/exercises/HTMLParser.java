package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.base.ReturnImpl;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.interfaces.Return;
import dyi.leetcode.utils.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class HTMLParser extends AbstractLeetcodeExercise<String> {

    public HTMLParser(List<ArgsAndExpected<String>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    @Override
    public Return<String> exerciseLogic(Object[] args) throws Exception {
        return new ReturnImpl<>(htmlParser((String) args[0]));
    }

    private String htmlParser(String input) {
        Stack<String> stack = new Stack<>();

        List<String[]> tags = Arrays.stream(input.split("<"))
                .map(s -> s.split(">"))
                .filter(arr -> !Arrays.stream(arr).allMatch(String::isBlank))
                .toList();

        for (String[] element : tags) {
            if (!element[0].startsWith("/")) {
                stack.push(element[0]);
            } else {
                if (stack.isEmpty()) {
                    return element[0].substring(1); //return unopened tag
                }
                String lastOpenedTag = stack.pop();
                if (!lastOpenedTag.equals(element[0].substring(1))) {
                    return lastOpenedTag;
                }
            }
        }

        return stack.isEmpty() ? "true" : stack.pop(); //return true or unclosed tag
    }

    public static List<ArgsAndExpected> testCases() {
        return List.of(
                new ArgsAndExpectedImpl<>(Utils.wrap("<div><b><p>hello world</p></b></div>"), "true"),
                new ArgsAndExpectedImpl<>(Utils.wrap("<div><div><b></b></div></p>"), "div"),
                new ArgsAndExpectedImpl<>(Utils.wrap("<div><b></b>"), "div"),
                new ArgsAndExpectedImpl<>(Utils.wrap("</div>"), "div")
        );
    }
}
