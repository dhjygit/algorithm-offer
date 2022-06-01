public class code_049_从根节点到叶节点的路径数字之和 {
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
        private int result;

        public int sumNumbers(TreeNode root) {
            traversal(root, 0);
            return result;
        }

        private void traversal(TreeNode node, int sum) {
            sum = sum * 10 + node.val;
            if (node.left == null && node.right == null) result += sum;
            if (node.left != null) traversal(node.left, sum);
            if (node.right != null) traversal(node.right, sum);
        }
    }
}
