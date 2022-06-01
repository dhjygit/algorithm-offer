import java.util.HashMap;
import java.util.Map;

public class code_050_向下的路径节点之和 {
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
        private int targetSum;
        private int result;
        private Map<Integer, Integer> map;

        public int pathSum(TreeNode root, int targetSum) {
            this.targetSum = targetSum;
            this.map = new HashMap<>();
            map.put(0, 1);
            if (root == null) return 0;
            traversal(root, 0);
            return result;
        }

        private void traversal(TreeNode node, int sum) {
            sum += node.val;
            result += map.getOrDefault(sum - targetSum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            if (node.left != null) traversal(node.left, sum);
            if (node.right != null) traversal(node.right, sum);
            map.put(sum, map.get(sum) - 1);
        }
    }

    static class Solution1 {
        private int result;
        private int targetSum;

        public int pathSum(TreeNode root, int targetSum) {
            this.targetSum = targetSum;
            if (root == null) return 0;
            traversal(root);
            return result;
        }

        private void traversal(TreeNode node) {
            everyNode(node, 0);
            if (node.left != null) traversal(node.left);
            if (node.right != null) traversal(node.right);
        }

        private void everyNode(TreeNode node, int sum) {
            sum += node.val;
            if (sum == targetSum) result++;
            if (node.left != null) everyNode(node.left, sum);
            if (node.right != null) everyNode(node.right, sum);
        }
    }
}
