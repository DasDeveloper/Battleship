
import java.util.HashMap;


//This class is used to create the grid and add certain functionalities to the game.
public class Battleship_Game_Grid{
	
		int row=9;  //#Rows in the grid 
		int col=9;  //#Columns in the grid
		
		HashMap<Integer, String> grid_index = new HashMap<Integer, String>();  //This is a hashmap what will help convert numbers to letter for the main grid. 
		
		public String[][] grid = new String[row][col];   //Creating a 2 dimensions array of strings called grid(For the visual)
		public String[][] backendGrid = new String[row][col]; //Creating a 2 dimensions array of strings called back end grid (
		
		
		//This method creates the main grid.
		public void createGrid() {
			
			for(row=1; row<=8; row++) {
				for(col=1; col<=8; col++) {
					grid[row][col] = "_";
				}
			}
				
			for(row=0,col=1; col<=8; col++) {
				grid_index.put(1, "A");
				grid_index.put(2, "B");	
				grid_index.put(3, "C");
				grid_index.put(4, "D");
				grid_index.put(5, "E");
				grid_index.put(6, "F");
				grid_index.put(7, "G");
				grid_index.put(8, "H");
				grid[row][col] = "" + grid_index.get(col) + "";
			}
					
			
			for(col=0,row=1; row<=8; row++) {
				grid[row][col] = "" + row + "";
				}
				
			}
		
		//This method creates the backend grid where all the gameplay happens. (Not shown to the user)
		public void createBackendGrid() {
			for(row=1; row<=8; row++) {
				for(col=1; col<=8; col++) {
					backendGrid[row][col]= null;
				}
			}
			
			for(col=0,row=1; row<=8; row++) {
				backendGrid[row][col] = "" + row + "";
				}
			
			for(row=0,col=1; col<=8; col++) {
				grid_index.put(1, "A");
				grid_index.put(2, "B");	
				grid_index.put(3, "C");
				grid_index.put(4, "D");
				grid_index.put(5, "E");
				grid_index.put(6, "F");
				grid_index.put(7, "G");
				grid_index.put(8, "H");
				backendGrid[row][col] = "" + grid_index.get(col) + "";
			}
			
		}
		
		//This method checks if a position is empty(null). This will be useful when we get inputs from the user and the computer  
		//to place the ships and grenades.
		public boolean isLocEmpty(int row, int col) {
			
			if(backendGrid[row][col] == null) {
				return true;
			}
			else {
				return false;
				}
		}
		
		//This method prints the main grid (visual). 
		
		public void printGrid() {
			
			System.out.println("  " + grid[0][1] + " " + grid[0][2]+ " " +  grid[0][3] + " " + grid[0][4] + " " + grid[0][5] + " " + grid[0][6] + " " +grid[0][7] + " " + grid[0][8]);
			
			for(int row=1; row<=8; row++) {
				System.out.println(grid[row][0]+ " " + grid[row][1] + " " + grid[row][2]+ " " +  grid[row][3] + " " + grid[row][4] + " " + grid[row][5] + " " + grid[row][6] + " " +grid[row][7] + " " + grid[row][8]);	
			}
		}
		
		
		
	
	
	
	

}



//Map 
//	0 1 2 3 4 5 6 7 8 9
//0[  A B C D E F G H 
//1	1 
//2 2
//3 3
//4 4
//5 5
//6 6
//7 7
//8 8
//9	 
