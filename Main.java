//Isha Sinha
//CSC311
public class Main {
    public static void main(String[] args) {
        MovieTicket myTicket = new MovieTicket();
	    MovieStack Winchester = myTicket.createMovie("Winchester");
	    MovieStack Madmax = myTicket.createMovie("Madmax");
        MovieStack PacificRim = myTicket.createMovie("PacificRim");
        MovieStack TombRaider = myTicket.createMovie("TombRaider");
        MovieStack DeathWish = myTicket.createMovie("DeathWish");
        myTicket.movieMenu(Winchester,Madmax,PacificRim,TombRaider,DeathWish);
    }
}
