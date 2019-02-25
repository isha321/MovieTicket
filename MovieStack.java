
public class MovieStack<E>
{
	private E[] theData;						//Data
    private int topOfStack = -1;				//Storage for the stack
    private static final int INITIAL_CAPACITY = 10;

	//Consructors								
    public MovieStack()					
										//Creates a stack of default capacity
    {
        this.theData = (E[]) new Object[INITIAL_CAPACITY];

    }
    //]To create a Stack of custom size; overloaded constructor
    public MovieStack(int size)
    {
        this.theData = (E[]) new Object[size];
    }

    public void push(E obj)
    {
        //adds elements to the stack 
        //Checks if the satck is full
        if(topOfStack == theData.length-1)
        {
            System.out.println("Stack Overflow...!!");
            return;
        }
        //Else, if there is space,increment topOfStack and insert data
        topOfStack++;
        this.theData[topOfStack]=obj;
        return;

    }

    public E pop()
    {

        //this method removes elements from the stack if elements are present
        if(empty())					//check if empty
        {
            return null;
        }
        //There is some element, delete it and return
        E temp = theData[topOfStack];
        topOfStack--;		//update size
        return temp;

    }

    public E peek()
    {
        //Similar to pop except doesn't delete the element
        if(empty())
        {
            return null;
        }
        //There is some element, delete it and return
        return theData[topOfStack];

    }


    public boolean empty()
    {
        return(topOfStack == -1);
    }

    public boolean isFull()
    {
        if(topOfStack == theData.length-1)
        {
            return true;
        }
        return false;
    }


    public void movieDisplay()
    {
        //Method to print the contents of the stack
        System.out.println("Stack: ");
        for(int i=0; i<= topOfStack; i++)
        {
            System.out.print(theData[i]); //Printing from the bottom of the stack
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        System.out.println();
    }

}