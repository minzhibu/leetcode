package leetCode;

import org.junit.Test;

public class Test0061 {

    @Test
    public void test0061(){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = rotateRight(listNode1, 2);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        // 第一步将这个链表变成环形链表(使用辅助指针nodeTemp)，随便计算一共有多少个节点(num)
        if(head == null){
            return head;
        }
        int num = 0;
        ListNode nodeTemp = head;
        while(true){
            num++;
            if(nodeTemp.next==null){
                nodeTemp.next = head;
                break;
            }
            nodeTemp = nodeTemp.next;
        }
        if(num<2){
            return head;
        }
        // 第二步num-(k%num)-1计算一共需要移动几次
        num = num-(k%num)-1;
        // 第三步移动到上面计算出来的这个节点，
        nodeTemp = head;
        for(int i = 0; i < num ; i++){
            nodeTemp = nodeTemp.next;
        }
        // 第四步将这个节点的下一个节点赋值给首先节点，并将当前节点的next设置为null
        head = nodeTemp.next;
        nodeTemp.next = null;
        // 第五步返回这个首先节点
        return head;
    }
}
