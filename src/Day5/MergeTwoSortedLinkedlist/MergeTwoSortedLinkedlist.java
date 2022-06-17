package Day5.MergeTwoSortedLinkedlist;

import java.util.Scanner;
/*
Input:
Number of elements of Linkedlist1:
3
Add elements of linkedlist 1:
3 7 10
3->7->10->null
Number of elements of Linkedlist2:
5
Add elements of linkedlist 2:
1 2 5 8 10
1->2->5->8->10->null

Output:
Merged Linkedlist:
1->2->3->5->7->8->10->10->null

Input:
Number of elements of Linkedlist1:
4
Add elements of linkedlist 1:
1 3 5 8
1->3->5->8->null
Number of elements of Linkedlist2:
4
Add elements of linkedlist 2:
2 4 6 7
2->4->6->7->null
Output:
Merged Linkedlist:
1->2->3->4->5->6->7->8->null

Time complexity: O(numberOfNodesOfLinkedlist1 + numberOfNodesOfLinkedlist2) - We are traversing two linkedlist.
Space complexity: O(numberOfNodesOfLinkedlist1 + numberOfNodesOfLinkedlist2) - We are creating new nodes.
 */
public class MergeTwoSortedLinkedlist {
    static Node head1;
    static Node head2;

    static class Node{
        int data;
        Node next;

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
        System.out.println("Number of elements of Linkedlist1: ");
        int numberOfNodesOfLinkedlist1 = sc.nextInt();
        System.out.println("Add elements of linkedlist 1: ");
        head1 = addElements(numberOfNodesOfLinkedlist1);
        printList(head1);
        System.out.println("Number of elements of Linkedlist2: ");
        int numberOfNodesOfLinkedlist2 = sc.nextInt();
        System.out.println("Add elements of linkedlist 2: ");
        head2 = addElements(numberOfNodesOfLinkedlist2);
        printList(head2);

        Node mergedLinkedlistHead = mergeTwoLinkedlist(head1, head2);
        System.out.println("Merged Linkedlist: ");
        printList(mergedLinkedlistHead);
    }

    private static Node mergeTwoLinkedlist(Node head1, Node head2){
        Node dummy = new Node(-1);
        Node dummyPtr = dummy;
        Node headPtr1 = head1;
        Node headPtr2 = head2;
        while(headPtr1!=null && headPtr2!=null){
            if(headPtr1.data <= headPtr2.data){
                dummyPtr.next = new Node(headPtr1.data);
                headPtr1 = headPtr1.next;
            }else{
                dummyPtr.next = new Node(headPtr2.data);
                headPtr2 = headPtr2.next;
            }
            dummyPtr = dummyPtr.next;
        }

        if(headPtr1!=null){
            dummyPtr.next = headPtr1;
        }

        if(headPtr2!=null){
            dummyPtr.next = headPtr2;
        }

        return dummy.next;
    }

    private static Node addElements(int numberOfElements){
        Scanner sc  = new Scanner(System.in);
        Node head = new Node(sc.nextInt());
        Node current = head;
        while(numberOfElements > 1){
            current.next = new Node(sc.nextInt());
            current = current.next;
            numberOfElements--;
        }
        return head;
    }

    private static void printList(Node head){
        Node pointer = head;

        while(pointer != null){
            System.out.print(pointer.data+"->");
            pointer = pointer.next;
        }
        System.out.println("null");
    }
}
