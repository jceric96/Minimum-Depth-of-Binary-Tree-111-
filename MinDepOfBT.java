import java.util.LinkedList;
import java.util.Queue;

public class MinDepOfBT {
    public int minDepth(TreeNode root) {
        int level = 1;
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                if (!queue.isEmpty()) {
                    level++;
                    queue.offer(null);
                }

            } else {
                if (current.left == null && current.right == null)
                    return level;
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
        }
        return level;
    }

    public static void main(String[] args) {
        MinDepOfBT blt = new MinDepOfBT();
        TreeNode root = new TreeNode(2);
        root.left = null;
        root.right = new TreeNode(3);
        root.right.left = null;
        root.right.right = new TreeNode(4);
        root.right.right.left = null;
        root.right.right.right = new TreeNode(5);
        root.right.right.right.left = null;
        root.right.right.right.right = new TreeNode(6);
        System.out.println(blt.minDepth(root));
    }
}
