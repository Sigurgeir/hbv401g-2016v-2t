import java.util.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class test_FlightBooking {

	@Before
	public void setUp() {
		ArrayList<String> wow_info = new ArrayList<String>();
		wow_info.add("WOW air");
		wow_info.add("Katrínartún 12 - 105 Reykjavik");
		wow_info.add("Kt. 451011-0220");
		wow_info.add("Vsknr. 109354");
		Flight_mockobject mittflug = new Flight_mockobject("AAV321", "09:00 1.jan", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking prufubokun = new FlightBooking(mittflug, "23E", "Sigurgeir");
	}

	@After
	public void tearDown() throws Exception {
		Flight_mockobject mittflug = null;
		FlightBooking prufubokun = null;
		ArrayList<String> wow_info = null;
	}

	@Test
	public void setCorrectSeatTest() {

		ArrayList<String> wow_info = new ArrayList<String>();
		wow_info.add("WOW air");
		wow_info.add("Katrínartún 12 - 105 Reykjavik");
		wow_info.add("Kt. 451011-0220");
		wow_info.add("Vsknr. 109354");
		Flight_mockobject mittflug = new Flight_mockobject("AAV321", "09:00 1.jan", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking prufubokun = new FlightBooking(mittflug, "23E", "Sigurgeir");
		prufubokun.setSeat("33A");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void setWrongSeatTest() {
		ArrayList<String> wow_info = new ArrayList<String>();
		wow_info.add("WOW air");
		wow_info.add("Katrínartún 12 - 105 Reykjavik");
		wow_info.add("Kt. 451011-0220");
		wow_info.add("Vsknr. 109354");
		Flight_mockobject mittflug = new Flight_mockobject("AAV321", "09:00 1.jan", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking prufubokun = new FlightBooking(mittflug, "23E", "Sigurgeir");
		prufubokun.setSeat("1");
	}
	
	@Test
	public void setCorrectLuggage() {
		ArrayList<String> wow_info = new ArrayList<String>();
		wow_info.add("WOW air");
		wow_info.add("Katrínartún 12 - 105 Reykjavik");
		wow_info.add("Kt. 451011-0220");
		wow_info.add("Vsknr. 109354");
		Flight_mockobject mittflug = new Flight_mockobject("AAV321", "09:00 1.jan", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking prufubokun = new FlightBooking(mittflug, "23E", "Sigurgeir");
		prufubokun.setLuggage(3);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void setWrongLuggage() {
		ArrayList<String> wow_info = new ArrayList<String>();
		wow_info.add("WOW air");
		wow_info.add("Katrínartún 12 - 105 Reykjavik");
		wow_info.add("Kt. 451011-0220");
		wow_info.add("Vsknr. 109354");
		Flight_mockobject mittflug = new Flight_mockobject("AAV321", "09:00 1.jan", "Akureyri", "Reykjavík", 12000, wow_info);
		FlightBooking prufubokun = new FlightBooking(mittflug, "23E", "Sigurgeir");
		prufubokun.setLuggage(-3);
	}

}
