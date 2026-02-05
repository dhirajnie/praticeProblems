package LinkedList;


import jdk.nashorn.internal.ir.SplitReturn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

//    @Override
//    public String toString() {
//        return "Node{" +
//                "val=" + val +
//                ", next=" + next +
//                ", random=" + random +
//                '}';
//    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "[" + this.val + "]";
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
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            if (l1.val > l2.val) {
                ListNode temp = l1;
                l1 = l2;
                l2 = temp;
            }

            while (l1.next != null && l2 != null) {
                if (l1.next.val > l2.val) {
                    ListNode nl1 = l1.next;
                    ListNode nl2 = l2.next;
                    l1.next = l2;
                    l2.next = nl1;
                    l2 = nl2;
                    l1 = nl1;
                } else {
                    l1 = l1.next;
                }
            }
            if (l2 != null) {
                l1.next = l2;
            }
        }
        return l1;
    }


    static void printList(Node node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    static public Node copyRandomList(Node head) {

        Map<Node, Integer> oldNodePosition = new HashMap<>();
        Map<Integer, Node> newNodePosition = new HashMap<>();
        int oldNodeCounter = 0;
        Node curNodePointer = head;
        Node newHead = new Node(head.val);
        Node newNodeCurr = newHead;
        oldNodePosition.put(curNodePointer, oldNodeCounter);
        newNodePosition.put(oldNodeCounter, newHead);
        curNodePointer = curNodePointer.next;
        ++oldNodeCounter;

        while (curNodePointer != null) {
            Node newNode = new Node(curNodePointer.val);
            newNodeCurr.next = newNode;
            newNodeCurr = newNodeCurr.next;

            oldNodePosition.put(curNodePointer, oldNodeCounter);
            newNodePosition.put(oldNodeCounter, newNodeCurr);

            curNodePointer = curNodePointer.next;
            ++oldNodeCounter;
        }

        Node oldNodeMov = head;
        Node newNodeMov = newHead;
        while (oldNodeMov != null) {
            newNodeMov.random = newNodePosition.get(oldNodePosition.get(oldNodeMov.random));
            oldNodeMov = oldNodeMov.next;
            newNodeMov = newNodeMov.next;
        }

        System.out.println(oldNodePosition);
        System.out.println(newNodePosition);
        printList(newHead);

        return newHead;

    }


    static public List<ListNode> swap(ListNode head,int swapCount) {
        // tail and head

        List<ListNode> result = new ArrayList<>();
        result.add(head);
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null && swapCount>0) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
            --swapCount;
        }


        result.add(prev);
        return result;

    }

    static public ListNode reverseBetween(ListNode head, int left, int right) {

    //    ListNode firstIndex = null;
        ListNode curr = head;
        ListNode firstNode = null;
        ListNode lastNode = null;

        int counter = 1;

        while (curr!=null){
            if(counter==left-1){
                firstNode= curr;
            }
            if(counter==right+1){
                lastNode=curr;
                break;
            }
            ++counter;
            curr=curr.next;
        }
        if(firstNode==null){
         List<ListNode> tailhead =    swap(head,right-left+1);

         tailhead.get(0).next=lastNode;
         return tailhead.get(1);

        }
        else{
            List<ListNode> tailhead =  swap(firstNode.next,right-left+1);
            firstNode.next= tailhead.get(1);
            tailhead.get(0).next=lastNode;
            return head;
        }




    }

//    public ListNode deleteDuplicates(ListNode head) {
//        ListNode prev = new ListNode(0);
//        ListNode next= head;
//
//        while(next!=null){
//            if(head.next!=null  && head.next.val==head.val){
//                while()
//            }
//        }
//
//    }

    public ListNode rotateRight(ListNode head, int k) {

        int totalLength =0;
        ListNode curr= head;
        while (curr!=null){
            ++totalLength;
            curr=curr.next;
        }

        k = k%totalLength;
        int cutNode = totalLength-k-1;
        System.out.println(cutNode);
        curr=head;
        while(cutNode!=0){
            --cutNode;
            curr=curr.next;
        }

        ListNode newHead = curr.next;
        curr.next=null;

        ListNode newCurr = newHead;
        while(newCurr.next!=null){
            newCurr= newCurr.next;
        }
        newCurr.next=head;


return newHead;

    }



   static public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while(head!=null){
            if(head.next!=null && head.val==head.next.val){
                while(head.next!=null && head.val==head.next.val){
                    head= head.next;
                }
                head = head.next;
                prev.next=head;
            }
            else{
                prev.next= head;
                head= head.next;
                prev= prev.next;
            }

        }

        return dummy.next;

    }



  static   public ListNode partition(ListNode head, int x) {
        ListNode perHead  = new ListNode(Integer.MIN_VALUE);
        perHead.next= head;
        head = perHead;
        ListNode lastNode = head;
        int nodeCount =0;
        while(lastNode.next!=null){
            ++nodeCount;
            lastNode=lastNode.next;
        }
        ListNode mLastNode = lastNode;

        while(head!=null &&nodeCount>0){
            --nodeCount;
            if(  head.next!=null && head.next.val>=x){
                ListNode nextOfNext = head.next.next;
                mLastNode.next= head.next;
                mLastNode.next.next=null;
                mLastNode= mLastNode.next;
                head.next=nextOfNext;
            }
            else{
                head= head.next;
            }
        }
        return perHead.next;

    }





    public static void main(String[] args) {
        ListNode head = new ListNode(6);
         head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(0);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(2);



        head = partition(head,4);
        while (head!=null){
            System.out.print(head.val+" -> ");
            head=head.next;
        }
    }


}
