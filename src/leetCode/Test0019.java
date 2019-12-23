package leetCode;

import org.junit.Test;

public class Test0019 {

    @Test
    public void test0019() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
        ListNode listNode = removeNthFromEnd(listNode1, 2);
        System.out.println(listNode);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        Integer remove = remove(null, head, n);
        if(remove==-1){
            return head.next;
        }else {
            return head;
        }
    }

    public Integer remove(ListNode list, ListNode node, int n) {
        if (node.next == null) {
            if(list == null){
                return -1;
            }
            if (n == 1) {
                list.next = null;
            }
            return 2;
        }
        int num = remove(node, node.next, n);
        if (num == n) {
            if (list == null) {
                return -1;
            } else {
                list.next = node.next;
            }
            return Integer.MIN_VALUE;
        } else {
            return num + 1;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}