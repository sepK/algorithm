package tk.problem;

import commom.TreeNode;

/**
 * @author t.k
 * @date 2021/4/13 14:56
 */
public class MinDiffInBST_783 {

    static int finalMin = Integer.MAX_VALUE;
    static int pre = Integer.MIN_VALUE;
    public static int minDiffInBST(TreeNode root) {
        inTravelTree(root);
        return finalMin;
    }

    public static void inTravelTree(TreeNode root) {
        if (root == null) {
            return;
        }
        inTravelTree(root.left);
        if (pre != Integer.MIN_VALUE) {
            finalMin = Math.min(Math.abs(root.val - pre), finalMin);
        }
        pre = root.val;
        inTravelTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode r1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(6);
        TreeNode r3 = new TreeNode(1);
        TreeNode r4 = new TreeNode(3);
        minDiffInBST(root);
    }
}
