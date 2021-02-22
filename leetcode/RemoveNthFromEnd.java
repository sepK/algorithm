/**
 * @author t.k
 * @date 2020/7/9 15:34
 */
public class RemoveNthFromEnd {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode header = new ListNode(0);
        header.next = head;
        ListNode fast = header;
        ListNode slow = header;
        for (int t = 0; t <= n;t++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return header.next;
    }

    public static void main(String[] args) {
        ListNode header = new ListNode(1);
        ListNode s = new ListNode(2);
        ListNode t = new ListNode(3);
        ListNode f = new ListNode(4);
        ListNode e = new ListNode(5);


        header.next = s;
        s.next = t;
        t.next = f;
        f.next = e;

        removeNthFromEnd(header, 2);
    }

}
