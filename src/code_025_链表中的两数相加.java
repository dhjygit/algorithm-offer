public class code_025_链表中的两数相加 {
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            ListNode p1 = l1, p2 = l2;
            while (p1 != null) {
                sb1.append(p1.val);
                p1 = p1.next;
            }
            while (p2 != null) {
                sb2.append(p2.val);
                p2 = p2.next;
            }
            int i = sb1.length() - 1;
            int j = sb2.length() - 1;
            int c = 0;
            ListNode node = null;
            while (i >= 0 || j >= 0) {
                int x = i < 0 ? 0 : sb1.charAt(i) - '0';
                int y = j < 0 ? 0 : sb2.charAt(j) - '0';
                int sum = (x + y + c) % 10;
                c = (x + y + c) / 10;
                node = new ListNode(sum, node);
                i--;
                j--;
            }
            if (c > 0) node = new ListNode(1, node);
            return node;
        }
    }
}
