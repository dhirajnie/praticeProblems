package thread.practice;

public class CopyRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node newHead = null;
        Node mainHead = head;
        Node nextPointer = head.next;
        while (head != null) {
            Node newNode = new Node(head.val);
            head.next = newNode;
            newNode.next = nextPointer;
            if (nextPointer!=null && nextPointer.next != null) {
                nextPointer = nextPointer.next.next;
            }
            if (newHead == null) {
                newHead = newNode;
            }
            head = head.next.next;
        }
        head = mainHead.next;
        nextPointer = mainHead.next;
        while (nextPointer != null && head.random!=null) {
            nextPointer.random = head.random.next;
            head = head.next.next;
            nextPointer= nextPointer.next.next;

        }


        System.out.print("Returned");
        return newHead;
    }

    public static void main(String[] args) {

    }
}
