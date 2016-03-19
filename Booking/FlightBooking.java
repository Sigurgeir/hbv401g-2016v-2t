//package metaSearchEngine
import java.util.*;

public class FlightBooking extends Booking {

	
	// Define attributes of the class
	private Flight_mockobject flight;
	private String seatNr;
	private int luggage;
	private boolean flightMeal;
	private String departureTime;
	private String departureLoc;
	private String arrivalLoc;
	private String flightNr;

	// Constructor:
	public FlightBooking(Flight_mockobject fightSearchResult, String seat, String buyer){
		customer = buyer;		
		flight = fightSearchResult;	
		seatNr = seat;
		luggage = 0;
		flightMeal = false;
		departureTime = flight.get_depTime();
		departureLoc = flight.get_depLoc();
		arrivalLoc = flight.get_arrivLoc();
		price = flight.get_price();
		dealerInfo = flight.get_dealerInfo();
		flightNr = flight.get_flightNr();
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

	// Usage: writeReview("some review text");
	// Before: 
	// After: The new review text has been added to the list of reviews
	void writeReview(String new_review) {
		review.add(new_review);
		// Still need to implement review submission. Not a high priority user story.
	}

	// Usage: getInfo()
	// 
	@Override
	public void getInfo() {
		// We want to call a function (?) to display a window containing the information
		// about the FlightBooking?? 
		// For now I will just print the information to the console.
		System.out.println("Welcome " + customer + "!");
		System.out.println("This is your booking information");
		System.out.println("Your have booked seat " + seatNr + "on flight " + flightNr);
		System.out.println("The price of this booking is " + String.valueOf(price) + " ISK");
		System.out.println("You will be departing for " + arrivalLoc + "from " + departureLoc + " at " + departureTime);
		System.out.println("You have selected to bring " + String.valueOf(luggage) + " bags");
		if(flightMeal==false) System.out.println("You have not ordered a meal in this flight");
		else System.out.println("You have ordered a meal in this flight");
		//System.out.println("Some more information....");
	}

}
