package Day6.ReverseNodesInKGroupsVersion1;

import java.util.Scanner;
/*

Version 1:  If the number of nodes is not a multiple of K then left out nodes in the end should be kept as it is.

Input:
Enter number of nodes:
5
Enter nodes of the Linkedlist:
1 2 3 4 5
Enter the value of k:
2
Original Linkedlist:
1->2->3->4->5->null
Linkedlist after reversing nodes in K groups:
2->1->4->3->5->null

Input:
Enter number of nodes:
6
Enter nodes of the Linkedlist:
1 2 3 4 5 6
Enter the value of k:
3
Original Linkedlist:
1->2->3->4->5->6->null
Linkedlist after reversing nodes in K groups:
3->2->1->6->5->4->null

Time complexity: O(n) + O(n)
O(n) - To calculate length of the linkedlist
O(n) - To traverse entire list once

Space complexity: O(1) - Not using any extra space
 */
public class OnlySolution {
    private static Node head;
    private static Node tempHead;
    private static Node tempTail;

    static class Node{
        Node next;
        int data;

        public Node(int data){
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes: ");
        int n = sc.nextInt();
        System.out.println("Enter nodes of the Linkedlist: ");
        if(n<=0){
            return;
        }

        head = new Node(sc.nextInt());
        Node pointer = head;
        while(n > 1){
            pointer.next = new Node(sc.nextInt());
            pointer = pointer.next;
            n--;
        }
        System.out.println("Enter the value of k: ");
        int k = sc.nextInt();
        System.out.println("Original Linkedlist: ");
        printLinkedlist(head);
        head = reverseNodes(head, k);
        System.out.println("Linkedlist after reversing nodes in K groups: ");
        printLinkedlist(head);
    }

    private static Node reverseNodes(Node head, int k){
        if(head==null || head.next==null || k<=1){
            return head;
        }
        Node currentPointer = head;
        Node originalHead = null, originalTail = null;
        int lengthOfTheLinkedlist = getLength(head);
        while(lengthOfTheLinkedlist >= k){
            int temp = k;

            while(temp-- > 0){
                Node nextNode = currentPointer.next;
                currentPointer.next = null;
                addNodeAtStart(currentPointer);
                currentPointer = nextNode;
            }

            if(originalHead==null){
                originalHead = tempHead;
                originalTail = tempTail;
            }
            else{
                originalTail.next = tempHead;
                originalTail = tempTail;
            }
            tempHead = null; tempTail = null;
            lengthOfTheLinkedlist = lengthOfTheLinkedlist - k;
        }
        originalTail.next = currentPointer;
        return originalHead;
    }


    private static void addNodeAtStart(Node node){
        if(tempHead==null){
            tempHead = node;
            tempTail = node;
        }
        else{
            node.next = tempHead;
            tempHead = node;
        }
    }

    private static int getLength(Node head){
        int length = 0;
        Node pointer = head;
        while(pointer!=null){
            length++;
            pointer = pointer.next;
        }
        return length;
    }

    private static void printLinkedlist(Node head){
        Node pointer = head;
        while(pointer!=null){
            System.out.print(pointer.data+"->");
            pointer = pointer.next;
        }
        System.out.println("null");
    }
}
