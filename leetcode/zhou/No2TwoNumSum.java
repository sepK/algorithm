package zhou;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807
 * @author Blade
 * @date 2021/2/22 16:31
 */
public class No2TwoNumSum {
    /**
     * 思路 先把链表转数字，相加转数组，数组转回链表，但是这样做 位数不够 不如进位
     */
    /*public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int[] a =listToNum(l1);
        int[] b =listToNum(l2);
        int aA=ArrToNum(a);
        int bB =ArrToNum(b);
        int cC=aA+bB;
//      把int数字转成字符串数组
        char[] chars = String.valueOf(cC).toCharArray();
        System.out.println(chars);
        ListNode l3 = new ListNode();
        ListNode curr = l3;
        for (int i = chars.length-1; i>=0; i--) {
            l3 = l3.next = new ListNode(0);
            l3.val=chars[i];
        }
        return curr.next;
    }
    public static int listSize(ListNode listNode){
        int i=0;
        while (listNode!=null){
            listNode=listNode.next;
            i++;
        }
        return i;
    }
    public static int[] listToNum(ListNode l){
        int val;
        int i = listSize(l);
        int[] a =new int[i];
        int j = 0;
        while (l!=null){
            val=l.val;
            a[j]=val;
            j++;
            l=l.next;
        }
        return a;
    }
    public int ArrToNum(int[] a){
        int num=0;
        int m=0;
        for (int i = 0; i<a.length; i++) {
            m= (int) Math.pow(10, i);
            num=num+a[i]*m;
        }
        return num;
    }*/

}
