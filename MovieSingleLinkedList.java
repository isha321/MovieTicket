public class MovieSingleLinkedList {

    private MovieNode head;		//Head of the Linked List
    private int size;		//Size of the list

    public MovieSingleLinkedList(){
        this.head = new MovieNode(-1); 	//Creates the head, and stores special value -1
        size = 0;					//At the beginning, the list is empty
    }


    //Method to add item at the beginning of the list
    public void addFirst(Object item){
        MovieNode first = new MovieNode(item);	//Step 1: Create the MovieNode
        first.next = head.next;			//Step 2: Copy the next of head to the next of MovieNode
        head.next = first;				//Step 3: Update the head next value to point to the new MovieNode
        size++;							//Step 4: Update the number of nodes in the list
    }

   

    //Method to add item at the end of the list
    public void addLast(Object item){
        //Using the getNode() method to retrieve the reference and then call addAfter()
        MovieNode target = getNode(size);	//yo retreive the last MovieNode
        addAfter(target, item);			//call the addAfter method 
    }
	 //Method to add item after a given MovieNode reference
    public void addAfter(MovieNode target, Object item){
        MovieNode insert = new MovieNode(item);
        insert.next = target.next;
        target.next = insert;
        size++;
    }

    //Helper method, returns the reference to the MovieNode at given index
    public MovieNode getNode(int index){
        if(index < 0 || index > size){
            return null;
        }
        //Otherwise, iterate over the list, and return the reference
        MovieNode iter = head; 	//A dummy iterator
        //Use a loop to iterate over the list and go to the index
        for(int i = 0; i < index; i ++){
            iter = iter.next;
        }
        return iter;
    }

    //Method to remove data
    public Object removeFirst(){
        //Check if there is data to be removed, if not return null
        if(size == 0){	//size 0 indicates no data in the linkedlist
            return null;
        }
        MovieNode removed = head.next;
        head.next = head.next.next;
        size--;
        return removed.data;
    }

    //Helper method to display the contents of the linkedlist
    public void printList(){
        MovieNode temp = head;		//Iterator
        System.out.print("Data: ");
        while(temp.next != null){		//While theres data
            System.out.print(temp.next.data + "->");	//Print the data
            temp = temp.next;							//Point to the next MovieNode
        }
        System.out.println();						//Go to the next line
    }

    //Printing a linkedlist in reverse
    public void printReverse(MovieNode head){
        if(head.next == null){						//Base case
            System.out.print(head.data + "<-");
            return;
        }
        printReverse(head.next);					//Recursive program
        System.out.print(head.data + "<-");
    }

    public int getSize()
    {
        return size;
    }
}
