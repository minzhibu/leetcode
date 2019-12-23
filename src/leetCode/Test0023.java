package leetCode;

import org.junit.Test;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Test0023 {

    @Test
    public void test0023() {
        ListNode listNode11 = new ListNode(1);
        ListNode listNode14 = new ListNode(4);
        ListNode listNode15 = new ListNode(5);
        listNode11.next = listNode14;
        listNode14.next = listNode15;
        ListNode listNode21 = new ListNode(1);
        ListNode listNode23 = new ListNode(3);
        ListNode listNode24 = new ListNode(4);
        listNode21.next = listNode23;
        listNode23.next = listNode24;
        ListNode listNode32 = new ListNode(2);
        ListNode listNode36 = new ListNode(6);
        listNode32.next = listNode36;
        ListNode[] listNodes = {listNode11, listNode21, listNode32};
        ListNode[] listNodes1 = {null, null};
        ListNode listNode = mergeKLists(listNodes);
        System.out.println(listNode);
    }

    //    public ListNode mergeKLists(ListNode[] lists) {
//        if(lists==null||lists.length<1){
//            return null;
//        }
//        if(lists.length==1){
//            return lists[0]==null?null:lists[0];
//        }
//        Set<Integer> set = new HashSet<>();
//        ListNode listNode = null;
//        ListNode tempNode = null;
//        while (set.size() != lists.length - 1) {
//            for (int i = 0; i < lists.length; i++) {
//                if (lists[i] == null) {
//                    set.add(i);
//                }
//            }
//            if(set.size()==lists.length){
//                return null;
//            }
//            int temp=Integer.MAX_VALUE;
//            int index = 0;
//
//            for (int i = 0; i < lists.length; i++) {
//                if(!set.contains(i)){
//                    if(temp>lists[i].val){
//                        temp = lists[i].val;
//                        index = i;
//                    }
//                }
//            }
//            if(listNode==null){
//                listNode = new ListNode(lists[index].val);
//                tempNode = listNode;
//            }else{
//                tempNode.next = lists[index];
//                tempNode = tempNode.next;
//            }
//            lists[index] = lists[index].next;
//        }
//        for (int i = 0; i < lists.length; i++) {
//            if(!set.contains(i)){
//                tempNode.next = lists[i];
//            }
//        }
//        return listNode;
//    }
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        // 将n个链表以中间为对称，合并，即合并
        while (len > 1) {
            for (int i = 0; i < len / 2; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[len - 1 - i]);
            }
            len = (len + 1) / 2;
        }
        return lists[0];
    }

    // 合并两个链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        } else if (l2 != null) {
            p.next = l2;
        }
        return head.next;
    }
}
