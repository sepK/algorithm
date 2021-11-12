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
}
