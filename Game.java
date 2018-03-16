/**File Template: Game.java
 *@author Yocelyne Hernandez
 *Date 11/29/2017
 *Pre:Have a main that will use my game methods
 *Post:Class methods will be used for the main method
 *Purpose: To have a class where all my methods are placed in
 */
import java.util.Scanner;

public class Game
{
	//instance variables
	private String difficulty;
	private int currentScore;
	private int currentGames;
	private int tempGuess;
	private int tempScore;
	private String playAgain;
	private boolean playAgainFlag = true;
	private String playerGridSelect;
	private Scanner keyboard = new Scanner(System.in);
	private int [][] fullGrid;
	private int [][] playerGrid;
	private int currentUserTotal; 
	
	
	//Default Constructor Starting Game and running 
	public Game(){
		currentScore=100;
		Player player2 = new Player();
		String currentUser = player2.getUser();
		int currentUserTotal = player2.getScore();
		int currentUserGames = player2.getGames();
		//While player would like to keep playing
		while(playAgainFlag){
			setDifficulty();
			//System.out.println("Difficulty is: " + difficulty);
			Grid mainGrid = new Grid (difficulty);
			UserInput userInput = new UserInput (difficulty);
			//save fullGrid for future objects
			fullGrid = mainGrid.getCurrentGrid();
			/*test phase 
			playerGrid = mainGrid.getCurrentGrid();*/
            playerGrid = userInput.getCurrentGrid();
			//set boolean if both grids match each other 
			//= userInput.checkFullGrids(full);
			while(userInput.checkForFullGrids(fullGrid, playerGrid)){
				System.out.println("Your current score is: " + currentScore);
				System.out.println();
				userInput.displayGrid();
				System.out.println();
				userInput.setUserGuess();
				int userRow = userInput.getTempRow();
				//System.out.println("userRow " + userRow);
				int userCol = userInput.getTempCol();
				//System.out.println("userCol " + userCol);
				int userValue = userInput.getTempValue();
				int tempFullGridValue = fullGrid[userRow][userCol];
				if(userValue == tempFullGridValue){
					//System.out.println("UserValue and tempFullGridValue are: " + userValue + tempFullGridValue);
					userInput.updatePlayerGrid(userRow, userCol, userValue);
					}
				else{
					System.out.println("Your guess was incorrect please try again.");
					changePoints();
					playAgainFlag = false;
				}
			}
			currentGames = player2.getGames();
			int finalGames = currentGames +1;
			int finalScore = currentScore + currentUserTotal;
			player2.setCurrentUserData(finalScore,finalGames);
			//mainGrid.displayGrid(fullGrid);
			//System.out.println(" ");
			//userInput.displayGrid();
			currentUser = player2.getUser();
			currentUserTotal = player2.getScore();
			currentUserGames = player2.getGames();
			//call congrats method
			congrats();
			//System.out.println("Your current userData is: " + currentUser + " " + currentUserTotal + " " + currentUserGames);
			playAgainFlag = playAgain();
			}
		}
	
	
	/**
	 * To ask the user for the difficulty level and set difficulty 
	 *
	 *@param setDifficulty not already defined
	*/
	public void setDifficulty()
	{
		char d;
		do{
			System.out.println("What difficulty would you like: Easy, Medium or Hard?");
			
			String stringD=keyboard.nextLine();
			d = stringD.charAt(0);
			
			if (d=='E'||d=='e'||d=='M'||d=='m'||d=='H'||d=='h'){
				difficulty=String.valueOf(d);
				}
			else{
				System.out.println("Try Again");
			}
		}while(!(d=='E'||d=='e'||d=='M'||d=='m'||d=='H'||d=='h'));
				
	}  
	
	
	/** 
	 * To get difficulty
	 *
	 * @returns difficulty 
	 */ 
	public String getDifficulty()
	{
		return difficulty;
	}
	/** To get current score
	 * 
	 *@returns Current Score
	 */
	public int getCurrentScore()
	{
		return currentScore;
	}
	/**
	 * To change the current score 
	 *
	 *@param changePoints not already defined
	 */
		public void changePoints()
	{
		currentScore=currentScore-1;
	} 
	/**
	 * To ask the user if they want to play again
	 *
	 *@param playAgain not already defined
	 */

	public boolean playAgain()
	{
		char p;
		System.out.println("Would you like to play again? Yes or No?");
		String stringD=keyboard.nextLine();
		p =stringD.charAt(0);
		if (p=='Y'||p=='y'){
			playAgain=String.valueOf(p);
			playAgainFlag=true;
			return playAgainFlag;
		}
		else{
		playAgainFlag=false;
		return playAgainFlag;
		}
	}
	/**
	 *To congratulate the user on finishing the puzzle and tell them their final score
	 *Final games will be updated and final score
	 *@param congrats not already defined
	 */

	public void congrats()
	{
		System.out.println("Congratulations you have finished the puzzle.");
		System.out.println("Your final score was: " + currentScore);
		int finalGames = currentGames +1;
		int finalScore = currentScore + currentUserTotal;
	}
}