public class MovieNode {
    //Data fields
    Object data;	//Data element
    MovieNode next;		//Pointer to the next node in the list
						
								//Constructor for the Node
    public MovieNode(Object data)
    {
        this.data = data;
        this.next = null;
    }
    public String toString()
    {
        System.out.println(data);

        return "";
    }
}