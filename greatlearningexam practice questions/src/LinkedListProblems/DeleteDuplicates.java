package LinkedListProblems;

class ListNode {
      int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class DeleteDuplicates {
    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(1);
        node1.next.next = new ListNode(2);
        System.out.println(deleteDuplicates(node1));

    }
    public static ListNode deleteDuplicates(ListNode head) {

        ListNode curr = head;

        while(curr != null)
        {
            boolean flag = false;
            ListNode node = curr.next;
            while(node != null)
            {
                if(node.val == curr.val)
                {
                    node = node.next;
                    flag = true;
                }
            }
            if(flag)
                curr.next = node;

            System.out.println("curr value is "+ curr.val);
            curr = curr.next;

        }
        return head;
    }
}