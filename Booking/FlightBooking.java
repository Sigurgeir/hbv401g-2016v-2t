//package metaSearchEngine
import java.util.*;

public class FlightBooking extends Booking {

	
	// Define attributes of the class
	private Flight flight;
	private String seatNr;
	private int luggage;
	private boolean flightMeal;

	public FlightBooking(Flight fightSearchResult, String seat, String buyer){
		customer = buyer;		
		flight = fightSearchResult;	
		seatNr = seat;
		luggage = 0;
		flightMeal = false;
		//price = flightSearchResult.price; // Incorrect! How will the get-method be implemented in Flight?
	}

	// Notkun: seatNr = setSeat(seat)
	// Fyrir: seatNr is a string on the form [0-9][0-9][A-F]
	// Eftir: Gildi seatNr hefur verið breytt þ.a það inniheldur nú gildi seat. 
	public void setSeat(String seat)
	{
		if(seat.length() < 2 || seat.length() > 3) throw new IllegalArgumentException("Error: Incorrect format of seatNr");
		seatNr = seat;
	}

	// Notkun: luggage = setLuggage(luggage)
	// Fyrir: luggage er heiltala, má vera núll. Engin efri mörk.
	// Eftir: luggage breytar hefur verið uppfærð í samræmi við inntak. 
	public void setLuggage(int nr_of_bags) {
		if(nr_of_bags < 0) throw new IllegalArgumentException("Please select a positive integer for the number of bags requested");
		else luggage = nr_of_bags;
	}

	// Notkun: flightMeal = setFlightMeal
	public void setFlightMeal(boolean flightfood) {
		flightMeal = flightfood;
	}

	// Usage: getInfo()
	// 
	@Override
	public void getInfo() {
		// We want to call a function (?) to display a window containing the information
		// about the FlightBooking?? 
		// For now I will just print the information to the console.
		System.out.println("Welcome " + customer + "!");
		//System.out.println("This is your booking information");
		//System.out.println("The providers of this trip are " + dealerInfo);
		System.out.println("The price of your booking is " + price + " ISK");
		//System.out.println("Some more information....");
	}

	// The main method is here just for testing purposes.
	public static void main(String[] args){

		FlightBooking prufubokun = new FlightBooking("ABC123", "23E", "Sigurgeir");
		//prufubokun.review = prufubokun.review.add("Terrible flight!");
		//prufubokun.customer = "Sigurgeir";
		prufubokun.price = 20000;
		prufubokun.flightMeal = prufubokun.setFlightMeal(true);
		//prufubokun.getInfo();
		
	}

}
