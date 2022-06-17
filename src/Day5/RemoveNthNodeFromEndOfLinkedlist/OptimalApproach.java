package Day5.RemoveNthNodeFromEndOfLinkedlist;

import java.util.Scanner;

/*
Input:
5
1 2 3 4 5
Linkedlist is:
1->2->3->4->5->null
Enter node to be deleted:
2
Output:
Linkedlist after removing Nth node:
1->2->3->5->null

Input:
5
1 2 3 4 5
Linkedlist is:
1->2->3->4->5->null
Enter node to be deleted:
5
Output:
Linkedlist after removing Nth node:
2->3->4->5->null

Input:
5
1 2 3 4 5
Linkedlist is:
1->2->3->4->5->null
Enter node to be deleted:
6
Not possible to delete..
Linkedlist after removing Nth node:
1->2->3->4->5->null

Time complexity: O(n)
O(n) - Traversing the linkedlist only once.
Space complexity: O(1) - Not using extra space.

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
        System.out.println("Enter node to be deleted: ");
        int nodeToRemove = sc.nextInt();
        head = removeNthNode(head, nodeToRemove);
        System.out.println("Linkedlist after removing Nth node: ");
        printLinkedlist(head);
    }

    private static Node removeNthNode(Node head, int nodeToRemove){
        Node dummy = new Node(-1);
        dummy.next = head;
        Node slow = dummy;
        Node fast = dummy;

        while(fast.next!=null && nodeToRemove > 0){
            fast = fast.next;
            nodeToRemove--;
        }

        if(nodeToRemove > 0){
            System.out.println("Not possible to delete..");
            return head;
        }

        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
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
