/**
 * @(#)Player.java
 *
 * Player application
 *
 * @author Wyatt Boublil
 * 2017/12/5
 */
 
import java.util.Scanner;


public class Player
{
	 
	static String currentUser;
	
	static int currentScore;
	
	static int currentGames;
	
	private Scanner input = new Scanner(System.in);
	
	public Player(){	
	}
	
	/**
	 *Constructor sets up current user data (current username, score and number of games)
	 *
	 *@param String user, int score, int games
	 */
	public Player(String user, int score, int games){
		currentUser = user;
		currentScore = score;
		currentGames = games;
		 //System.out.println("Current User Data is: " + currentUser + " " + currentScore + " " + currentGames);
	}
	
	/**
	 *set current user data 
	 *
	 *@param int score, int games
	 */
	public void setCurrentUserData(int score, int games)
	{
		currentScore = score;
			
		currentGames = games;
	}
		
	/**
	 *@return currentUser(current user name)
	 */	
	public String getUser()
	{
		return currentUser;
	}
	
	/**
	 *@return currentScore
	 */	
	public int getScore()
	{
		return currentScore;
	}
	
	/**
	 *@return currentGames
	 */	
	public int getGames()
	{
		return currentGames;
	}
}