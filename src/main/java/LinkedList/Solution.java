package LinkedList;


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
  public  String toString(){
        return "["+this.val+"]";
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
        Map<Integer,Node> newNodePosition = new HashMap<>();
        int oldNodeCounter = 0;
        Node curNodePointer = head;
        Node newHead = new Node(head.val);
        Node newNodeCurr = newHead;
        oldNodePosition.put(curNodePointer, oldNodeCounter);
        newNodePosition.put(oldNodeCounter ,newHead);
        curNodePointer = curNodePointer.next;
        ++oldNodeCounter;

        while (curNodePointer != null) {
            Node newNode = new Node(curNodePointer.val);
            newNodeCurr.next = newNode;
            newNodeCurr = newNodeCurr.next;

            oldNodePosition.put(curNodePointer, oldNodeCounter);
            newNodePosition.put(oldNodeCounter,newNodeCurr);

            curNodePointer = curNodePointer.next;
            ++oldNodeCounter;
        }

        Node oldNodeMov = head;
        Node newNodeMov = newHead;
        while(oldNodeMov!=null){
            newNodeMov.random = newNodePosition.get( oldNodePosition.get(oldNodeMov.random));
            oldNodeMov=  oldNodeMov.next;
            newNodeMov= newNodeMov.next;
        }

        System.out.println(oldNodePosition);
        System.out.println(newNodePosition);
        printList(newHead);

        return newHead;

    }


    static public List<ListNode> swap(ListNode head){
        // tail and head

        List<ListNode> result = new ArrayList<>();
        result.add(head);
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode nextTemp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextTemp;
        }


        result.add(prev);
        return result;

    }
// static  public ListNode reverseBetween(ListNode head, int left, int right) {
//
//
//
//
//    }




    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
      List<ListNode> tailHead =   swap(node);

      ListNode newHead = tailHead.get(1);
      while (newHead!=null){
          System.out.println(newHead);
          newHead= newHead.next;
      }
     //   System.out.println(tailHead);
    }


}
