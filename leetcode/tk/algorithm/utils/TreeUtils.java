package tk.algorithm.utils;

import commom.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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
     * 先序遍历
     * @param head
     */
    public static void preTravelTree(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + "\t");
        preTravelTree(head.left);
        preTravelTree(head.right);
    }

    /**
     * 中序遍历
     * @param head
     */
    public static void inTravelTree(TreeNode head) {
        if (head == null) {
            return;
        }
        inTravelTree(head.left);
        System.out.print(head.val + "\t");
        inTravelTree(head.right);
    }

    /**
     * 后序遍历
     * @param head
     */
    public static void afterTravelTree(TreeNode head) {
        if (head == null) {
            return;
        }
        afterTravelTree(head.left);
        afterTravelTree(head.right);
        System.out.print(head.val + " \t");
    }

    public static void main(String[] args) {
        //最大测试容量
        int maxSize = 7;
        //最大测试数据
        int maxNum = 20;
        int[] arr1 = ArrayLogarithmGeneratorUtils.generateRandomArray(maxSize, maxNum);
        TreeNode treeNode = toTree(arr1);
        Utils.printArray(arr1);
        afterTravelTree(treeNode);
        System.out.println();
    }
}
