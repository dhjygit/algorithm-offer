public class code_021_删除链表的倒数第n个结点 {
    public static void main(String[] args) {
    }

    static class ListNode {
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

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummyNode = new ListNode(-1);
            dummyNode.next = head;
            ListNode p1 = dummyNode;
            for (int i = 0; i < n + 1; i++) p1 = p1.next;
            ListNode p2 = dummyNode;
            while (p1 != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            p2.next = p2.next.next;
            return dummyNode.next;
        }
    }
}
