package leetcode.week270;

import base.ListNode;

public class Problem5943 {

    public ListNode deleteMiddle(ListNode head) {
        ListNode prehead=new ListNode();
        prehead.next=head;
        ListNode fast=prehead;
        ListNode slow=prehead;
        while(fast!=null &&fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //说明不存在2个或以上结点
        if(fast==prehead){
            return null;
        }
        if(slow!=prehead){
            ListNode temp=slow.next;
            slow.next=temp.next;
        }

        return prehead.next;
    }
}
