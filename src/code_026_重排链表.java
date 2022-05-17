import java.util.ArrayList;
import java.util.List;

public class code_026_重排链表 {
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
        public void reorderList(ListNode head) {
            List<ListNode> list = new ArrayList<>();
            ListNode p = head;
            while (p != null) {
                list.add(p);
                p = p.next;
            }
            int i = 0;
            int j = list.size() - 1;
            ListNode cur = head;
            while (i <= j) {
                if (i == j) {
                    ListNode node = list.get(i);
                    cur.next = node;
                    node.next = null;
                    break;
                }
                ListNode node1 = list.get(i);
                ListNode node2 = list.get(j);
                cur.next = node1;
                node1.next = node2;
                node2.next = null;
                cur = node2;
                i++;
                j--;
            }
            head = head.next;
        }
    }
}
