import java.util.Stack;

public class code_028_展平多级双向链表 {
    public static void main(String[] args) {
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    static class Solution {
        public Node flatten(Node head) {
            if (head == null) return null;
            Node cur = head;
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                if (node != cur) {
                    cur.child = null;
                    cur.next = node;
                    node.prev = cur;
                    cur = node;
                }
                if (node.next != null) stack.push(node.next);
                if (node.child != null) stack.push(node.child);
            }
            return head;
        }
    }

    static class Solution1 {
        private Node cur;

        public Node flatten(Node head) {
            if (head == null) return null;
            cur = head;
            traversal(head);
            return head;
        }

        private void traversal(Node node) {
            Node left = node.child;
            Node right = node.next;
            if (node != cur) {
                cur.child = null;
                cur.next = node;
                node.prev = cur;
                cur = node;
            }
            if (left != null) traversal(left);
            if (right != null) traversal(right);
        }
    }
}
