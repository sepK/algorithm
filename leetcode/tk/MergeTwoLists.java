package tk;

/**
 * @author t.k
 * @date 2020/7/9 16:34
 */
public class MergeTwoLists{

      public class ListNode {
          int val;
          ListNode next;

          ListNode() {
          }

          ListNode(int val) {
              this.val = val;
          }

          ListNode(int val, ListNode next) {
              this.val = val;
              this.next = next;
          }
      }


        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode result = new ListNode();
            ListNode dummyNode = result;
            while (l1 != null || l2 != null) {
                if (l1 == null) {
                    result.next = new ListNode(l2.val);
                    result = result.next;
                    l2 = l2.next;
                    continue;
                }
                if (l2 == null) {
                    result.next  = new ListNode(l1.val);
                    l1 = l1.next;
                    result = result.next;
                    continue;
                }
                if (l1.val > l2.val) {
                    result.next  = new ListNode(l2.val);
                    l2 = l2.next;
                } else {
                    result.next  = new ListNode(l1.val);
                    l1 = l1.next;
                }
                result = result.next;
            }
            return dummyNode;
        }
}
