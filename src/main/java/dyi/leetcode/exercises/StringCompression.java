package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.base.TimedReturnImpl;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.interfaces.Return;
import dyi.leetcode.utils.Utils;

import java.util.*;

public class StringCompression extends AbstractLeetcodeExercise<Integer> {
    //    Given an array of characters chars, compress it using the following algorithm:
//
//    Begin with an empty string s. For each group of consecutive repeating characters in chars:
//
//    If the group's length is 1, append the character to s.
//    Otherwise, append the character followed by the group's length.
//    The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
//
//    After you are done modifying the input array, return the new length of the array.
//
//    You must write an algorithm that uses only constant extra space.
//
//
//
//            Example 1:
//
//    Input: chars = ['a','a','b','b','c','c','c']
//    Output: Return 6, and the first 6 characters of the input array should be: ['a','2','b','2','c','3']
//    Explanation: The groups are 'aa', 'bb', and 'ccc'. This compresses to 'a2b2c3'.
//    Example 2:
//
//    Input: chars = ['a']
//    Output: Return 1, and the first character of the input array should be: ['a']
//    Explanation: The only group is 'a', which remains uncompressed since it's a single character.
//    Example 3:
//
//    Input: chars = ['a','b','b','b','b','b','b','b','b','b','b','b','b']
//    Output: Return 4, and the first 4 characters of the input array should be: ['a','b','1','2'].
//    Explanation: The groups are 'a' and 'bbbbbbbbbbbb'. This compresses to 'ab12'.
    public StringCompression(List<ArgsAndExpected<Integer>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    @Override
    public Return<Integer> exerciseLogic(Object[] args) throws Exception {
        char[] chars = new char[args.length];

        for (int i = 0; i < args.length; i++) {
            chars[i] = (Character) args[i];
        }
        return compress(chars);
    }

    private Return<Integer> compress(char[] chars) {
        TimedReturnImpl<Integer> timedReturn = new TimedReturnImpl<>();
        timedReturn.start();

        Map<Character, Integer> occurrences = new HashMap<>();
        for (Character c : chars) {
            if (occurrences.containsKey(c)) {
                occurrences.put(c, occurrences.get(c) + 1);
            } else {
                occurrences.put(c, 1);
            }
        }
        int count = 0;

        List<Character> charsList = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : occurrences.entrySet()) {
            if (entry.getValue() == 1) {
                charsList.add(count, entry.getKey());
                count++;
            } else {
                charsList.add(count, entry.getKey());
                int digitCount = 1;
                char[] digits = Integer.toString(entry.getValue()).toCharArray();
                for (char digit : digits) {
                    charsList.add(count + digitCount, digit);
                    digitCount++;
                }
                count += digitCount;
            }
        }
        for (int i = 0; i < charsList.size(); i++) {
            chars[i] = charsList.get(i);
        }
        if (chars.length > charsList.size()) {
            char[] newArray = new char[charsList.size()];
            System.arraycopy(chars, 0, newArray, 0, charsList.size());
            chars = newArray;
        }
        System.out.println(Arrays.toString(chars));
        timedReturn.setReturnValue(charsList.size());
        return timedReturn.stop();
    }

    public static List<ArgsAndExpected> testCases() {
        return List.of(
                new ArgsAndExpectedImpl(Utils.wrap(new Character[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}), 6),
                new ArgsAndExpectedImpl(Utils.wrap(new Character[]{'a'}), 1),
                new ArgsAndExpectedImpl(Utils.wrap(new Character[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}), 4)
        );
    }
}
