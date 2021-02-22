package tk;

/**
 * @author t.k
 * @date 2020/7/8 19:43
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        int point = 0;
        ListNode cur = listNode;
        while (l1 != null || l2 != null ) {
            int sum = point;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(sum % 10);
            point = sum / 10;
            cur = cur.next;
        }
        if (point > 0) {
            cur.next = new ListNode(point);
        }
        return listNode.next;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }
}
