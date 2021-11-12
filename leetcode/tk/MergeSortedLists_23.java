package tk;

import commom.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author t.k
 * @date 2021/11/6 9:56
 */
public class MergeSortedLists_23 {
    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * <p>
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < lists.length; i++) {
            ListNode list = lists[i];
            ListNode head = list;
            while (head != null) {
                queue.add(head);
                head = head.next;
            }
        }
        ListNode head = new ListNode();
        ListNode dummyNode = head;
        while (queue.peek() != null) {
            System.out.println(queue.peek());
            head.next = queue.poll();
            head = head.next;
        }
        return dummyNode.next;
    }
}
