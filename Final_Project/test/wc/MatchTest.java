package wc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MatchTest {
	
	//test data 
	int year = 1930;
	String host = "Uruguay";
	String stage = "Group 1";
	String stadium = "Estadio Centenario";
	String city = "Montevideo";
	int attendance = 2000;
	String homeTeamName = "Chile";
	int homeTeamGoals = 1;
	String awayTeamName = "France";
	int awayTeamGoals = 0;
	String winConditions = "ET";
	int halfTimeHomeGoals = 0;
	int halfTimeAwayGoals = 0;
	String homeTeamInitials = "CHI";
	String awayTeamInitials = "FRA";
	
	Match m1;

	/**
	 * test for constructor  and the toString case, for appropriate arguments
	 */
	@Test
	void testConstructor() {
		
		Match m2 = new Match(year, host, stage, stadium, city, attendance, 
			    homeTeamName, homeTeamGoals, awayTeamGoals, awayTeamName,  winConditions, 
				halfTimeHomeGoals, halfTimeAwayGoals, homeTeamInitials, awayTeamInitials);
		
		String expected = "Match [year=1930, host=Uruguay, stage=Group 1, stadium=Estadio Centenario, city=Montevideo, "
				+ "attendance=2000, homeTeamName=Chile, homeTeamGoals=1, awayTeamName=France, awayTeamGoals=0, "
				+ "winConditions=ET, halfTimeHomeGoals=0, halfTimeAwayGoals=0, homeTeamInitials=CHI, awayTeamInitials=FRA]";
		String actual = m2.toString();
		assertEquals(expected, actual);
	}
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		m1 = new Match();
		
	}

	/**
	 * Test for getters and setters for year variable with correct input type
	 */
	@Test
	void testYear() {
		int expected = 1954;
		m1.setYear(expected);
		int actual = m1.getYear();
		assertEquals(expected, actual);
	}
	
	/**
	 * Test for getters and setters for host variable with correct input type
	 */
	@Test
	void testHost() {
		String expected = "Uruguay";
		m1.setHost(expected);
		String actual = m1.getHost();
		assertEquals(expected, actual);
	}
	
	/**
	 * Test for getters and setters for stage variable with correct input type
	 */
	@Test
	void testStage() {
		String expected = "Group 1";
		m1.setStage(expected);
		String actual = m1.getStage();
		assertEquals(expected, actual);
	}

	/**
	 * Test for getters and setters for stadium variable with correct input type
	 */
	@Test
	void testStadium() {
		String expected = "Estadio Centenario";
		m1.setStadium(expected);
		String actual = m1.getStadium();
		assertEquals(expected, actual);
	}
	
	/**
	 * Test for getters and setters for stadium variable with correct input type
	 */
	@Test
	void testCity() {
		String expected = "Montevideo";
		m1.setCity(expected);
		String actual = m1.getCity();
		assertEquals(expected, actual);
	}
	
	/**
	 * Test for getters and setters for attendance variable with correct input type
	 */
	@Test
	void testAttendance() {
		int expected = 2000;
		m1.setAttendance(expected);
		int actual = m1.getAttendance();
		assertEquals(expected, actual);
	}
	
	/**
	 * Test for getters and setters for homeTeamName variable with correct input type
	 */
	@Test
	void testHomeTeamName() {
		String expected = "Chile";
		m1.setHomeTeamName(expected);
		String actual = m1.getHomeTeamName();
		assertEquals(expected, actual);
	}
	
	/**
	 * Test for getters and setters for homeTeamGoals variable with correct input type
	 */
	@Test
	void testHomeTeamGoals() {
		int expected = 1;
		m1.setHomeTeamGoals(expected);
		int actual = m1.getHomeTeamGoals();
		assertEquals(expected, actual);
	}
	
	/**
	 * Test for getters and setters for awayTeamGoals variable with correct input type
	 */
	@Test
	void testAwayTeamGoals() {
		int expected = 0;
		m1.setAwayTeamGoals(expected);
		int actual = m1.getAwayTeamGoals();
		assertEquals(expected, actual);
	}
	
	/**
	 * Test for getters and setters for awayTeamName variable with correct input type
	 */
	@Test
	void testAwayTeamName() {
		String expected = "France";
		m1.setAwayTeamName(expected);
		String actual = m1.getAwayTeamName();
		assertEquals(expected, actual);
	}
	
	/**
	 * Test for getters and setters for winConditions variable with correct input type
	 */
	@Test
	void testwinConditions() {
		String expected = "ET";
		m1.setWinConditions(expected);
		String actual = m1.getWinCondition();
		assertEquals(expected, actual);
	}
	
	/**
	 * Test for getters and setters for halfTimeHomeGoals variable with correct input type
	 */
	@Test
	void testHalfTimeHomeGoals() {
		int expected = 0;
		m1.setHalfTimeHomeGoals(expected);
		int actual = m1.getHalfTimeHomeGoals();
		assertEquals(expected, actual);
	}
	
	/**
	 * Test for getters and setters for halfTimeAwayGoals variable with correct input type
	 */
	@Test
	void testHalfTimeAwayGoals() {
		int expected = 0;
		m1.setHalfTimeAwayGoals(expected);
		int actual = m1.getHalfTimeAwayGoals();
		assertEquals(expected, actual);
	}
	
	/**
	 * Test for getters and setters for HomeTeamInitials variable with correct input type
	 */
	@Test
	void testHomeTeamInitials() {
		String expected = "CHI";
		m1.setHomeTeamInitials(expected);
		String actual = m1.getHomeTeamInitials();
		assertEquals(expected, actual);
	}
	
	/**
	 * Test for getters and setters for awayTeamInitials variable with correct input type
	 */
	@Test
	void testAwayTeamInitials() {
		String expected = "FRA";
		m1.setAwayTeamInitials(expected);
		String actual = m1.getAwayTeamInitials();
		assertEquals(expected, actual);
	}
	
	
	
	
}
