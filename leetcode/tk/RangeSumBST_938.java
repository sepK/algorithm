package tk;

import commom.TreeNode;

import java.util.Stack;

/**
 * @author t.k
 * @date 2021/4/27 9:43
 */
public class RangeSumBST_938 {

    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (root.val < low) {
                    // do nothing
                } else if (root.val <= high) {
                    sum += root.val;
                } else {
                    break;
                }
                root = root.right;
            }
        }
        return sum;
    }

}
