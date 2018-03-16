//File:		UserInput.java
//Author:	Augustine Norte
//Purpose:	
//Pre:		
//Post:		
//Date:		11.27.2017

import java.util.Scanner;

class UserInput{
	
	private Scanner keyboard = new Scanner(System.in);
	private String playerGridSelection;
	private int tempRow;
	private int tempCol;
	private int tempValue;
	private int [][] currentGrid;
	
	private int easy [][] =		 {
										  {8,0,0,1,9,3,0,1,0,0,2},
										  {0,0,9,1,0,0,0,1,0,4,0},
										  {7,0,2,1,1,0,0,1,9,6,0},
										  {2,0,0,1,0,0,0,1,0,9,0},
										  {0,6,0,1,0,0,0,1,0,7,0},
										  {0,7,0,1,0,0,6,1,0,0,5},
										  {0,2,7,1,0,0,8,1,4,0,6},
										  {0,3,0,1,0,0,0,1,5,0,0},
										  {5,0,0,1,0,6,2,1,0,0,8},
										  };
	
	private	int medium [][] =		 {
										  {0,0,0,1,0,0,7,1,0,2,8},
										  {4,7,0,1,0,0,3,1,0,0,0},
										  {0,0,8,1,0,9,4,1,0,7,0},
										  {0,0,4,1,7,0,0,1,9,0,6},
										  {0,6,0,1,0,0,1,1,2,0,0},
										  {0,0,5,1,0,8,0,1,0,0,0},
										  {5,8,0,1,6,0,0,1,0,0,0},
										  {6,0,0,1,0,3,0,1,5,1,0},
										  {0,0,7,1,1,0,0,1,8,0,2},
										  };

	private int hard [][] =		{
										  {0,0,2,1,0,0,0,1,4,5,7},
										  {4,0,0,1,3,0,1,1,0,8,0},
										  {0,0,0,1,0,5,0,1,0,0,0},
										  {0,0,6,1,0,0,0,1,0,0,0},
										  {0,0,0,1,0,0,0,1,3,0,0},
										  {0,0,0,1,0,2,4,1,0,7,9},
										  {0,1,0,1,0,0,8,1,0,0,6},
										  {0,0,0,1,2,0,0,1,9,0,1},
										  {0,0,0,1,0,4,6,1,0,0,0},
										  };
    
    /**
     *Constructor used to initiate the object with current grid 
     *equalling to one of the three difficulties.
     *
     *@param String difficulty
     */
	public UserInput(String difficulty){
		char d;
	    d = difficulty.charAt(0);
	    if (d == 'e' || d == 'E'){
	    	currentGrid = easy;
	    	}
	    else if(d == 'm' || d == 'M'){
	    	currentGrid = medium;
	    	}
	    else if(d == 'h' || d == 'H'){
	    	currentGrid = hard;
	    	}
	   }    
	
	/**
	 *@return current grid
	 */   
	public int [][] getCurrentGrid(){
		return currentGrid;
		}    			
	
	/**
	 *To check my two grids to see if they match, if they do not 
	 *match our game will continue to ask for userinput until they are complete.
	 *
	 *@param int [][] full and int [][] player
	 *
	 *@return true or false, true if the two input arrays do not equal each other. 
	 *false if they do.
	 */
	public boolean checkForFullGrids(int [][] full, int [][] player){
		for (int row=0;row<full.length;row++){
			for (int col=0;col<full[row].length;col++){
				if(full[row][col] != player[row][col]){
					return true;
			    }
		    }
	    }
	    return false;
    }

    /**
     *To set users guess (row, column, and value) 
     */
     public void setUserGuess(){
     	System.out.println("Row:__   Column:__   Value:__  ");
     	System.out.println("Please enter a number with a space between each.\nOr hit enter between each entry.");
     	tempRow = keyboard.nextInt();
	    tempCol = keyboard.nextInt();
	    tempValue = keyboard.nextInt();
	    //In order to match up with actual index for arrays must subtract one
	    if(tempCol < 4){
	    	tempCol = tempCol -1;
	    	}
	    else if(tempCol > 6){
	    	tempCol = tempCol +1;
	    }
	    tempRow = tempRow -1;
	 }

    /**
     *@return tempRow (user input row)
     */
     public int getTempRow(){
     	return tempRow;
     }

    /**
     *@return tempCol (user input column)
     */
     public int getTempCol(){
     	return tempCol;
     }

   /**
    *@return tempValue (user input value)
    */
    public int getTempValue(){
    	return tempValue;
    }

   /**
    *To update the player grid when the users guess is correct. 
    *
    *@param int row, int col, int value
    */
    public void updatePlayerGrid(int row, int col, int value){
    	currentGrid[row][col] = value;
    }

   /**
    *To display my current grid
    */
    public void displayGrid (){
    	for(int row = 0; row < currentGrid.length; row++){
    		if(row == 3 || row == 6){
    			System.out.println(" ");
    		}
    		for(int column = 0; column < currentGrid[row].length; column++){
    			if(column == 3 || column == 7){
    				System.out.print(" ");
    			}
			    else{
			 		System.out.print(currentGrid[row][column] + " " );
			 	}						
			}
		System.out.println();	
		}
	}
}


