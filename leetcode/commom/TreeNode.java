package commom;

import java.util.Stack;

/**
 * @author t.k
 * @date 2021/4/13 14:56
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 先序递归遍历二叉树
     */
    public void preOrderTraver(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        if (node.left != null) {
            preOrderTraver(node.left);
        }
        if (node.right != null) {
            preOrderTraver(node.right);
        }
    }

    /**
     * 中序递归遍历二叉树
     */
    public void InOrderTraver(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            InOrderTraver(node.left);
        }
        System.out.println(node.val);
        if (node.right != null) {
            InOrderTraver(node.right);
        }
    }

    /**
     * 后序递归遍历二叉树
     */
    public void afterOrderTraver(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            afterOrderTraver(node.left);
        }
        if (node.right != null) {
            afterOrderTraver(node.right);
        }
        System.out.println(node.val);
    }

    //非递归先序遍历二叉树
    public void pOrderTraver(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.peek();
            System.out.println(treeNode.val);
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
    }

    //非递归中序遍历二叉树
    public void iOrderTraver(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.val + " ");
                head = head.right;
            }
        }
    }

}
