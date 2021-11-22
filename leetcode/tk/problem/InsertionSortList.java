package tk.problem;

/**
 * @author t.k
 * @date 2020/11/20 16:04
 */
public class InsertionSortList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode(0);
        ListNode node = head;
        while(node != null){
            ListNode next = node.next;
            //在排好序的链表中找到合适的位置, 插入
            ListNode prevNode = newHead;
            ListNode sortNode = newHead.next;
            while(sortNode != null){
                if(node.val > sortNode.val){
                    prevNode = sortNode;
                    sortNode = sortNode.next;
                }else{
                    break;
                }
            }
            prevNode.next = node;
            node.next = sortNode;

            node = next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        insertionSortList(n1);
    }
}
