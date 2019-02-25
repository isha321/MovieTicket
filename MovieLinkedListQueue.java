public class MovieLinkedListQueue extends MovieSingleLinkedList
{
 
    private int capacity;			// How many elements can be stored maximum of 5
    private int size;				// How many elements are currently in the queue
    private MovieSingleLinkedList linkedList;

    // Constructors
    public MovieLinkedListQueue()
    {
        // Default Constructor
        this.capacity = 5;							//size has been uodated
        linkedList = new MovieSingleLinkedList();
        this.size = 0;

    }

    // Overlaoded Constructor
    public MovieLinkedListQueue(int capacity)
    {
        linkedList= new MovieSingleLinkedList();
        this.capacity = capacity;
        this.size = 0;
    }



    public void enqueue(MovieNode obj)
    {
                                                                     // This method adds elements to the end of the queue
                                                                     // Check if there is space to add elements to the Queue
        if(isFull())
        {
            // Check if full, print if full.
            System.out.println("Queue overflow...!!");
        }
        linkedList.addLast(obj);		//else add to the list
        size++;

    }


    public Object dequeue()
    {
        // This Method removes elements from front of the queue
        //Check if there is any elemnts in queue to be removed
        if(isEmpty())
        {
            System.out.println("Queue underflow...!!");		//state underflow if empty
            return null;
        }

        Object temp =linkedList.removeFirst();		//else remove element and update size of queue
        size--;
        return temp;
    }


    public boolean isEmpty()
    {
        return (this.size==0);
    }


    public boolean isFull()
    {

        return (this.capacity == this.size);
    }


    public int getSize()
    {
        return linkedList.getSize();
    }

    public void printQueue()
    {
        linkedList.printList();
    }
}
