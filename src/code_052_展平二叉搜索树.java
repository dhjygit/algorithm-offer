public class code_052_展平二叉搜索树 {
    public static void main(String[] args) {
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        private final TreeNode head = new TreeNode();
        private TreeNode cur = head;

        public TreeNode increasingBST(TreeNode root) {
            traversal(root);
            return head.right;
        }

        private void traversal(TreeNode node) {
            if (node.left != null) traversal(node.left);
            node.left = null;
            cur.right = node;
            cur = node;
            if (node.right != null) traversal(node.right);
        }
    }
}
