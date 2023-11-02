import static java.lang.System.exit;

class QueueUsingArray
{
    int front,rear=-1;
    int arr[]=new int[10];
    int count =0;

    void enqueue(int data)
    {
        if (this.front==-1)
        {
            this.front++;
        }
        if(this.count+1==this.arr.length)
        {
            System.out.println("Queue Overflow");
            return;
        }

        this.rear=(this.rear+1)%this.arr.length;
        this.arr[rear]=data;
        this.count++;
    }

    int dequeue()
    {
       int temp= this.arr[this.front];
       this.front=(this.front+1)%this.arr.length;
       this.count--;
       return temp;
    }

    void printQueue()
    {
        for(int i=this.front; i<=this.rear; i++)
            System.out.print(this.arr[i] + " ");
    }

    public static void main(String[] args)
    {
        QueueUsingArray q=new QueueUsingArray();
        q.enqueue(11);
        q.enqueue(22);
        q.printQueue();
        System.out.println(q.dequeue());
        q.enqueue(33);
        q.printQueue();

    }
}