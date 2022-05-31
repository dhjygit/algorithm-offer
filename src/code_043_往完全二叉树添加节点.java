import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class code_043_往完全二叉树添加节点 {
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

    static class CBTInserter {
        private final List<TreeNode> list = new ArrayList<>();

        public CBTInserter(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                list.add(node);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        public int insert(int v) {
            TreeNode newNode = new TreeNode(v);
            int index = (list.size() - 1) >> 1;
            TreeNode node = list.get(index);
            if (node.left == null) node.left = newNode;
            else node.right = newNode;
            list.add(newNode);
            return node.val;
        }

        public TreeNode get_root() {
            return list.get(0);
        }
    }
}
