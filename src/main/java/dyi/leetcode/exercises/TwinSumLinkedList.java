package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.base.ReturnImpl;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.interfaces.Return;
import dyi.leetcode.utils.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwinSumLinkedList extends AbstractLeetcodeExercise<Integer> {
    public TwinSumLinkedList(List<ArgsAndExpected<Integer>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    @Override
    public Return<Integer> exerciseLogic(Object[] args) throws Exception {
        return new ReturnImpl<>(twinSum((ListNode) args[0]));
    }

    private int twinSum(ListNode head) {

        int n = 1;
        ListNode it = head;
        while (it.next != null) {
            n++;
            it = it.next;
        }

        Map<Integer, Integer> map = new HashMap<>();

        it = head;
        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                map.put(i, it.val);
            } else {
                int k = n - 1 - i;
                Integer firstTwin = map.get(k);
                int twinSum = firstTwin + it.val;
                map.put(k, twinSum);
            }
            it = it.next;
        }

        return map.values().stream().max(Integer::compareTo).get();
    }

    public static List<ArgsAndExpected> testCases() {
        ListNode head = new ListNode();
        head.val = 5;
        ListNode second = new ListNode();
        second.val = 4;
        head.next = second;
        ListNode third = new ListNode();
        third.val = 2;
        second.next = third;
        ListNode fourth = new ListNode();
        fourth.val = 1;
        third.next = fourth;

        return List.of(
                new ArgsAndExpectedImpl(Utils.wrap(head), 6)
        );
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
