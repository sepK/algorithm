package tk.problem;

import commom.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t.k
 * @date 2021/4/21 14:48
 */
public class InorderTraversal_94 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        InOrderTraver(root, result);
        return result;
    }

    public static void InOrderTraver(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            InOrderTraver(node.left, result);
        }
        result.add(node.val);
        if (node.right != null) {
            InOrderTraver(node.right, result);
        }
    }
}
