package LinkedListProblems;


import java.util.LinkedList;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{30,23,28,30,11,14,19,16,21,25};
        Node head = LinkedListUserInput.userInput(arr);

        LinkedListUserInput.printLinkedList(head);
//        Node res = insertionSort(head);
//        LinkedListUserInput.printLinkedList(res);
    }
    public static Node insertionSort(Node head)
    {
        //code here

        Node small = head;
        Node dummy = head;

        int count = 0;
        while(count == 5)
        {
            if(dummy.data > dummy.next.data)
            {
                dummy = small.next;
                small.next = dummy.next;
                dummy.next = small;
            }
            count++;
        }
        return dummy;
    }
}
