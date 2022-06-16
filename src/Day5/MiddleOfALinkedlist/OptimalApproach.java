package Day5.MiddleOfALinkedlist;

import java.util.Scanner;
/*
Input:
Number of nodes: 5
1
2
3
4
5
Linkedlist is:
1->2->3->4->5->null
Middle node of the linkedlist: 3

Input:
Number of nodes: 6
1
2
3
4
5
6
Linkedlist is:
1->2->3->4->5->6->null
Middle node of the linkedlist: 4

Time complexity: O(n) - To find middle of the linked list using Hare and Tortoise method
Space complexity: O(1) - Not using extra space
 */
public class OptimalApproach {
    private static Node head;

    static class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int numberOfNodes = sc.nextInt();
        head = new Node(sc.nextInt());
        Node pointer = head;
        while(numberOfNodes > 1){
            pointer.next = new Node(sc.nextInt());
            pointer = pointer.next;
            numberOfNodes--;
        }

        System.out.println("Linkedlist is: ");
        printLinkedlist(head);
        Node middleNode = getMiddleNode(head);
        System.out.println("Middle node of the linkedlist: "+middleNode.data);
    }

    private static Node getMiddleNode(Node head){
        Node slow = head, fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static void printLinkedlist(Node head){
        Node current = head;
        while(current!=null){
            System.out.print(current.data+"->");
            current = current.next;
        }
        System.out.println("null");
    }
}
