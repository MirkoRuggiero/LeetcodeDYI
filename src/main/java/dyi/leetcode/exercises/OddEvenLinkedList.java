package dyi.leetcode.exercises;

import dyi.leetcode.base.AbstractLeetcodeExercise;
import dyi.leetcode.base.ArgsAndExpectedImpl;
import dyi.leetcode.base.ReturnImpl;
import dyi.leetcode.interfaces.ArgsAndExpected;
import dyi.leetcode.interfaces.Return;
import dyi.leetcode.utils.Utils;

import java.util.List;

public class OddEvenLinkedList extends AbstractLeetcodeExercise<OddEvenLinkedList.ListNode> {

    public OddEvenLinkedList(List<ArgsAndExpected<OddEvenLinkedList.ListNode>> argsAndExpecteds) throws Exception {
        super(argsAndExpecteds);
    }

    @Override
    public Return<OddEvenLinkedList.ListNode> exerciseLogic(Object[] args) throws Exception {
        return oddEvenList((OddEvenLinkedList.ListNode) args[0]);
    }


    public ReturnImpl<ListNode> oddEvenList(ListNode head) {
        if (head == null) {
            return new ReturnImpl<>(head);
        }
        if (head.next == null) {
            return new ReturnImpl<>(head);
        }

        int i = 1;

        ListNode itOdd = head;
        ListNode itEven = head.next;

        while (itOdd.next != null) {
            if (itOdd.next != null && itOdd.next.next != null) {
                itOdd.next = itOdd.next.next;
                itOdd = itOdd.next;
            }
        }

        while (itEven.next != null) {
            if (itEven.next != null && itEven.next.next != null) {
                itEven.next = itEven.next.next;
                itEven = itEven.next;
            }
        }

        return new ReturnImpl<>(head);
    }

    public static List<ArgsAndExpected> testCases() {
        OddEvenLinkedList.ListNode head = new OddEvenLinkedList.ListNode();
        head.val = 2;
        OddEvenLinkedList.ListNode second = new OddEvenLinkedList.ListNode();
        second.val = 1;
        OddEvenLinkedList.ListNode third = new OddEvenLinkedList.ListNode();
        third.val = 3;
        OddEvenLinkedList.ListNode fourth = new OddEvenLinkedList.ListNode();
        fourth.val = 5;
        OddEvenLinkedList.ListNode fifth = new OddEvenLinkedList.ListNode();
        fifth.val = 6;
        OddEvenLinkedList.ListNode sixth = new OddEvenLinkedList.ListNode();
        sixth.val = 4;
        OddEvenLinkedList.ListNode seventh = new OddEvenLinkedList.ListNode();
        seventh.val = 7;

        sixth.next = seventh;
        fifth.next = sixth;
        fourth.next = fifth;
        third.next = fourth;
        second.next = third;
        head.next = second;

        OddEvenLinkedList.ListNode expected = new OddEvenLinkedList.ListNode();
        expected.val = 2;
        OddEvenLinkedList.ListNode expectedsecond = new OddEvenLinkedList.ListNode();
        expectedsecond.val = 1;
        OddEvenLinkedList.ListNode expectedthird = new OddEvenLinkedList.ListNode();
        expectedthird.val = 3;
        OddEvenLinkedList.ListNode expectedfourth = new OddEvenLinkedList.ListNode();
        expectedfourth.val = 5;
        OddEvenLinkedList.ListNode expectedfifth = new OddEvenLinkedList.ListNode();
        expectedfifth.val = 6;
        OddEvenLinkedList.ListNode expectedsixth = new OddEvenLinkedList.ListNode();
        expectedsixth.val = 4;
        OddEvenLinkedList.ListNode expectedseventh = new OddEvenLinkedList.ListNode();
        expectedseventh.val = 7;

        expectedsixth.next = expectedseventh;
        expectedfifth.next = expectedsixth;
        expectedfourth.next = expectedfifth;
        expectedthird.next = expectedfourth;
        expectedsecond.next = expectedthird;
        expected.next = expectedsecond;

        return List.of(
                new ArgsAndExpectedImpl<>(Utils.wrap(head), expected)
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
