public class code_024_反转链表 {
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
        public ListNode reverseList(ListNode head) {
            ListNode newHead = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode temp = cur.next;
                cur.next = newHead;
                newHead = cur;
                cur = temp;
            }
            return newHead;
        }
    }

    static class Solution1 {
        public ListNode reverseList(ListNode head) {
            ListNode dummyNode = new ListNode();
            ListNode p = head;
            ListNode temp = p;
            while (p != null) {
                temp = p.next;
                p.next = dummyNode.next;
                dummyNode.next = p;
                p = temp;
            }
            return dummyNode.next;
        }
    }
}
