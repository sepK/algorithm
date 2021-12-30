package tk.algorithm.utils;

import commom.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author t.k
 * @date 2021/4/15 10:34
 */
public class TreeUtils {
    /**
     * 将一个数组转为二叉树
     *
     * @param nums 传入的数组
     * @return 二叉树头结点
     */
    public static TreeNode toTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        int index = 1;
        while (index < nums.length) {
            TreeNode cur = queue.poll();
            //第一个节点不为null则放到左节点并入队
            TreeNode temp = new TreeNode(nums[index]);
            cur.left = temp;
            queue.offer(temp);
            if (++index >= nums.length) {
                break;
            }
            temp = new TreeNode(nums[index]);
            cur.right = temp;
            queue.offer(temp);
            index++;
        }
        return head;
    }

    /**
     * 左侧树枝一撸到底
     */
    private static void pushLeftBranch(TreeNode p, Stack<TreeNode> stk) {
        while (p != null) {
            //todo 前序遍历代码位置
            stk.push(p);
            p = p.left;
        }
    }

    public static List<Integer> traverse(TreeNode root) {
        // 指向上一次遍历完的子树根节点
        TreeNode visited = new TreeNode(-1);
        Stack<TreeNode> stk = new Stack<>();
        // 开始遍历整棵树
        pushLeftBranch(root, stk);

        while (!stk.isEmpty()) {
            TreeNode p = stk.peek();

            // p 的左子树被遍历完了，且右子树没有被遍历过
            if (p.left == null || p.left == visited) {
                if (p.right != visited) {
                    // todo 中序遍历代码位置
                    pushLeftBranch(p.right, stk);
                }
            }
            // p 的右子树被遍历完了
            if (p.right == null || p.right == visited) {
                // todo 后序遍历代码位置
                //以 p 为根的子树被遍历完了，出栈 visited 指针指向 p
                visited = stk.pop();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        //最大测试容量
        int maxSize = 7;
        //最大测试数据
        int maxNum = 20;
//        int[] arr = ArrayLogarithmGeneratorUtils.generateRandomArray(maxSize, maxNum);
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode treeNode = toTree(arr);
        Utils.printArray(arr);
        traverse(treeNode);
        System.out.println();
    }
}
