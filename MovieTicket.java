//Isha Sinha
//CSC311 
import java.util.Scanner;


public class MovieTicket
{
    private double totalPrice;
    private boolean freePopc;
    private String movieName;
    private static Scanner input = new Scanner(System.in);
    private double costWinchester;
    private double costMadmax;
    private double costPacificRim;
    private double costTombRaider;
    private double costDeathWish;
	
	
	public MovieStack createMovie(String movie)								
    {

        int size=(int)(Math.random()*5+2);
        MovieStack myStack = new MovieStack(size);
        return generateTickets(myStack,size,movie);
    }
    

    public MovieTicket(double totalPrice,boolean freePopc,String movie)
    {
        this.totalPrice=totalPrice;
        this.freePopc=freePopc;
        movieName=movie;
    }

    
	public MovieTicket()
    {
        totalPrice=0;
        freePopc=false;
    }
    public void  moviesAvailible(MovieStack Winchester,MovieStack Madmax, MovieStack PacificRim, MovieStack TombRaider, MovieStack DeathWish)	//method to show available movies
    {
		System.out.println("~~~~~~~~~~~Movies Available Today~~~~~~~~~~~~~~~");							
        if(Winchester.peek()!=null)
            System.out.println("Winchester is Available");
        if(Madmax.peek()!=null)
            System.out.println("Madmax is Available");
        if(PacificRim.peek()!=null)
            System.out.println("Pacific Rim is Available");
        if(TombRaider.peek()!=null)
            System.out.println("Tomb Raider is Available");
        if(DeathWish.peek()!=null)
            System.out.println("Death Wish is Available");

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    public MovieStack generateTickets(MovieStack myStack,int size,String movie)		//method to geneerate tickets
    {
        double cost = Math.random()*10+10;				//creates random cost

        for(int i=0;i<size;i++)
        {
            int check = (int) (Math.random() * 3 + 1);		//creates condition for popcorn status
            boolean popcorn;
            if (check % 2 == 0)
                popcorn = false;
            else
                popcorn = true;

            MovieTicket myTic = new MovieTicket(cost, popcorn,movie);	//accepts cost, popcorn status,movie respecitvely 
            myStack.push(myTic);
        }
        return myStack;
    }

    //Overloaded Method
    public MovieStack generateTickets(MovieStack myStack,int size,String movie,double cost)				
    {
        for(int i=0;i<size;i++)
        {
            int check = (int) (Math.random() * 3 + 1);
            boolean popcorn;
            if (check % 2 == 0)
                popcorn = false;
            else
                popcorn = true;

            MovieTicket myTic = new MovieTicket(cost, popcorn,movie);
            myStack.push(myTic);
        }
        myStack.movieDisplay();
        return myStack;
    }

    public void refundTickets(MovieStack Winchester,MovieStack Madmax, MovieStack PacificRim,MovieStack TombRaider, MovieStack DeathWish)		//method to refund tickets
    {
        boolean exitName = false;
        boolean exitNum = false;
        int ticketNo = 0;
        String movieName = "";
        MovieTicket tempTicket;
        double cost=0;
        MovieStack tempStack;
        while (!exitName)                                                                    // Checking error to make sure valid movie title has been entered
        {
            System.out.println("~~~~~~~~~~~~~~List of Movies~~~~~~~~~~~~~~~~");
            System.out.println("Winchester| Madmax | Pacific Rim | Tomb Raider | Death Wish");
            System.out.println("Please enter the Movie you would ike to refund");
            movieName = input.nextLine();
            movieName = movieName.toLowerCase();
            if (movieName.equals("winchester") || movieName.equals("madmax") || movieName.equals("pacific rim") || movieName.equals("tomb raider") || movieName.equals("death wish")) {
                exitName = true;
            }
        }

        while (!exitNum)                                                                       //Error checking to make sure valid number is entered
        {
            System.out.println("Please enter how many tickets you would like to return. A max of 5 at a time.");
            ticketNo = input.nextInt();
            input.nextLine();
            if (ticketNo > 0 && ticketNo < 6)
                exitNum = true;
            else
                System.out.println("Error. You entered an incorrect number. Please enter a number between 1-5");
        }
        tempStack= new MovieStack(ticketNo);
        int count=0;
        switch (movieName)												//switch cases for refund for movies and update stacks 
        { 
            case "winchester":
                {
                    tempStack = generateTickets(tempStack,ticketNo,"Winchester",costWinchester);
                    for (int i = 0; i < ticketNo; i++)
                    {
                        if(!Winchester.isFull())
                        {
                            Winchester.push(tempStack.pop());
                            count++;
                        }
                    }
                    System.out.println("We were able to refund only "+count+" Tickets.");
                    break;
                }
            case "madmax":
            {
                tempStack = generateTickets(tempStack,ticketNo,"Madmax",costWinchester);
                for (int i = 0; i < ticketNo; i++)
                {
                    if(!Madmax.isFull())
                    {
                        Madmax.push(tempStack.pop());
                        count++;
                    }
                }
                System.out.println("We were able to refund only "+count+" Tickets.");
                break;
            }
            case "pacific rim":
            {
                tempStack = generateTickets(tempStack,ticketNo,"Pacific Rim",costWinchester);
                for (int i = 0; i < ticketNo; i++)
                {
                    if(!PacificRim.isFull())
                    {
                        PacificRim.push(tempStack.pop());
                        count++;
                    }
                }
                System.out.println("We were able to refund only "+count+" Tickets.");
                break;
            }
            case "tomb raider":
            {
                tempStack = generateTickets(tempStack,ticketNo,"tomb raider",costWinchester);
                for (int i = 0; i < ticketNo; i++)
                {
                    if(!TombRaider.isFull())
                    {
                        TombRaider.push(tempStack.pop());
                        count++;
                    }
                }
                System.out.println("We were able to refund only "+count+" Tickets.");
                break;
            }
            case "death wish":
            {
                tempStack = generateTickets(tempStack,ticketNo,"Death Wish",costWinchester);
                for (int i = 0; i < ticketNo; i++)
                {
                    if(!DeathWish.isFull())
                    {
                        DeathWish.push(tempStack.pop());
                        count++;
                    }
                }
                System.out.println("We were able to refund only "+count+" Tickets.");
                break;
            }
            default:
                System.out.println("Error. Please enter a movie that is showing today.");
        }
    }

    public void purchaseTicket(MovieStack Winchester,MovieStack Madmax, MovieStack PacificRim,MovieStack TombRaider, MovieStack DeathWish)	//method to purchase MovieTicket
    {
        boolean exitName = false;
        boolean exitNum = false;
        int freePop = 0;
        double totalCost=0;
        String movieName="";
        MovieTicket tempTicket;
        while(!exitName)                                                                    //to ensure if valid movieName has been entered
        {
            System.out.println("~~~~~~~~~~~~~~~~~Movies for Today~~~~~~~~~~~~~~~~");
            System.out.println("Winchester| Madmax| Pacific Rim | Tomb Raider | Death Wish");
            System.out.println("Please enter a Movie");
            movieName = input.nextLine();
            movieName = movieName.toLowerCase();
            if(movieName.equals("winchester") || movieName.equals("madmax") || movieName.equals("pacific rim") || movieName.equals("tomb raider") || movieName.equals("death wish"))
            {
                exitName=true;
            }

        }
        int ticketNo=0;
        while(!exitNum)                                                                       //To check if valid number has been entered
        {
                System.out.println("Please enter how many tickets you want to purchase. A maximum of 5 at a time.");
                ticketNo= input.nextInt();
                input.nextLine();
                if(ticketNo>0 && ticketNo<6)
                    exitNum=true;
                else
                    System.out.println("Error. You have entered an incorrect number. Please enter a valid number between 1-5");
					
        }
        MovieStack temp = new MovieStack(ticketNo);
        switch (movieName)										//switch cases for purchasing tickets, displaying the total cost and free popcorn status
        {
            case "winchester":
                for(int i = 0;i<ticketNo;i++)
                {
                    if(Winchester.peek()!=null)
                    {
                        totalCost = totalCost+ costWinchester;			//updates the total
                        tempTicket =(MovieTicket)Winchester.peek();
                        if(tempTicket.freePopc)
                            freePop++;
                        temp.push(Winchester.pop());
                        if(i==ticketNo-1)
                        {
                            System.out.printf("Total Cost of the tickets are: %.2f\n",totalCost);
                            System.out.println("You received "+freePop+" Free Popcorn on your MovieTicket");
                        }
                    }
                    else {
                        System.out.println("Error. Sorry, there are not enough tickets available for this movie.\nThere are only " + i + " tickets available.");
                        moviesAvailible(Winchester,Madmax,PacificRim,TombRaider,DeathWish);
                        while(!temp.empty())
                        {
                            Winchester.push(temp.pop());
                        }
                        break;
                    }
                }

                break;
            case "madmax":
                for(int i=0;i<ticketNo;i++)
                {
                    if(Madmax.peek()!=null)
                    {
                        tempTicket =(MovieTicket)Madmax.peek();
                        if(tempTicket.freePopc)
                            freePop++;
                        totalCost = totalCost+ costMadmax;
                        temp.push(Madmax.pop());
                        if(i==ticketNo-1)
                        {
                            System.out.printf("Total of all tickets are: %.2f\n",totalCost);
                            System.out.println("You received "+freePop+" Free  order(s) of Popcorn for your MovieTicket");
                        }
                    }
                    else
                    {
                        System.out.println("Error. Sorry, there are not enough tickets available for this movie.\nThere are only " + i + " tickets available.");
                         moviesAvailible(Winchester,Madmax,PacificRim,TombRaider,DeathWish);
                        while(!temp.empty())
                        {
                            Madmax.push(temp.pop());
                        }
                        break;
                    }
                }
                break;
            case "pacific rim":
                for(int i=0;i<ticketNo;i++)
                {
                    if(PacificRim.peek()!=null)
                    {
                        tempTicket =(MovieTicket)PacificRim.peek();
                        if(tempTicket.freePopc)
                            freePop++;
                        totalCost = totalCost+ costPacificRim;
                        temp.push(PacificRim.pop());
                        if(i==ticketNo-1)
                        {
                            System.out.printf("Total Cost of the tickets are: %.2f\n",totalCost);
                            System.out.println("You received "+freePop+" Free Popcorn on your MovieTicket");
                        }
                    }
                    else
                    {
                        System.out.println("Error. Sorry, there are not enough tickets available for this movie.\nThere are only " + i + " tickets available.");
                         moviesAvailible(Winchester,Madmax,PacificRim,TombRaider,DeathWish);
                        while(!temp.empty())
                        {
                            PacificRim.push(temp.pop());
                        }
                        break;
                    }
                }
                break;
            case "tomb raider":
                for(int i=0;i<ticketNo;i++)
                {
                    if(TombRaider.peek()!=null)
                    {
                        tempTicket =(MovieTicket)TombRaider.peek();
                        if(tempTicket.freePopc)
                            freePop++;
                        totalCost = totalCost+ costTombRaider;
                        temp.push(TombRaider.pop());
                        if(i==ticketNo-1)
                        {
                            System.out.printf("Total Cost of the tickets are: %.2f\n",totalCost);
                            System.out.println("You received "+freePop+" Free Popcorn on your MovieTicket");
                        }
                    }
                    else
                    {
                        System.out.println("Error. Sorry, there are not enough tickets available for this movie.\nThere are only " + i + " tickets available.");
                         moviesAvailible(Winchester,Madmax,PacificRim,TombRaider,DeathWish);
                        while(!temp.empty())
                        {
                            TombRaider.push(temp.pop());
                        }
                        break;
                    }
                }
                break;
            case "death wish":
                for(int i=0;i<ticketNo;i++)
                {
                    if(DeathWish.peek()!=null)
                    {
                        tempTicket =(MovieTicket)DeathWish.peek();
                        if(tempTicket.freePopc)
                            freePop++;
                        totalCost = totalCost+ costDeathWish;
                        temp.push(DeathWish.pop());
                        if(i==ticketNo-1)
                        {
                            System.out.printf("Total Cost of the tickets are: %.2f\n",totalCost);
                            System.out.println("You received "+freePop+" Free Popcorn on your MovieTicket");
                        }
                    }
                    else
                    {
                        System.out.println("Error. Sorry, there are not enough tickets available for this movie.\nThere are only " + i + " tickets available.");
                         moviesAvailible(Winchester,Madmax,PacificRim,TombRaider,DeathWish);
                        while(!temp.empty())
                        {
                            DeathWish.push(temp.pop());
                        }
                        break;
                    }
                }
                break;
            default:
                System.out.println("Error. Please enter a movie that is showing today.");
        }

    }


    public void movieMenu(MovieStack Winchester,MovieStack Madmax, MovieStack PacificRim,MovieStack TombRaider, MovieStack DeathWish) 	//method for user menu
    {
        MovieLinkedListQueue people = new MovieLinkedListQueue(10);				
        for(int i=0;i<10;i++)
        {
            String x = "Person "+i;
            MovieNode myNode = new MovieNode(x);
            people.enqueue(myNode);
        }
        MovieTicket tempTicket = (MovieTicket)Winchester.peek();
        costWinchester = tempTicket.totalPrice;
        tempTicket = (MovieTicket) Madmax.peek();
        costMadmax = tempTicket.totalPrice;
        tempTicket = (MovieTicket)PacificRim.peek();
        costPacificRim = tempTicket.totalPrice;
        tempTicket = (MovieTicket)TombRaider.peek();
        costTombRaider = tempTicket.totalPrice;
        tempTicket = (MovieTicket)DeathWish.peek();
        costDeathWish = tempTicket.totalPrice;
        boolean exit = false;
        int option;
        while(!exit)
        {
			System.out.println(" ~~~~~~~~Welcome to the LA Movie Theater! Pick an option please~~~~~~~");
            System.out.println("\nEnter [1] to display all shows with at least one MovieTicket\nEnter [2] to buy tickets\nEnter [3] to return tickets\nEnter [4] to exit");
            option=input.nextInt();
            input.nextLine();
            switch(option)				//switch cases for user inputing number options for menu
            {
                case 1:
                    moviesAvailible(Winchester,Madmax,PacificRim,TombRaider,DeathWish);
                    break;
                case 2:
                    purchaseTicket(Winchester,Madmax,PacificRim,TombRaider,DeathWish);
                    break;
                case 3:
                    refundTickets(Winchester,Madmax,PacificRim,TombRaider,DeathWish);
                    break;
				case 4: 
					System.out.println("Come Again soon!");
					break;
                default:
                    System.out.println("Error. Please Enter only from the available options.");
            }
            people.dequeue();

            if((Winchester.empty() && Madmax.empty() && PacificRim.empty() && TombRaider.empty() && DeathWish.empty()) || people.isEmpty())
                exit = true;
        }
        System.out.println("The counter is Closed.");		

    }

    public String toString()						//tostring method
    {
        System.out.println("                  "+movieName);
        System.out.printf("Cost: %.2f\n",totalPrice);
        if(freePopc)
            System.out.println("Popcorn is free");
        else
            System.out.println("Popcorn is not free");
        return"";
    }
}
