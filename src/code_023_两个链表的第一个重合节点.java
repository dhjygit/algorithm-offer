import java.util.HashSet;

public class code_023_两个链表的第一个重合节点 {
    public static void main(String[] args) {
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
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            ListNode p1 = headA, p2 = headB;
            while (p1 != p2) {
                p1 = p1 == null ? headB : p1.next;
                p2 = p2 == null ? headA : p2.next;
            }
            return p1;
        }
    }

    static class Solution1 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            ListNode p1 = headA, p2 = headB;
            while (p1 != p2) {
                p1 = p1 == null ? headA : p1.next;
                p2 = p2 == null ? headB : p2.next;
            }
            return p1;
        }
    }

    static class Solution2 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            HashSet<ListNode> set = new HashSet<>();
            ListNode p1 = headA;
            ListNode p2 = headB;
            while (p1 != null) {
                set.add(p1);
                p1 = p1.next;
            }
            while (p2 != null) {
                if (set.contains(p2)) return p2;
                p2 = p2.next;
            }
            return null;
        }
    }
}
