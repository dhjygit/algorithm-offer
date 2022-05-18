public class code_029_排序的循环链表 {
    public static void main(String[] args) {
    }

    static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    static class Solution {
        public Node insert(Node head, int insertVal) {
            Node node = new Node(insertVal);
            node.next = node;
            if (head == null) return node;
            Node pre = head;
            Node cur = head.next;
            while (cur != head) {
                if (pre.val > cur.val && insertVal >= pre.val || pre.val > cur.val && insertVal <= cur.val) break;
                if (insertVal >= pre.val && insertVal <= cur.val) break;
                pre = cur;
                cur = cur.next;
            }
            node.next = cur;
            pre.next = node;
            return head;
        }
    }
}
