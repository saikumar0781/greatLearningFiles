package gfgpotd030126;
public class FlattenLinkedList {
    public static void main(String[] args) {

        Node root = new Node(5);
        root.bottom = new Node(7);
        root.bottom.bottom = new Node(8);
        root.bottom.bottom.bottom = new Node(30);
        root.next = new Node(10);
        //root.next.bottom = new Node(20);
        root.next.next = new Node(19);
        root.next.next.bottom = new Node(22);
        root.next.next.bottom.bottom = new Node(50);
        root.next.next.next = new Node(28);
//        root.next.next.next.bottom = new Node(40);
//        root.next.next.next.bottom.bottom = new Node(45);

        Node temp = new FlattenLinkedList().flatten(root);

        while(temp.bottom != null)
        {
            System.out.println(temp.data);
            temp = temp.bottom;
        }
    }
    public Node flatten(Node root) {
        // code here
        //System.out.println(root.next.next.bottom.data);


        Node temp = flattenLinkedList(root,root.next);
        //     root = temp;
        // }

        return temp;

    }
    public Node flattenLinkedList(Node root,Node nextNode)
    {
        Node temp = new Node(0);
        Node temp2 = temp;

        while(root != null && nextNode != null)
        {
            if(root.data < nextNode.data)
            {
                temp.bottom = root;
                temp = temp.bottom;
                root = root.bottom;
            }
            else
            {
                temp.bottom = nextNode;
                temp = temp.bottom;
                nextNode = nextNode.bottom;
            }
        }
        while(root != null)
        {
            temp.bottom = root;
            temp = temp.bottom;
            root = root.bottom;
        }
        while(nextNode != null)
        {
            temp.bottom = nextNode;
            temp = temp.bottom;
            nextNode = nextNode.bottom;
        }
        return temp2.bottom;
    }
    static class Node
    {
        int data;
        Node next;
        Node bottom;
        public Node(int x)
        {
            this.data = x;
            next =null;
            bottom = null;
        }
    }
}
