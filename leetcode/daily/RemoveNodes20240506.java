package leetcode.daily;

import java.util.Stack;

public class RemoveNodes20240506 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNodes(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode current = head;
        Stack<ListNode> stack = new Stack<>();

        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        current = stack.pop();
        while (!stack.empty()) {
            ListNode node = stack.pop();
            if (current.val <= node.val) {
                current = new ListNode(node.val, current);
            }
        }

        return current;
    }
}
