package Day5.ReverseALinkedlist;

import java.util.Scanner;
/*
Input:
Number of nodes: 4
3
6
8
10
LinkedList :
3->6->8->10->null
Reversed LinkedList is:
10->8->6->3->null

Time complexity: O(n) : Traversing linkedlist linearly
Space complexity: O(1) : Not using any extra space.
 */
public class LinkedListIterative {
    Node head;

    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next){
            this.next = next;
            this.data = data;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfNodes = sc.nextInt();
        LinkedListIterative list = new LinkedListIterative();
        list.head = new Node(sc.nextInt());
        Node current = list.head;
        while(numberOfNodes > 1){ // greater than 1 because head we have already covered above
            current.next = new Node(sc.nextInt());
            current = current.next;
            numberOfNodes--;
        }
        System.out.println("LinkedList : ");
        printLinkedList(list.head);

        Node newHead = getReversedLinkedList(list.head);

        System.out.println("Reversed LinkedList is: ");
        printLinkedList(newHead);
    }

    private static Node getReversedLinkedList(Node head){
        Node previous = null;
        Node next = null;

        while(head!=null){
            next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return previous;
    }

    private static void printLinkedList(Node head){
        Node current = head;
        while(current!=null){
            System.out.print(current.data+"->");
            current = current.next;
        }
        System.out.println("null");
    }
}


