package wc;
import java.lang.NullPointerException;
import java.util.InputMismatchException;

public class Match {
	
	/**
	 * A class to store all values associated with a given world cup match
	 */
	
	private int year;
	private String host;
	private String stage;
	private String stadium;
	private String city;
	private int attendance;
	private String homeTeamName;
	private int homeTeamGoals;
	private String awayTeamName;
	private int awayTeamGoals;
	private String winConditions;
	private int halfTimeHomeGoals;
	private int halfTimeAwayGoals;
	private String homeTeamInitials;
	private String awayTeamInitials;
	
	/**
	 * Default constructor that creates class totally uninitialised
	 */
	public Match() {
		
	}
	
	/**
	 * Constructor for class if all variables are available and passed. 
	 * Assign every passed variable to an attribute
	 * @param year
	 * @param host
	 * @param stage
	 * @param stadum
	 * @param city
	 * @param attendance
	 * @param homeTeamName
	 * @param homeTeamGoals
	 * @param awayTeamName
	 * @param awayTeamGoals
	 * @param winConditions
	 * @param halfTimeHomeGoals
	 * @param halfTimeAwayGoals
	 * @param homeTeamInitials
	 * @param awayTeamInitials
	 */
	public Match(int year, String host, String stage, String stadium, String city, int attendance, 
			String homeTeamName, int homeTeamGoals, int awayTeamGoals, String awayTeamName, String winConditions, 
			int halfTimeHomeGoals, int halfTimeAwayGoals, String homeTeamInitials, String awayTeamInitials) {
		setYear(year);
		setHost(host);
		setStage(stage);
		setStadium(stadium);
		setCity(city);
		setAttendance(attendance);
		setHomeTeamName(homeTeamName);
		setHomeTeamGoals(homeTeamGoals);
		setAwayTeamName(awayTeamName);
		setAwayTeamGoals(awayTeamGoals);
		setWinConditions(winConditions);
		setHalfTimeHomeGoals(halfTimeHomeGoals);
		setHalfTimeAwayGoals(halfTimeAwayGoals);
		setHomeTeamInitials(homeTeamInitials);
		setAwayTeamInitials(awayTeamInitials);
	}
	
	/**
	 * Constructor for class if all variables are available and passed as strings. 
	 * Assign every passed variable to an attribute
	 * @param year
	 * @param host
	 * @param stage
	 * @param stadum
	 * @param city
	 * @param attendance
	 * @param homeTeamName
	 * @param homeTeamGoals
	 * @param awayTeamName
	 * @param awayTeamGoals
	 * @param winConditions
	 * @param halfTimeHomeGoals
	 * @param halfTimeAwayGoals
	 * @param homeTeamInitials
	 * @param awayTeamInitials
	 */
	public Match(String year, String host, String stage, String stadium, String city, String attendance, 
			String homeTeamName, String homeTeamGoals, String awayTeamGoals, String awayTeamName, String winConditions, 
			String halfTimeHomeGoals, String halfTimeAwayGoals, String homeTeamInitials, String awayTeamInitials) {
		setYear(Integer.valueOf(year.trim()));
		setHost(host);
		setStage(stage);
		setStadium(stadium);
		setCity(city);
		setAttendance(Integer.valueOf(attendance.trim()));
		setHomeTeamName(homeTeamName);
		setHomeTeamGoals(Integer.valueOf(homeTeamGoals.trim()));
		setAwayTeamName(awayTeamName);
		setAwayTeamGoals(Integer.valueOf(awayTeamGoals.trim()));
		setWinConditions(winConditions);
		setHalfTimeHomeGoals(Integer.valueOf(halfTimeHomeGoals.trim()));
		setHalfTimeAwayGoals(Integer.valueOf(halfTimeAwayGoals.trim()));
		setHomeTeamInitials(homeTeamInitials);
		setAwayTeamInitials(awayTeamInitials);
	}
	
	/**
	 * Auto-generated toString() method
	 */
	public String toString() {
		try {
			return "Match [year=" + year + ", host=" + host + ", stage=" + stage + ", stadium=" + stadium + ", city=" + city
					+ ", attendance=" + attendance + ", homeTeamName=" + homeTeamName + ", homeTeamGoals=" + homeTeamGoals
					+ ", awayTeamName=" + awayTeamName + ", awayTeamGoals=" + awayTeamGoals + ", winConditions="
					+ winConditions + ", halfTimeHomeGoals=" + halfTimeHomeGoals + ", halfTimeAwayGoals="
					+ halfTimeAwayGoals + ", homeTeamInitials=" + homeTeamInitials + ", awayTeamInitials="
					+ awayTeamInitials + "]";
			}catch(NullPointerException stringNull) { //catch if a variable is NULL
				System.out.println("There is an empty variable; cannot print to string");
				stringNull.printStackTrace();
				return "Error";
			}catch(InputMismatchException stringMismatch) { // catch potential type mismatches
				System.out.println("A variable is of the wrong type. String cannot be generated.");
				stringMismatch.printStackTrace();
				return "Error";
			}
	}
	
	/**
	 * Method to set the year variable; must be greater than 1930 (inclusive)
	 * @param year 
	 */
	public void setYear(int year) {
		try {
			if(year >= 1930) {
				this.year = year;
			}else {System.out.println("Invalid year format.");}
		}catch(NullPointerException yearNull) { //catch if variable is NULL
			System.out.println("The year variable is empty.");
			yearNull.printStackTrace();
		}catch(InputMismatchException yearMismatch) { // catch potential type mismatches
			System.out.println("The year variable is of the wrong type.");
			yearMismatch.printStackTrace();
		}
	}
	
	/**
	 * Method to set the host variable; 
	 * must have between 1 and 30 characters
	 * @param host
	 */
	public void setHost(String host) {
		try {
			host = host.trim();
			if((host.length() > 0)&&(host.length() < 30)) {
				this.host = host;
			}else {System.out.println("Host name is invalid.");}
		}catch(NullPointerException hostNull) { //catch if variable is NULL
			System.out.println("The Host name variable is empty.");
			hostNull.printStackTrace();
		}catch(InputMismatchException hostMismatch) { // catch potential type mismatches
			System.out.println("Host name variable is of the wrong type.");
			hostMismatch.printStackTrace();
		}
	}
	
	/**
	 * Method to set the stage variable;
	 * must have between 1 and 50 characters
	 * @param stage
	 */
	public void setStage(String stage) {
		try {
			stage = stage.trim();
			if((stage.length() > 0)&&(stage.length() < 50)) {
				this.stage = stage;
			}else {System.out.println("Invalid stadium name format.");}
		}catch(NullPointerException stageNull) { //catch if variable is NULL
			System.out.println("The Stage name variable is empty.");
			stageNull.printStackTrace();
		}catch(InputMismatchException stageMismatch) { // catch potential type mismatches
			System.out.println("Stage name variable is of the wrong type.");
			stageMismatch.printStackTrace();
		}
	}
	
	/**
	 * Method to set the Stadium variable;
	 * variable must have between 1 and 80 characters
	 * @param stadium
	 */
	public void setStadium(String stadium) {
		try {
			stadium = stadium.trim();
			if((stadium.length() > 0)&&(stadium.length() < 80)) {
				this.stadium = stadium;
			}else {System.out.println("Invalid Stadium name format.");}
		}catch(NullPointerException stadiumNull) { //catch if variable is NULL
			System.out.println("The Stadium name variable is empty.");
			stadiumNull.printStackTrace();
		}catch(InputMismatchException stadiumMismatch) { // catch potential type mismatches
			System.out.println("Stadium name variable is of the wrong type.");
			stadiumMismatch.printStackTrace();
		}
	}
	
	/**
	 * Method to set the city variable;
	 * variable must have between 1 and 40 characters
	 * @param city
	 */
	public void setCity(String city) {
		try {
			city = city.trim();
			if((city.length() > 0)&&(city.length() < 40)) {
				this.city = city;
			}else {System.out.println("Invalid City name format.");}
		}catch(NullPointerException cityNull) { //catch if variable is NULL
			System.out.println("The City name variable is empty.");
			cityNull.printStackTrace();
		}catch(InputMismatchException cityMismatch) { // catch potential type mismatches
			System.out.println("City name variable is of the wrong type.");
			cityMismatch.printStackTrace();
		}
	}
	
	/**
	 * Method to set the attendance variable;
	 * variable must be between 0 and 200000
	 * @param attendance
	 */
	public void setAttendance(int attendance) {
		try {
			if((attendance >= 0)&&(attendance <= 200000)) {
				this.attendance = attendance;
			}else {System.out.println("Invalid number of attendees.");}
		}catch(NullPointerException attendanceNull) { //catch if variable is NULL
			System.out.println("The Attendance variable is empty.");
			attendanceNull.printStackTrace();
		}catch(InputMismatchException attendanceMismatch) { // catch potential type mismatches
			System.out.println("Attendance variable is of the wrong type.");
			attendanceMismatch.printStackTrace();
		}
	}
	
	/**
	 * Method to set the homeTeamName variable;
	 * must have between 1 and 35 characters
	 * @param homeTeamName
	 */
	public void setHomeTeamName(String homeTeamName) {
		try {
			homeTeamName = homeTeamName.trim();
			if((homeTeamName.length() > 0)&&(homeTeamName.length() < 35)) {
				this.homeTeamName = homeTeamName;
			}else {System.out.println("The Home team name is not in a valid format.");}
		}catch(NullPointerException htnNull) { //catch if variable is NULL
			System.out.println("The Home Team name is empty.");
			htnNull.printStackTrace();
		}catch(InputMismatchException htnMismatch) { // catch potential type mismatches
			System.out.println("The Home team name variable is of the wrong type.");
			htnMismatch.printStackTrace();
		}
	}
	
	/**
	 * Method to set the homeTeamGoals variable;
	 * must be between 0 and 15
	 * @param homeTeamGoals
	 */
	public void setHomeTeamGoals(int homeTeamGoals) {
		try {
			if((homeTeamGoals >= 0)&&(homeTeamGoals <= 15)) {
				this.homeTeamGoals = homeTeamGoals;
			}else {System.out.println("The value of home team goals is not valid.");}
		}catch(NullPointerException htgNull) { //catch if variable is NULL
			System.out.println("The Home Team Goals variable is empty.");
			htgNull.printStackTrace();
		}catch(InputMismatchException htgMismatch) { // catch potential type mismatches
			System.out.println("The Home team goals variable is of an incorrect type.");
			htgMismatch.printStackTrace();
		}
	}
	
	/**
	 * Method to set the awayTeamName variable;
	 * must have between 1 and 35 characters
	 * @param awayTeamName
	 */
	public void setAwayTeamName(String awayTeamName) {
		try {
			awayTeamName = awayTeamName.trim();
			if((awayTeamName.length() > 0)&&(awayTeamName.length() < 35)) {
				this.awayTeamName = awayTeamName;
			}else {System.out.println("The away team name is not in a valid format.");}
		}catch(NullPointerException atnNull) { //catch if variable is NULL
			System.out.println("The Away Team name is empty.");
			atnNull.printStackTrace();
		}catch(InputMismatchException atnMismatch) { // catch potential type mismatches
			System.out.println("The Away team name variable is of the wrong type.");
			atnMismatch.printStackTrace();
		}
	}
	
	/**
	 * Method to set the awayTeamGoals variable;
	 * must be between 0 and 15
	 * @param awayTeamGoals
	 */
	public void setAwayTeamGoals(int awayTeamGoals) {
		try {
			if((awayTeamGoals >= 0)&&(awayTeamGoals <= 15)) {
				this.awayTeamGoals = awayTeamGoals;
			}else {System.out.println("The value of Away Team goals is not valid.");}
		}catch(NullPointerException atgNull) { //catch if variable is NULL
			System.out.println("The Away Team Goals variable is empty.");
			atgNull.printStackTrace();
		}catch(InputMismatchException atgMismatch) { // catch potential type mismatches
			System.out.println("The Away team goals variable is of the wrong type.");
			atgMismatch.printStackTrace();
		}
	}
	
	/**
	 * Method to set the winConditions attribute;
	 * must be one of ET, HWP, AWP. This method should not be called if there is no special win condition.
	 * @param winConditions
	 */
	public void setWinConditions(String winConditions) {
		try {
			winConditions = winConditions.trim();
			switch(winConditions){ //switch statement to check if the assigned winCondition is of an acceptable value
			case "ET" : 
				this.winConditions = winConditions;
				break; //break to ensure default case is never called
			case "AWP" : 
				this.winConditions = winConditions;
				break; //break to ensure default case is never called
			case "HWP" : 
				this.winConditions = winConditions;
				break; //break to ensure default case is never called
			case "" :
				this.winConditions = winConditions; //case if the match had no special win condition
				break; //break to ensure default case is never called
			default : System.out.println("Invalid Win Condition."); 
			} 
		}catch(NullPointerException winConNull) { //catch if variable is NULL
			System.out.println("The Win Condition variable is empty. Check the correct constructor has been used.");
			winConNull.printStackTrace();
		}catch(InputMismatchException winConMismatch) { // catch potential type mismatches
			System.out.println("The Win COndition variable is of an incorrect type.");
			winConMismatch.printStackTrace();
		}
	}
	
	/**
	 * Method to set the halfTimeHomeGoals variable;
	 * variable must be between 0 and 15
	 * @param halfTimeHomeGoals
	 */
	public void setHalfTimeHomeGoals(int halfTimeHomeGoals) {
		try {
			if((halfTimeHomeGoals >= 0)&&(halfTimeHomeGoals <= 15)) {
				this.halfTimeHomeGoals = halfTimeHomeGoals;
			}else {System.out.println("Invalid number of half-time home goals.");}
		}catch(NullPointerException hthgNull) { //catch if variable is NULL
			System.out.println("The number of half time home goals is not valid.");
			hthgNull.printStackTrace();
		}catch(InputMismatchException hthgMismatch) { // catch potential type mismatches
			System.out.println("The halfTimeHomeGoals variable is of an incorrect type.");
			hthgMismatch.printStackTrace();
		}
	}
	
	/**
	 * Method to set the halfTimeAwayGoals variable;
	 * must be between 0 and 15
	 * @param halfTimeAwayGoals
	 */
	public void setHalfTimeAwayGoals(int halfTimeAwayGoals) {
		try {
			if((halfTimeAwayGoals >= 0)&&(halfTimeAwayGoals <= 15)) {
				this.halfTimeAwayGoals = halfTimeAwayGoals;
			}else {System.out.println("Invalid number of half-time away goals.");}
		}catch(NullPointerException htagNull) { //catch if variable is NULL
			System.out.println("The number of half time away goals is not valid.");
			htagNull.printStackTrace();
		}catch(InputMismatchException htagMismatch) { // catch potential type mismatches
			System.out.println("The halfTimeAwayGoals variable is of an incorrect type.");
			htagMismatch.printStackTrace();
		}
}
	
	/**
	 * Method to set the homeTeamInitials variable;
	 * must have 3 characters
	 * @param homeTeamInitials
	 */
	public void setHomeTeamInitials(String homeTeamInitials) {
		try {
			homeTeamInitials = homeTeamInitials.trim();
			if(homeTeamInitials.length() == 3) {
				this.homeTeamInitials = homeTeamInitials;
			}else {System.out.println("Invalid home team initials.");}
		}catch(NullPointerException homeTeamInitialsNull) { //catch if variable is NULL
			System.out.println("The home team initials are not valid. Please ensure three letters are used.");
			homeTeamInitialsNull.printStackTrace();
		}catch(InputMismatchException homeTeamInitialsMismatch) { // catch potential type mismatches
			System.out.println("The homeTeamInitials variable is of an incorrect type.");
			homeTeamInitialsMismatch.printStackTrace();
		}
	}
	
	/**
	 * Method to set the awayTeamInitials variable;
	 * must have 3 characters
	 * @param awayTeamInitials
	 */
	public void setAwayTeamInitials(String awayTeamInitials) {
		try {
			awayTeamInitials = awayTeamInitials.trim();
			if(awayTeamInitials.length() == 3) {
				this.awayTeamInitials = awayTeamInitials;
			
			}else {System.out.println("Invalid away team initials.");}
		}catch(NullPointerException awayTeamInitialsNull) { //catch if variable is NULL
			System.out.println("The away team initials are not valid. Please ensure three letters are used.");
			awayTeamInitialsNull.printStackTrace();
		}catch(InputMismatchException awayTeamInitialsMismatch) { // catch potential type mismatches
			System.out.println("The awayTeamInitials variable is of an incorrect type.");
			awayTeamInitialsMismatch.printStackTrace();
		}
	}
	
	

	/**
	 * Returns the year variable of the Match class
	 */
	int getYear() {
		return year;		
	}
	
	/**
	 * Returns the host variable of the Match class
	 */
	public String getHost() {
		return host;
	}
	
	/**
	 * Returns the stage variable of the Match class
	 */
	public String getStage() {
		return stage;
	}
	
	/**
	 * Returns the stadium variable of the Match class
	 */
	public String getStadium() {
		return stadium;
	}
	
	/**
	 * Returns the city variable of the Match class
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Returns the attendance variable of the Match class
	 */
	public int getAttendance() {
		return attendance;
	}
	
	/**
	 * Returns the homeTeamName variable of the Match class
	 */
	public String getHomeTeamName() {
		return homeTeamName;
	}
	
	/**
	 * Returns the homeTeamGoals variable of the Match class
	 */
	public int getHomeTeamGoals() {
		return homeTeamGoals;
	}
	
	/**
	 * Returns the awayTeamName variable of the Match class
	 */
	public String getAwayTeamName() {
		return awayTeamName;
	}
	
	/**
	 * Returns the awayTeamGoals variable of the Match class
	 */
	public int getAwayTeamGoals() {
		return awayTeamGoals;
	}
	
	/**
	 * Returns the winCondition variable of the Match class
	 */
	public String getWinCondition() {
		return winConditions;
	}
	
	/**
	 * Returns the halfTimeHomeGoals variable of the Match class
	 */
	public int getHalfTimeHomeGoals() {
		return halfTimeHomeGoals;
	}
	
	/**
	 * Returns the halfTimeAwayGoals variable of the Match class
	 */
	public int getHalfTimeAwayGoals() {
		return halfTimeAwayGoals;
	}
	
	/**
	 * Returns the homeTeamInitials variable of the Match class
	 */
	public String getHomeTeamInitials() {
		return homeTeamInitials;
	}
	
	/**
	 * Returns the awayTeamInitials variable of the Match class
	 */
	public String getAwayTeamInitials() {
		return awayTeamInitials;
	}

}
