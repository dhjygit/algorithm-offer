import java.util.ArrayList;

public class code_027_回文链表 {
    public static void main(String[] args) {
    }

    static public class ListNode {
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
        public boolean isPalindrome(ListNode head) {
            ArrayList<ListNode> list = new ArrayList<>();
            ListNode p = head;
            while (p != null) {
                list.add(p);
                p = p.next;
            }
            int l = 0;
            int r = list.size() - 1;
            while (l < r) {
                if (list.get(l).val != list.get(r).val) return false;
                l++;
                r--;
            }
            return true;
        }
    }

    static class Solution1 {
        private ListNode front;

        public boolean isPalindrome(ListNode head) {
            this.front = head;
            return checkRecursive(head);
        }

        private boolean checkRecursive(ListNode node) {
            if (node == null) return true;
            if (checkRecursive(node.next) && front.val == node.val) {
                front = front.next;
                return true;
            }
            return false;
        }
    }
}
