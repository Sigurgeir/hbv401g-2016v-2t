import java.util.*;

public class Flight_mockobject {

	private final String flightNr;
	private String departureTime;
	private String departureLoc;
	private int price;
	private String arrivalLoc;
	private ArrayList<String> dealerInfo = new ArrayList<String>();

	public Flight_mockobject(String flightnr, String depTime, String depLoc, String arrivLoc, int price_kr, ArrayList<String> sellerInfo) {
		flightNr = flightnr;
		departureTime = depTime;
		departureLoc = depLoc;
		arrivalLoc = arrivLoc;
		price = price_kr;
		dealerInfo = sellerInfo;
	}

	// Get methods for all the attributes
	public int get_price() {return price; }
	public String get_depTime() { return departureTime; }
	public String get_depLoc() { return departureLoc; }
	public String get_arrivLoc() { return arrivalLoc; }
	public ArrayList<String> get_dealerInfo() { return dealerInfo; }
	public String get_flightNr() {return flightNr; }
}
