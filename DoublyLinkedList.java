import java.io.*;

class DoublyLinkedList {
    Node head; // head of list
    Node tail; // tail of list
    int num=0;
    class Node {
        int data;
        Node next;
        Node prev;
        // Next is by default initialized as null
        Node(int d) { data = d; }
    }

    public void insertEmpty(int Data)
    {
        Node nn= new Node(Data);
        this.head=nn;
        this.tail=nn;
        nn.next=this.tail;
        nn.prev=this.head;
        this.num++;
    }

    public void insertFirst(int Data)
    {
        Node nn= new Node(Data);
        nn.next= this.head;
        this.head=nn;
        nn.prev=this.head;
        (nn.next).prev=nn;
        this.num++;
    }

    public void insertPosition(int DATA, int pos)
    {
        // initialize temp node for traversal
        Node temp=head;
        int j=0; // initial position
        while(j<pos-1){
          // return if position is out of bounds
           if(temp.next==null || pos<0){
               System.out.println("list size is less than pos \n");
               return;
           }
           j++;
           temp=temp.next;
        }
        // create a new node
        Node newNode = new Node(DATA);
        newNode.next=temp.next;
        newNode.prev=temp;

        temp.next=newNode;
        (newNode.next).prev=newNode;
        System.out.println("node inserted \n");
        this.num++;
    }

    public void deletePosition(int pos)
    {
        Node temp=head;
        int j=0;
        while(j<pos-1){
           if(temp.next==null){
               System.out.println("list size is less than pos");
               return;
           }
           j++;
           temp=temp.next;
        }
        temp.next=(temp.next).next;
        (temp.next).prev=temp;
        this.num--;
    }

    public void printList()
    {
        int j=0;
        Node temp=this.head;
        for(j=0;j<this.num;j++)
        {
            System.out.print(temp.data);
            temp=temp.next;
        }
            System.out.print("\n");
    }

    public static void main(String[] args)
    {
        DoublyLinkedList dlist = new DoublyLinkedList();
        dlist.insertEmpty(1);
        dlist.printList();
        dlist.insertFirst(2);
        dlist.insertFirst(3);
        dlist.printList();
        dlist.insertPosition(4,2);
        dlist.insertPosition(5,2);
        dlist.printList();
        dlist.deletePosition(2);
        dlist.deletePosition(2);
        dlist.printList();
    }
}

