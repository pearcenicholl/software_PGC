package wc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Stats {

	/**
	 * Main method to generate an ArrayList containing class objects of the class 'Match'. this contains all available information on a given world cup match from a given csv file.
	 * @param args
	 */
	public static void main(String[] args) {
		String line;
		try {
			// create file object
			File file = new File ("WorldCupMatches.csv");
			// create file reader object
			FileReader filereader = new FileReader(file.getName());
			BufferedReader bufferReader = new BufferedReader(filereader);
			
			ArrayList <Match> allMatches = new ArrayList<Match>();
			
			//read contents
			String headerLine = bufferReader.readLine(); //remove headerline - unused
			line = bufferReader.readLine(); //read firstline before loop begins
			
			while (line != null) {
				//Acquire values for the match class
				String[] matchData = line.split(",");

				//pass to constructor
				Match match = new Match(matchData[0], matchData[1], matchData[2], matchData[3], matchData[4], matchData[5], matchData[6], 
						matchData[7], matchData[8], matchData[9], matchData[10], matchData[11], matchData[12], matchData[13], matchData[14]);
				
				allMatches.add(match); //add match to arraylist for later use
				line = bufferReader.readLine();	
			}
			
			//close all
			bufferReader.close();
			filereader.close();
			/*
			 * All method calls
			 */
			printAllMatches(allMatches);
			attendanceValues(allMatches);
			resultsByYear(allMatches, 1998);
			resultsByCountry(allMatches, "Spain");
			finalsResults(allMatches);
			goalValues(allMatches);
			attendanceLimits(allMatches);
			extraTimeMatches(allMatches);
			penaltyMatches(allMatches);
			percentageLeadingWins(allMatches);
			
		} catch(FileNotFoundException noFile) {
			System.out.println("The input file is not found.");
		} catch(IOException e) {
			e.printStackTrace();
		} finally { System.out.println("Program End.....");}
	}
	
	/**
	 * Method to print all variables of each match to screen
	 * @param allMatches
	 */
	public static void printAllMatches(ArrayList<Match> allMatches){
		try{
			if(allMatches == null) { 
				throw new NullPointerException(); // throw error if arrayList is null
			} else if(allMatches.size() == 0){
				System.out.println("There are no records found."); //tell user if the arraylist is empty
			}
			for (Match match : allMatches) {
				System.out.println(match.toString());
			}
		}catch(NullPointerException nullPrint) { //catch nullPointerException
			System.err.print(nullPrint);
		}catch(Exception e) { //catch all other errors
			System.out.println("An unknown error has occurred.");
			e.printStackTrace();
		}
	}
	
	/**
	 * method to output the total and average attendances across all world cup matches
	 * @param allMatches
	 */
	public static void attendanceValues (ArrayList<Match> allMatches){
		int totalAttendance = 0;
		double totalMatches = 0;
		double averageAttendance;
		
		try {
			if(allMatches == null) { 
				throw new NullPointerException(); // throw error if arrayList is null
			} else if(allMatches.size() == 0){
				System.out.println("There are no records found."); //tell user if the arraylist is empty
			} else {
				for (Match match : allMatches) {
					totalAttendance += match.getAttendance();
					totalMatches++;
				}
				averageAttendance = (totalAttendance)/(totalMatches);
				System.out.println("Total attendances in all WCs: " + totalAttendance);
				System.out.printf("Average Attendences: %.2f\n", averageAttendance);
			}
		}catch(NullPointerException nullAttendance) { //catch nullPointerException
			System.err.print(nullAttendance);
		}catch(Exception e) { //catch all other errors
			System.out.println("An unknown error has occurred.");
			e.printStackTrace();
		}
	}
	
	/**
	 * method to return the results of every match in a year specified by the searchedYear argument
	 * @param allMatches
	 * @param searchedYear
	 */
	public static void resultsByYear (ArrayList<Match> allMatches, int searchedYear){			
		boolean isYearValid = false;
		String currentHost = "";
		
		try {
			if(allMatches == null) { 
				throw new NullPointerException(); // throw error if arrayList is null
			} else if(allMatches.size() == 0){
				System.out.println("There are no records found."); //tell user if the arraylist is empty
			} else if(searchedYear == 0) {
				System.out.println("The year being searched for is not valid.");
			} else {
				for (Match match : allMatches) { //first this loop checks if the year is valid
					if(match.getYear() == searchedYear) {
						isYearValid = true; 
						currentHost = match.getHost();
					}  //close if statement
				}//close for loop
				if (isYearValid) { //check if the year was valid
					System.out.printf("All matches in WC %s %d\n", currentHost, searchedYear);
				}else {System.out.printf("There was no world cup in the year %d.\n", searchedYear); //tell user if the year had no matches
				} 
				for (Match match : allMatches) { //if year is valid, print every match in that year
					if(match.getYear() == searchedYear) {
						System.out.printf("%s %d : %s %d \n", match.getHomeTeamName(), match.getHomeTeamGoals(), match.getAwayTeamName(), match.getAwayTeamGoals());
					}//close if statement
				}//close for loop
			}//close error if statement
		}catch(NullPointerException nullAttendance) { //catch nullPointerException
			System.err.print(nullAttendance);
		}catch(Exception e) { //catch all other errors
			System.out.println("An unknown error has occurred.");
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to output every world cup match a country has participated in
	 * @param allMatches
	 * @param searchedCountry
	 */
	public static void resultsByCountry (ArrayList<Match> allMatches, String searchedCountry){
		boolean isCountryValid = false;
		try {
			if(allMatches == null) { 
				throw new NullPointerException(); // throw error if arrayList is null
			} else if(allMatches.size() == 0){
				System.out.println("There are no records found."); //tell user if the arraylist is empty
			}else {
					for (Match match : allMatches) { //check if country is valid
						if((searchedCountry.equalsIgnoreCase(match.getHomeTeamName())) || (searchedCountry.equalsIgnoreCase(match.getAwayTeamName()))) {
							isCountryValid = true;
						} 
					}
					if (isCountryValid) { //if it was valid
						System.out.printf("Matches %s have played in the WC. \n", searchedCountry); //print header line
						for (Match match : allMatches) { //print all matches the country has played in
							if((searchedCountry.equalsIgnoreCase(match.getHomeTeamName())) || (searchedCountry.equalsIgnoreCase(match.getAwayTeamName()))) {
								System.out.printf("%s %d : %s %d \n", match.getHomeTeamName(), match.getHomeTeamGoals(), match.getAwayTeamName(), match.getAwayTeamGoals());
							}
						}
					}else{System.out.printf("%s has never played in the WC.\n", searchedCountry); //print if country was not found
					}
				}
		}catch(NullPointerException nullAttendance) { //catch nullPointerException
			System.err.print(nullAttendance);
		}catch(Exception e) { //catch all other errors
			System.out.println("An unknown error has occurred.");
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to check if a country has played in a world cup, and print all matches they played
	 * @param allMatches
	 */
	public static void finalsResults (ArrayList<Match> allMatches){
		try {
			if(allMatches == null) { 
				throw new NullPointerException(); // throw error if arrayList is null
			} else if(allMatches.size() == 0){
				System.out.println("There are no records found."); //tell user if the arraylist is empty
			}else {
				for (Match match : allMatches) {
					if(match.getStage().equalsIgnoreCase("Final")) { //check if it is a final match
						System.out.printf("%d %s \n%s %d : %s %d \n", match.getYear(), match.getHost(), match.getHomeTeamName(), match.getHomeTeamGoals(), match.getAwayTeamName(), match.getAwayTeamGoals());
					}
				}
			}
			}catch(NullPointerException nullAttendance) { //catch nullPointerException
				System.err.print(nullAttendance);
			}catch(Exception e) { //catch all other errors
				System.out.println("An unknown error has occurred.");
				e.printStackTrace();
			}
	}
	
	/**
	 * Method to calculate the total goals scored in all world cup match, and the average goals per match
	 * @param allMatches
	 */
	public static void goalValues (ArrayList<Match> allMatches){
		int totalGoals = 0;
		double totalMatches = 0;
		double averageGoals;
		try {
			if(allMatches == null) { 
				throw new NullPointerException(); // throw error if arrayList is null
			} else if(allMatches.size() == 0){
				System.out.println("There are no records found."); //tell user if the arraylist is empty
			}else {
				for (Match match : allMatches) { //ADD both teams goals to variable
					totalGoals += match.getHomeTeamGoals();
					totalGoals += match.getHomeTeamGoals();
					totalMatches++; //keep track of all matches
				}
				averageGoals = (totalGoals)/(totalMatches); 
				System.out.println("Total Goals in all WCs: " + totalGoals);
				System.out.printf("Average Goals in a WC match : %.2f\n", averageGoals);
			}
		}catch(NullPointerException nullAttendance) { //catch nullPointerException
			System.err.print(nullAttendance);
		}catch(Exception e) { //catch all other errors
			System.out.println("An unknown error has occurred.");
			e.printStackTrace();
		}
	}
	
	public static void attendanceLimits (ArrayList<Match> allMatches){
		int lowestAttendance = 100000;
		int largestAttendance = 0;
		try {
			if(allMatches == null) { 
				throw new NullPointerException(); // throw error if arrayList is null
			} else if(allMatches.size() == 0){
				System.out.println("There are no records found."); //tell user if the arraylist is empty
			}else {
				System.out.println("Attendances");
				for (Match match : allMatches) {
					if(match.getAttendance() > largestAttendance) { //check if attendance is larger than the last largest value
						largestAttendance = match.getAttendance();
					}
					//need a second if statement for lower limits: if else would lead to complications
					if(match.getAttendance() < lowestAttendance) { //check if attendance is lower than the last lower value
						lowestAttendance = match.getAttendance();
					}	
				}
				
				for (Match match : allMatches) {//print values
					if(match.getAttendance() == largestAttendance) {
						System.out.printf("Largest attendance  %d \n%s %d %s %s %s vs %s\n\n", largestAttendance, match.getHost(), match.getYear(), match.getStadium(), match.getHost(), match.getHomeTeamInitials(), match.getAwayTeamInitials());
					} else if(match.getAttendance() == lowestAttendance) {
						System.out.printf("Smallest attendance %d \n%s %d %s %s %s vs %s\n\n", lowestAttendance, match.getHost(), match.getYear(), match.getStadium(), match.getHost(), match.getHomeTeamInitials(), match.getAwayTeamInitials());
					}	
				}
			}
		}catch(NullPointerException nullAttendance) { //catch nullPointerException
			System.err.print(nullAttendance);
		}catch(Exception e) { //catch all other errors
			System.out.println("An unknown error has occurred.");
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to check if a match was in extra time and output values for those matches
	 * @param allMatches
	 */
	public static void extraTimeMatches (ArrayList<Match> allMatches){
		try {
			if(allMatches == null) { 
				throw new NullPointerException(); // throw error if arrayList is null
			} else if(allMatches.size() == 0){
				System.out.println("There are no records found."); //tell user if the arraylist is empty
			}else {
				System.out.println("ET games");
				for (Match match : allMatches) {
					if(match.getWinCondition().equalsIgnoreCase("ET")) { //check if game was in extra time
						System.out.printf("%d %s %s\n%s %d : %s %d \n\n", match.getYear(), match.getHost(), match.getStage(), match.getHomeTeamName(), match.getHomeTeamGoals(), match.getAwayTeamName(), match.getAwayTeamGoals());
					}
				}
			}
		}catch(NullPointerException nullAttendance) { //catch nullPointerException
			System.err.print(nullAttendance);
		}catch(Exception e) { //catch all other errors
			System.out.println("An unknown error has occurred.");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Method to check if a match went to penalties and output match values
	 * @param allMatches
	 */
	public static void penaltyMatches (ArrayList<Match> allMatches){
		try {
			if(allMatches == null) { 
				throw new NullPointerException(); // throw error if arrayList is null
			} else if(allMatches.size() == 0){
				System.out.println("There are no records found."); //tell user if the arraylist is empty
			}else {
				System.out.println("Games that went to penalties"); //CHECK IF GAME WAS IN PENALTIES
				for (Match match : allMatches) {
					if((match.getWinCondition().equalsIgnoreCase("HWP"))||(match.getWinCondition().equalsIgnoreCase("AWP"))) {
						System.out.printf("%d %s %s\n%s %d : %s %d\n", match.getYear(), match.getHost(), match.getStage(), match.getHomeTeamName(), match.getHomeTeamGoals(), match.getAwayTeamName(), match.getAwayTeamGoals());
					}
					if(match.getWinCondition().equalsIgnoreCase("HWP")) { //check for winner, then output final line
						System.out.println("Winner : "+match.getHomeTeamInitials()+"\n\n");
					} else if(match.getWinCondition().equalsIgnoreCase("AWP")) {
						System.out.println("Winner : "+match.getAwayTeamInitials()+"\n\n");
					}
				}
			}
		}catch(NullPointerException nullAttendance) { //catch nullPointerException
			System.err.print(nullAttendance);
		}catch(Exception e) { //catch all other errors
			System.out.println("An unknown error has occurred.");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Method to find the percentage of matches where the team leading at half time won the match
	 * @param allMatches
	 */
	public static void percentageLeadingWins (ArrayList<Match> allMatches){
		String halfTimeWinner;
		double totalMatches = 0;
		int numberOfLeaderWins = 0;
		double percentageOfLeaderWins;
		try {
			if(allMatches == null) { 
				throw new NullPointerException(); // throw error if arrayList is null
			} else if(allMatches.size() == 0){
				System.out.println("There are no records found."); //tell user if the arraylist is empty
			}else {
				for (Match match : allMatches) {
					totalMatches += 1; //keep track of matches
					if (match.getHalfTimeAwayGoals() > match.getHalfTimeHomeGoals()) { //check who was winning at half time
						halfTimeWinner = "Away";
					} else if(match.getHalfTimeAwayGoals() < match.getHalfTimeHomeGoals()) {
						halfTimeWinner = "Home";
					} else {halfTimeWinner = "Draw";}
					
					switch(halfTimeWinner) { //check if the leading team one
					case "Away" : if(match.getAwayTeamGoals()>match.getHomeTeamGoals()) {
									numberOfLeaderWins ++;
								}
					case "Home" : if(match.getHomeTeamGoals()>match.getAwayTeamGoals()) {
									numberOfLeaderWins ++;
								}
					}
				}
				percentageOfLeaderWins = (100 * numberOfLeaderWins)/totalMatches;
				System.out.printf("The percentage of games won by the team that were leading at half time is %.2f \n", percentageOfLeaderWins);
			}
		}catch(NullPointerException nullAttendance) { //catch nullPointerException
			System.err.print(nullAttendance);
		}catch(Exception e) { //catch all other errors
			System.out.println("An unknown error has occurred.");
			e.printStackTrace();
		}
	}
	

	
}
