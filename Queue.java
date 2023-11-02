import java.io.*;

class Queue {
    Node front; // head of list
    Node rear;  // last element of list
    int count=0;

    class Node {
        int data;
        Node next;
        // Next is by default initialized as null
        Node(int d) { data = d; }
    }
    public void enqueue(int DATA)
    {
        Node nn= new Node(DATA);
        if(this.front==null)
        {
            this.front=nn;
            this.rear=nn;
        }
        else{
            this.rear.next=nn;
            this.rear=nn;
        }
        this.count++;
    }

    public int dequeue()
    {
        if(this.count==0)
            {
                System.out.println("Queue Underflow");
                return -1;
            }
        int temp= this.front.data;

        if(this.count==1)
        {
            this.front=this.rear=null;
        }
        else
        {
            this.front=this.front.next;
        }
        this.count--;
        return temp;
    }

    public static void main(String[] args)
    {
        Queue q=new Queue();
        q.enqueue(11);
        q.enqueue(22);
        System.out.println(q.dequeue());
        q.enqueue(33);
        System.out.println(q.dequeue());

    }
}
