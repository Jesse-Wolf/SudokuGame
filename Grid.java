//file:Grid.java
//Author:Sean Conti
//Purpose:To output the gameboard for Sudoku
//Pre: 
//Post: 
//Date: November 29, 2017
public class Grid 
{
                  
    int [][] currentGrid;   
    
    // This is the answer key for all difficulties    
    private int easySolution [][] = 		{
    								  	  {8,4,6,1,9,3,7,1,1,5,2},
    									  {3,1,9,1,6,2,5,1,8,4,7},
    									  {7,5,2,1,1,8,4,1,9,6,3},
    									  {2,8,5,1,7,1,1,1,6,9,4},
    									  {4,6,3,1,8,5,9,1,2,7,1},
    									  {9,7,1,1,2,4,6,1,3,8,5},
    									  {1,2,7,1,5,9,8,1,4,3,6},
    								 	  {6,3,8,1,4,7,1,1,5,2,9},
    									  {5,9,4,1,3,6,2,1,7,1,8},
    										};
    
       
    private int mediumSolution [][] = 		{
    									  {9,3,6,1,5,1,7,1,4,2,8},
										  {4,7,2,1,8,6,3,1,1,5,9},
										  {1,5,8,1,2,9,4,1,6,7,3},
										  {8,1,4,1,7,2,5,1,9,3,6},
										  {7,6,3,1,9,4,1,1,2,8,5},
										  {2,9,5,1,3,8,6,1,7,4,1},
										  {5,8,1,1,6,7,2,1,3,9,4},
										  {6,2,9,1,4,3,8,1,5,1,7},
										  {3,4,7,1,1,5,9,1,8,6,2},    	    	    	    	
											};
    
    private int hardSolution [][] = 	    {
    									  {1,3,2,1,8,6,9,1,4,5,7},
										  {4,9,5,1,3,7,1,1,6,8,2},
										  {6,8,7,1,4,5,2,1,1,9,3},
										  {7,4,6,1,9,8,3,1,2,1,5},
										  {8,2,9,1,7,1,5,1,3,6,4},
										  {3,5,1,1,6,2,4,1,8,7,9},
										  {2,1,4,1,5,9,8,1,7,3,6},
										  {5,6,8,1,2,3,7,1,9,4,1},
										  {9,7,3,1,1,4,6,1,5,2,8},    	    	
											 };    
       		
	
	private int gridTemplate [][] =			{
										  {0,0,0,1,0,0,0,1,0,0,0},
										  {0,0,0,1,0,0,0,1,0,0,0},
										  {0,0,0,1,0,0,0,1,0,0,0},
										  {0,0,0,1,0,0,0,1,0,0,0},
										  {0,0,0,1,0,0,0,1,0,0,0},
										  {0,0,0,1,0,0,0,1,0,0,0},
										  {0,0,0,1,0,0,0,1,0,0,0},
										  {0,0,0,1,0,0,0,1,0,0,0},
										  {0,0,0,1,0,0,0,1,0,0,0},
										  };
         

// User would choose whether E = easy, M = medium, H = hard for the difficulty
public Grid(String difficulty){
	char d;
	d = difficulty.charAt(0);
	if (d == 'e' || d == 'E'){
		currentGrid = easySolution;
	}
	else if (d == 'm' || d == 'M'){
		currentGrid = mediumSolution;
	}
	else if (d == 'h' || d == 'H'){
		currentGrid = hardSolution;
	}
	
}    

public int [][] getCurrentGrid(){
	return currentGrid;
}    
    
/*public void setCurrentGrid(String difficulty){
	if (difficulty=="e"||difficulty=="E"){
		currentGrid = easy;
	}
	else if(difficulty=="m"||difficulty=="M"){
		currentGrid = medium;
	}
	else{
		currentGrid = hard;
	}
	
}*/


    
// This would output the spacing for the grid                                    
public static void displayGrid (int x [][])
{

			System.out.println("Row is horizontal, Column is vertical.");
			for(int row = 0; row < x.length; row++)
			{
				if(row == 3 || row == 6)
				{
					System.out.print(" ");
				}
				for(int column = 0; column < x[row].length; column++)
				{
			 		if(column == 3|| column == 7)
					{
					System.out.print(" ");
					}
			 	else
			 		{
			 		System.out.print(x[row][column] + " " );
			 		}						
				}
			
				System.out.println();	
			}
		  
}
		 


		//Return in a way that prevents leaks
		public int[][] getPlayerGridEasy()
		{
			return easySolution;
		}

		public int[][] getPlayerGridMedium()
		{
			return mediumSolution;
		}

		public int[][] getPlayerGridHard()
		{
			return hardSolution;
		}

		//Finish method
		public void setPlayerGridEasy()
		{
			
			
		}

	

}