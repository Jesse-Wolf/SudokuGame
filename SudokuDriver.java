//file:SudokuDriver.java
//Author:Jesse Wolf	
//Purpose:To drive my Sudoku game program.
//Pre: My main program is called Sudoku and corresponding classes are UserInput, Game, Grid, Player, and FileIO.
//Post: The program has successfully used this driver and other classes to play a game of sudoku.
//Date: 10 Dec 2017

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

/**
 *To start my entire program. Initiates FileIO and Player class, feeding user data to Game class
 *that runs a full iteration of the game. Then get user data thats been altered and export 
 *back to file. 
 */
public class SudokuDriver {
		public static void main (String[] args){
			String userName;
			int userTotal;
			int userGames;
			String fileName = "info.txt";
			
			//Initiate FileIO object, assuming fileName is predetermined.
			FileIO inOut1 = new FileIO (fileName);
			userName = inOut1.getCurrentUserName();
			userTotal = inOut1.getCurrentUserTotal();
			userGames = inOut1.getCurrentUserGames();
			  //System.out.println("After inOut data is: " + userName + " " + userTotal + " " + userGames);
			//Initiate Player object to hold currentUser data in static variables
			Player player1 = new Player(userName, userTotal, userGames);		
			//Play (Initiate Game object)
			Game game1 = new Game();
			userName = player1.getUser();
			userTotal = player1.getScore();
			userGames = player1.getGames();
			  //System.out.println("Current data is: " + userName + " " + userTotal + " " + userGames);
			//Update userData and save all to file. 
			inOut1.updateUserData(userName, userTotal, userGames);
			inOut1.saveToFile();
				
	   }
}