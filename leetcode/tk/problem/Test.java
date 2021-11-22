package tk.problem;

import commom.ListNode;

/**
 * @author t.k
 * @date 2021/11/12 17:20
 */
public class Test {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode a = head;
        ListNode b = head;
        //b节点往前走k步
        for (int i = 0; i < k; i++) {
            //不足k 返回
            if (b == null) return head;
            b = b.next;
        }
        //获得反转后的新头节点
        ListNode newhead = reverse(a, b);
        //指向反转后的节点
        a.next = reverseKGroup(b, k);
        return newhead;
    }

    /**
     * 反转区间链表 [left, right)
     *
     * @param left  左区间
     * @param right 右区间
     * @return
     */
    public static ListNode reverse(ListNode left, ListNode right) {
        ListNode pre = null;
        ListNode cur = left;
        ListNode next = left;
        while (cur != right) {
            //记录cur的下个节点
            next = cur.next;
            //将cur的下个节点改为pre
            cur.next = pre;
            //将当前节点赋值给pre
            pre = cur;
            //当前节点指向下个节点
            cur = next;
        }
        return pre;
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode left = head;
        ListNode right = head;
        for (int i = 0; i < 2; i++) {
            //不足2 返回
            if (right == null) return head;
            right = right.next;
        }
        ListNode newHead = swapPari(left, right);
        left.next = swapPairs(right);
        return newHead;
    }

    public static ListNode swapPari(ListNode left, ListNode right) {
        ListNode pre = null;
        ListNode cur = left;
        ListNode next = left;
        while (cur != right) {
            //记录cur的下个节点
            next = cur.next;
            //将cur的下个节点改为pre
            cur.next = pre;
            //将当前节点赋值给pre
            pre = cur;
            //当前节点指向下个节点
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);

        ListNode node1 = new ListNode(1);

        ListNode node2 = new ListNode(2);

        ListNode node3 = new ListNode(4);

        ListNode node4 = new ListNode(5);

        ListNode node5 = new ListNode(6);


        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode node6 = swapPairs(node);

    }
}
