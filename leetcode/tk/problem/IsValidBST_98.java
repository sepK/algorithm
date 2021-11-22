package tk.problem;

import commom.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t.k
 * @date 2021/4/25 19:54
 */
public class IsValidBST_98 {
    public static boolean isValidBST(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        orderTraver(root, result);
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i) <= result.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void orderTraver(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            orderTraver(root.left, result);
        }
        result.add(root.val);
        if (root.right != null) {
            orderTraver(root.right, result);
        }
    }
}
