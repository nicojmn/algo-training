package leetcode.daily;

import java.util.Stack;

public class DoubleNumberLL {
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

    public ListNode doubleIt(ListNode head) {
        Stack<Integer> values = new Stack<>();
        boolean carryOver = false;

        while (head != null) {
            values.push(head.val);
            head = head.next;
        }

        ListNode newHead = null;
        while (!values.empty()) {
            int doubled = values.pop() * 2;

            if (doubled < 10) {
                if (carryOver) {
                    doubled = doubled + 1;
                    carryOver = false;
                }
                newHead = new ListNode(doubled, newHead);
            } else {
                doubled = doubled % 10;
                if (carryOver) {
                    doubled = doubled + 1;
                }
                newHead = new ListNode(doubled, newHead);
                carryOver = true;
            }
        }

        if (carryOver) {
            newHead = new ListNode(1, newHead);
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(8, new ListNode(9)));
        ListNode doubledHead = new DoubleNumberLL().doubleIt(head);

        while (doubledHead != null) {
            System.out.println(doubledHead.val);
            doubledHead = doubledHead.next;
        }

        System.out.println();
        head = new ListNode(9, new ListNode(9, new ListNode(9)));
        doubledHead = new DoubleNumberLL().doubleIt(head);
        while (doubledHead != null) {
            System.out.println(doubledHead.val);
            doubledHead = doubledHead.next;
        }
    }
}

