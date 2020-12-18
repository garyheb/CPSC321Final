//imports
import java.io.*;
import java.util.Scanner;

import AddRecords.AddCoach;
import Functions.getInt;
import Update.UpdateCoach;
import Update.UpdateDefense;
import Update.UpdateOffense;
import Update.UpdateQB;
import Update.UpdateTeam;

import java.sql.*;  
import java.util.Properties;
import ViewTables.*;

//java -cp .;C:\Folder\mysql-connector.jar Homework9

class Homework9{
	
	static String Input;
	
	//this is the main menu for the program
	public static void mainMenu(){
		try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		System.out.println("1. View Records");
		System.out.println("2. Add Records");
		System.out.println("3. Update Records");
		System.out.println("4. Delete Records");
		System.out.println("5. Exit");
		System.out.print("Enter your choice (1-5):");
		int InputInt = getInt.getInt();
		execute( InputInt );

	}
	
	//main 
	public static void main(String[] args)
	{
		mainMenu();
	}

	//this code determines which option the user has selected and goes to the appropriate function
	public static void execute(int userInput)
	{
		if(userInput == 1)
		{
			Option1();
		}

		else if(userInput == 2)
		{
			Option2();
		}

		else if(userInput == 3)
		{
			Option3();
		}

		else if(userInput == 4)
		{
			Option4();
		}

		else if(userInput == 5)
		{
			Option5();
		}
		
		else
		{
			System.out.println("Error");
			mainMenu();
		}
	}

	// view tables
	public static void Option1(){
		System.out.println("1. View All Players On a Team");
		System.out.println("2. View Teams");
		System.out.println("3. View Quarterbacks");
		System.out.println("4. View Offensive Players");
		System.out.println("5. View Defensive Players");
		System.out.println("6. View Head Coaches");
		System.out.println("7. Go Back to Main Menu");
		System.out.print("Enter your choice (1-6):");
		int InputInt = getInt.getInt();
		executeOption1( InputInt );
	}

	// add to tables
	public static void Option2()
	{
		System.out.println("1. Add to Teams");
		System.out.println("2. Add to Quarterbacks");
		System.out.println("3. Add to Offensive Players");
		System.out.println("4. Add to Defensive Players");
		System.out.println("5. Add to Head Coaches");
		System.out.println("6. Go Back to Main Menu");
		System.out.print("Enter your choice (1-6):");
		int InputInt = getInt.getInt();
		executeOption2( InputInt );
	}
	
	// update tables
	public static void Option3(){
		System.out.println("1. Update Teams");
		System.out.println("2. Update Quarterbacks");
		System.out.println("3. Update Offensive Players");
		System.out.println("4. Update Defensive Players");
		System.out.println("5. Update Head Coaches");
		System.out.println("6. Exit");
		System.out.print("Enter your choice (1-6):");
		int passMe = getInt.getInt();
		executeOption3(passMe);
	}

	// Delete row from table
	public static void Option4()
	{
        System.out.println("1. Delete Coach");
		System.out.println("2. Delete Defensive Player");
		System.out.println("3. Delete Offensive Player");
		System.out.println("4. Delete Quarterback");
		System.out.println("5. Exit");
		System.out.print("Enter your choice (1-5):");
		int passMe = getInt.getInt();
		executeOption4(passMe);
		mainMenu();
	}

		
	// Exit
	public static void Option5()
	{
		System.exit(0);
	}
	
	// this code determines which option the user has selected from view records and goes to the appropriate function
	public static void executeOption1(int userInput)
	{
		if (userInput == 1){
			ViewAllPlayers.ViewAllPlayers();
			System.out.println();
			mainMenu();
		}
		else if(userInput == 2)
		{
			Teams.ViewTeams();
			System.out.println();
			mainMenu();
		}

		else if(userInput == 3)
		{
			ViewQuarterback.ViewQuarterback();
			System.out.println();
			mainMenu();
		}

		else if(userInput == 4)
		{
			ViewOffensivePlayers.ViewOffensivePlayers();
			System.out.println();
			mainMenu();
		}

		else if(userInput == 5)
		{
			ViewDefensivePlayers.ViewDefensivePlayers();
			System.out.println();
			mainMenu();
		}

		else if(userInput == 6)
		{
			ViewHeadCoach.ViewHeadCoach();
			System.out.println();
			mainMenu();
		}
		
		else if(userInput == 7)
		{
		    mainMenu();	
		}
		
		else
		{
			System.out.println("Error");
			mainMenu();
		}
	}

	// this code determines which option the user has selected from view records and goes to the appropriate function
	public static void executeOption2(int userInput)
	{
		if (userInput == 1){
			ViewAllPlayers.ViewAllPlayers();
			System.out.println();
			mainMenu();
		}
		else if(userInput == 2)
		{
			Teams.ViewTeams();
			System.out.println();
			mainMenu();
		}

		else if(userInput == 3)
		{
			ViewQuarterback.ViewQuarterback();
			System.out.println();
			mainMenu();
		}

		else if(userInput == 4)
		{
			ViewOffensivePlayers.ViewOffensivePlayers();
			System.out.println();
			mainMenu();
		}

		else if(userInput == 5)
		{
			AddCoach.AddCoach();
			System.out.println();
			mainMenu();
		}
		
		else if(userInput == 6)
		{
		    mainMenu();	
		}
		
		else
		{
			System.out.println("Error");
			mainMenu();
		}
	}

	// choose table to update
	public static void executeOption3(int Input)
	{		
		switch (Input){
			case 1:
				UpdateTeam.UpdateTeam();
				mainMenu();
				break;
			case 2:
				UpdateQB.UpdateQB();
				mainMenu();
				break;
			case 3:
				UpdateOffense.UpdateOffense();
				mainMenu();
				break;
			case 4:
				UpdateDefense.UpdateDefense();
				mainMenu();
				break;
			case 5:
				UpdateCoach.UpdateCoach();
				mainMenu();
				break;
			default:
				mainMenu();
				break;
	}

	// choose table to delete
	public static void executeOption4(int Input)
	{		
		switch (Input){
			case 1:
				UpdateTeam.UpdateTeam();
				mainMenu();
				break;
			case 2:
				UpdateQB.UpdateQB();
				mainMenu();
				break;
			case 3:
				UpdateOffense.UpdateOffense();
				mainMenu();
				break;
			case 4:
				UpdateDefense.UpdateDefense();
				mainMenu();
				break;
			case 5:
				UpdateCoach.UpdateCoach();
				mainMenu();
				break;
			default:
				mainMenu();
				break;
	}
  }

}


