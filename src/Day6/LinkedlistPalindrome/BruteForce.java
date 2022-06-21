package Day6.LinkedlistPalindrome;

import java.util.ArrayList;
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

Time complexity: O(n) + O(n)
O(n) - To add all the nodes in linkedlist.
O(n) - To check list to validate if it is palindrome or not.

Space complexity: O(n) - Made use of list to store all the nodes.
 */
public class BruteForce {
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
        ArrayList<Integer> list = new ArrayList<>();
        Node currentPointer = head;

        while(currentPointer!=null){
            list.add(currentPointer.data);
            currentPointer = currentPointer.next;
        }

        int left = 0;
        int right = list.size()-1;

        while(left<right){
            if(list.get(left)!=list.get(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
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
