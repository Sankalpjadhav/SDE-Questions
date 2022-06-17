package Day5.AddTwoLinkedlist;

import java.util.Scanner;
/*
1) Input:
Number of elements of Linkedlist1:
3
Add elements of linkedlist 1:
3 2 9
3->2->9->null
Number of elements of Linkedlist2:
3
Add elements of linkedlist 2:
6 1 6
6->1->6->null

Output:
Result of two added Linkedlist:
9->3->5->1->null

2) Input:
Number of elements of Linkedlist1:
2
Add elements of linkedlist 1:
9 9
9->9->null
Number of elements of Linkedlist2:
1
Add elements of linkedlist 2:
1
1->null

Output:
Result of two added Linkedlist:
0->0->1->null

3) Input:
Number of elements of Linkedlist1:
3
Add elements of linkedlist 1:
3 2 1
3->2->1->null
Number of elements of Linkedlist2:
0
Add elements of linkedlist 2:
null

Output:
Result of two added Linkedlist:
3->2->1->null

Time complexity: O(Max(m, n)) where m is the length of linkedlist1 and n is the length of linkedlist2.
Space complexity: O(Max(m, n)) + 1 -> +1 for carry (Result could have one extra node due to carry)
 */
public class OnlySolution {
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

        Node addedLinkedlistHead = addTwoLinkedlist(head1, head2);
        System.out.println("Result of two added Linkedlist: ");
        printList(addedLinkedlistHead);
    }

    private static Node addTwoLinkedlist(Node head1, Node head2){
        if(head1==null){
            return head2;
        }

        if(head2==null){
            return head1;
        }

        Node dummy = new Node(-1);
        Node ptr = dummy;
        Node ptr1 = head1;
        Node ptr2 = head2;

        int carry = 0;
        while(ptr1!=null || ptr2!=null || carry==1){
            int sum = 0;
            if(ptr1!=null){
                sum += ptr1.data;
                ptr1 = ptr1.next;
            }

            if(ptr2!=null){
                sum += ptr2.data;
                ptr2 = ptr2.next;
            }

            sum += carry;

            carry = sum/10;

            Node newNode = new Node(sum%10);
            ptr.next = newNode;
            ptr = ptr.next;
        }

        return dummy.next;
    }

    private static Node addElements(int numberOfElements){
        if(numberOfElements == 0){
            return null;
        }
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
