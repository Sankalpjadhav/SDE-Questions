package Day6.LinkedlistPalindrome;

import java.util.Scanner;
/*
Input:
Enter number of nodes:
6
Enter nodes of a linkedlist:
1 2 3 3 2 1
Linkedlist:
1->2->3->3->2->1->null
Is given linkedlist palindrome? : true

Input:
Enter number of nodes:
5
Enter nodes of a linkedlist:
1 2 3 2 1
Linkedlist:
1->2->3->2->1->null
Is given linkedlist palindrome? : true

Input:
Enter number of nodes:
6
Enter nodes of a linkedlist:
1 2 3 3 4 1
Linkedlist:
1->2->3->3->4->1->null
Is given linkedlist palindrome? : false

Time complexity: O(n/2) + O(n/2)
O(n/2) - To move slow pointer to the mid of the linkedlist
O(n/2) - To compare the values to validate if the linkedlist is palindrome or not
Space complexity: O(1) - Not using extra space
 */
public class OptimalApproach {
    private static Node head;

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

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes: ");
        int n = sc.nextInt();
        System.out.println("Enter nodes of a linkedlist: ");
        if(n<=0){
            return;
        }

        head = new Node(sc.nextInt());
        Node currentPointer = head;
        while(n-- > 1){
            currentPointer.next = new Node(sc.nextInt());
            currentPointer = currentPointer.next;
        }
        System.out.println("Linkedlist: ");
        printLinkedlist(head);

        System.out.println("Is given linkedlist palindrome? : "+isPalindrome(head));
    }

    private static boolean isPalindrome(Node head){
        if(head==null || head.next==null){
            return true;
        }
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverseLinkedlist(slow.next);
        slow = slow.next;
        fast = head;
        while(slow!=null){
            if(slow.data!= fast.data){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private static Node reverseLinkedlist(Node node){
        Node prev = null;
        Node next = null;

        while(node!=null){
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
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
