package commom;

/**
 * @author t.k
 * @date 2021/4/25 15:10
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 反转区间链表 [left, right)
     *
     * @param left  左区间
     * @param right 右区间
     * @return
     */
    public ListNode reverse(ListNode left, ListNode right) {
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

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode fast = dummyNode.next;
        ListNode slow = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            fast = fast.next;
            slow = slow.next;
        }

        for (int i = 0; i < right - left; i++) {
            ListNode remove = fast.next;
            fast.next = fast.next.next;

            remove.next = slow.next;
            slow.next = remove;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;


        reverseBetween(listNode1, 2, 4);
    }

}
