package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.base.ReturnImpl;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.interfaces.Return;
import dyi.leetcode.utils.Utils;

import java.util.List;
import java.util.Objects;

public class DeleteMiddle extends AbstractLeetcodeExercise<DeleteMiddle.ListNode> {

    public DeleteMiddle(List<ArgsAndExpected<ListNode>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    @Override
    public Return<ListNode> exerciseLogic(Object[] args) throws Exception {
        return deleteMiddle((ListNode) args[0]);
    }

    public Return<ListNode> deleteMiddle(ListNode head) {
        if (head.next == null) {
            return new ReturnImpl<>(null);
        }
        int c = 1;
        ListNode it = head;
        while (it.next != null) {
            c++;
            it = it.next;
        }

        int m = (c / 2) - 1;

        it = head;

        while (it.next != null) {
            if (m == 0) {
                //swap
                it.next = it.next.next;
                break;
            }
            m--;
            it = it.next;
        }
        return new ReturnImpl<>(head);
    }

    public static List<ArgsAndExpected> testCases() {
        ListNode head = new ListNode();
        head.val = 2;
        ListNode second = new ListNode();
        second.val = 1;
        head.next = second;

        ListNode expected = new ListNode();
        expected.val = 2;
        //--------------------------------------------------------------------------------------------------------------
        ListNode one = new ListNode();
        one.val = 1;
        ListNode two = new ListNode();
        two.val = 2;
        ListNode three = new ListNode();
        three.val = 3;
        ListNode four = new ListNode();
        four.val = 4;

        three.next = four;
        two.next = three;
        one.next = two;

        ListNode expectedOne = new ListNode();
        expectedOne.val = 1;
        ListNode expectedTwo = new ListNode();
        expectedTwo.val = 2;
        ListNode expectedThree = new ListNode();
        expectedThree.val = 4;

        expectedTwo.next = expectedThree;
        expectedOne.next = expectedTwo;
        //--------------------------------------------------------------------------------------------------------------

        return List.of(
                new ArgsAndExpectedImpl<>(Utils.wrap(head), expected),
                new ArgsAndExpectedImpl<>(Utils.wrap(one), expectedOne),
                new ArgsAndExpectedImpl<>(Utils.wrap(new ListNode(1)), null)
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return toString().equals(listNode.toString());
        }

        @Override
        public int hashCode() {
            return Objects.hash(toString());
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
