package tk;

import commom.ListNode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author t.k
 * @date 2021/11/8 19:54
 */
public class PalindromeLinkedList_234 {

    public boolean isPalindrome(ListNode head) {
        StringBuilder node = new StringBuilder();
        while (head != null) {
            node.append(head.val);
            head = head.next;
        }
        IntStream intStream = node.chars();
        List<Integer> collect = intStream.boxed().collect(Collectors.toList());

//        char[] chars = node.toString().toCharArray();
        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).equals(collect.get(collect.size() - 1 - i))) {
                continue;
            }
            return false;
        }
        return true;
    }
}
