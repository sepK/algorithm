package tk;

import commom.TreeNode;
import tk.algorithm.utils.TreeUtils;

import java.util.Stack;

/**
 * @author t.k
 * @date 2021/4/25 10:19
 */
public class IncreasingBST_897 {

    public static TreeNode increasingBST(TreeNode root) {
        TreeNode result = new TreeNode();
        TreeNode temp = result;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                temp.right = root;
                root.left = null;
                temp = temp.right;
                root = root.right;
            }
        }
        return result.right;
    }

    //    public static void inOrderTravel(TreeNode root, TreeNode result) {
//        if (root == null) {
//            return;
//        }
//        inOrderTravel(root.left, result);
//        result = root;
//        inOrderTravel(root.right, result.right);
//    }
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.toTree(new int[]{5, 3, 6, 2, 4, 8, 1, 7, 9});

        increasingBST(treeNode);
    }
}
