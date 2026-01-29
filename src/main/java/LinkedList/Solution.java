package LinkedList;

import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {


    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slowPointer = head;
        ListNode fastPointer = head.next.next;

        while (fastPointer != null && fastPointer.next != null) {
            if (slowPointer == fastPointer) {
                return true;
            }
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

        }
        return false;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null ){
            return l2;
        }
        else if(l2==null){
            return l1;
        }
        else{
            if(l1.val>l2.val){
                ListNode temp = l1;
                l1=l2;
                l2=temp;
            }

            while (l1.next!=null && l2!=null){
                if(l1.next.val> l2.val){
                    ListNode nl1 = l1.next;
                    ListNode nl2 = l2.next;
                    l1.next=l2;
                    l2.next= nl1;
                    l2=nl2;
                    l1= nl1;
                }
                else{
                    l1 = l1.next;
                }
            }
            if(l2!=null){
                l1.next=l2;
            }
        }
        return l1;
    }



}
