package tk;

import commom.ListNode;

/**
 * @author t.k
 * @date 2021/4/25 15:11
 */
public class MergeInBetween_1669 {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode endNode2 = list2;
        while (endNode2.next != null) {
            endNode2 = endNode2.next;
        }
        ListNode head = list1;
        ListNode startNode = list1;
        int currentIndex = 0;
        while (list1.next != null) {
            if (currentIndex == a - 1) {
                startNode = list1;
            }
            if (currentIndex == b){
                startNode.next = list2;
                endNode2.next = list1.next;
            }
            currentIndex++;
            list1 = list1.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
