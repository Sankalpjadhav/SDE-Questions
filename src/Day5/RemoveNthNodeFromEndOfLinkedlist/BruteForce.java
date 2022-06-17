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

Time complexity: O(n)+O(n)
O(n) - To find the length of the list.
O(n) - To traverse till the node to be removed.
Space complexity: O(1) - Not using extra space

 */
public class BruteForce {
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
        int lengthOfLinkedList = 0;
        Node currentPtr = head;

        while(currentPtr!=null){
            lengthOfLinkedList++;
            currentPtr = currentPtr.next;
        }

        if(nodeToRemove > lengthOfLinkedList){
            System.out.println("Not possible to delete..");
            return head;
        }

        Node dummyNode = new Node(-1);
        dummyNode.next = head;
        Node ptr = dummyNode;
        for(int i=0;i<lengthOfLinkedList-nodeToRemove;i++){
            ptr = ptr.next;
        }
        ptr.next = ptr.next.next;
        return dummyNode.next;
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
