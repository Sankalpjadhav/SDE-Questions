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

Time complexity: O(n) + O(n)
O(n) - To calculate length of the linkedlist
O(n) - To find middle of the linked list

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
        //BruteForce list = new BruteForce();
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
        int lengthOfTheList = 0;

        Node current = head;
        while(current!=null){
            lengthOfTheList++;
            current = current.next;
        }

        int middleNode = (lengthOfTheList/2)+1;
        Node middle = head;
        for(int i=1;i<middleNode;i++){
            middle = middle.next;
        }
        return middle;
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
