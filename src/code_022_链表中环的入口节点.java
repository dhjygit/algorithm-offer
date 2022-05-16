import java.util.HashSet;

public class code_022_链表中环的入口节点 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(new Solution1().detectCycle(head).val);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) return null;
            ListNode p1 = head;
            ListNode p2 = head.next;
            while (p1 != p2) {
                if (p2 == null || p2.next == null) return null;
                p1 = p1.next;
                p2 = p2.next.next;
            }
            p1 = p1.next;
            ListNode result = head;
            while (result != p1) {
                result = result.next;
                p1 = p1.next;
            }
            return result;
        }
    }

    static class Solution1 {
        public ListNode detectCycle(ListNode head) {
            HashSet<ListNode> set = new HashSet<>();
            ListNode node = head;
            while (node != null) {
                if (set.contains(node)) return node;
                set.add(node);
                node = node.next;
            }
            return null;
        }
    }
}