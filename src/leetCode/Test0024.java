package leetCode;

import org.junit.Test;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Test0024 {

    @Test
    public void test0024() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;
        ListNode listNode = swapPairs(listNode1);
        System.out.println(listNode);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode listNode = new ListNode(0);
        ListNode index = listNode;
        if (head != null && head.next == null) {
            return head;
        }
        while (head != null && head.next != null) {
            ListNode temp = head.next;
            head.next = head.next.next;
            temp.next = head;
            index.next = temp;
            index = index.next.next;
            head = head.next;
        }
        return listNode.next;
    }
}
