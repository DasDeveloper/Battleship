


//This program simulates a simplified version of the game BATTLESHIP (Player vs computer).
//The game starts with the user entering coordinates for his ships and his grenades.
//The computer will then generate random locations and place his ships and grenades.
//The main game will then start and prompt the user to start by asking a coordinate.
//A while loop will be used to maintain the game and check if there's a winner.
//We will use custom methods created in the class Battleship_TOOLS to check who wins.
//We use 2 for loops, one for the computer and one for the user, to determine how many turns each player has. 
//It will keep going until one player has 0 ships remaining. At the end, it will declare the winner and print the final board with the
//location of all the ships and grenades. 

import java.util.Scanner;

public class BattleShip_Driver {

	public static void main(String[] args) {
		Scanner getPosition = new Scanner(System.in);// Creating a Scanner to get positions from the user
		Battleship_Game_Grid game = new Battleship_Game_Grid(); //Creating the game object and setting up the grid;

		game.createGrid(); //Creating the grid
		game.createBackendGrid(); //Creating the backEnd grid
		
	
		//Gameplay

		
		System.out.println("Hi, let's player Battleship"); //Welcome message
		
		//Setting the user's ship coordinates (6 ships)
		
		for(int setShip=1; setShip<=6; setShip++) {
			
			System.out.print("Enter the coordinates of your ship #" + setShip + ": "); //Prompting the user to enter coordinates
			String coordinates = getPosition.next().toUpperCase(); //Storing the coordinates in a variable
			while(!Battleship_TOOLS.PositionValidity(coordinates)) { //This while loop checks if the position from the user is valid. If not, it will keep asking.
				System.out.print("Enter the coordinates of your ship #" + setShip + ": ");
				coordinates = getPosition.next().toUpperCase(); 
			}
			
			//Converting the coordinate into integers (row and column)
			int row = Integer.parseInt(coordinates.substring(1, 2));  
			int col = Battleship_TOOLS.letterConverter(coordinates.substring(0, 1));
			
			
			//This block of codes checks if the coordinates are empty.
			//1) If not empty, it will prompt the user to enter another new location
			//3) If empty, then it will proceed to put the ship in that location using the back end grid using the string "s".
			if(game.isLocEmpty(row, col)) {
				game.backendGrid[row][col] = "s"; 
			}
			else {
				System.out.println("sorry, coordinates already in use. try again.");
				setShip--;
			}
		}
		
	  //Setting up the user's grenade coordinates (4 grenades)
		for(int setShipGrenade=1; setShipGrenade<=4; setShipGrenade++) {
			System.out.print("Enter the coordinates of your grenade #" + setShipGrenade + ": ");  //Prompting the user to enter coordinates for grenades
			String coordinates = getPosition.next().toUpperCase(); //Storing the coordinates in a variable
			while(!Battleship_TOOLS.PositionValidity(coordinates)) { //Checking if the coordinates are out of grid (valid or not).
				System.out.print("Enter the coordinates of your grenade #" + setShipGrenade + ": ");  //This part asks for the user for the coordinates if the previous coordinate is not valid.
				coordinates = getPosition.next().toUpperCase();
			}
			//Converting the the coordinates into integers (row and col)
			int row = Integer.parseInt(coordinates.substring(1, 2)); 
			int col = Battleship_TOOLS.letterConverter(coordinates.substring(0, 1));
			
			if(game.isLocEmpty(row, col)) {  //Checking if the coordinate has already been used. If not, the program will put the grenade in the backend grid as "g"
				game.backendGrid[row][col] = "g"; 
			}
			else {
				System.out.println("sorry, coordinates already in use. try again.");
				setShipGrenade--;
			}
	}	
		
	 //Setting up the computer ships
		//This block of code generates random coordinates and makes sure the coordinates are not already used.
		//After finding a coordinate that is not used, it will setup the ships in the back end grid.
		for(int setComputerShip=1; setComputerShip<=6; setComputerShip++) {
			
			int row = Battleship_TOOLS.randomNumberGenerator();
			int col = Battleship_TOOLS.randomNumberGenerator();
			while(!game.isLocEmpty(row, col)) {
				row = Battleship_TOOLS.randomNumberGenerator();
				col = Battleship_TOOLS.randomNumberGenerator();
			}
			
			game.backendGrid[row][col] = "S";
		}
		//Setting computer grenade
		//This block of code generates random coordinates and makes sure the coordinates are not already used.
				//After finding a coordinate that is not used, it will setup the grenades in the back end grid.
		for(int setComputerGrenade=1; setComputerGrenade<=4; setComputerGrenade++) {
			int row = Battleship_TOOLS.randomNumberGenerator();
			int col = Battleship_TOOLS.randomNumberGenerator();
			while(!game.isLocEmpty(row, col)) {
				row = Battleship_TOOLS.randomNumberGenerator();
				col = Battleship_TOOLS.randomNumberGenerator();
			}
			
			game.backendGrid[row][col] = "G";
		}
		
		System.out.println();
		System.out.println("OK, the computer placed its ships and grenades at random. Let's play.");
		System.out.println();
		game.printGrid();
		System.out.println();

		
		//main loop game
		
		
		boolean isGameOn = true; //This boolean will be used to determine when the game is finished.
		int user_ship_remaining=6; //This variable stores the amount of the user's ship left.
		int computer_ship_remaining=6; //This variable stores the amount of the computer's ship left. 
		int humanTurn = 1; //This variable will be used to know how many turns the user have (Initialized to 1)
		int computerTurn=1; //This variable will be used to know how many turns the computer have (Initialized to 1)
		
		
		
		
	while(Battleship_TOOLS.isGameOn(user_ship_remaining, computer_ship_remaining, isGameOn)) { // This is the main while loop. It will keep going until one of the players have 0 ships remaining.
		
		computerTurn=1; // This variable is used to reset the number of turns to 1 for the computer. 
		
		//This for loop will run and ask for the position of user's rocket( generally 1 time but if the computer hits a grenade, he will have a second turn)
		for(int currentTurnH=0; currentTurnH<humanTurn; currentTurnH++) {
		System.out.println();
		System.out.print("position of your rocket: ");  //Prompting the user to enter coordinates
		System.out.println();
		String user_position = getPosition.next().toUpperCase();
		System.out.println();
		while(!Battleship_TOOLS.PositionValidity(user_position)) {  //Checking if the coordinate is valid. If not, keep prompting the user to enter a coordinate.
			 
			System.out.print("position of your rocket: ");
			user_position = getPosition.next().toUpperCase();
		}
		
		//Storing the coordinate in two variable
		int row = Integer.parseInt(user_position.substring(1, 2));
		int col = Battleship_TOOLS.letterConverter(user_position.substring(0, 1));
		
		
		//Checking different situation based on the coordinate.
		//If the coordinate is represents null, it will print out a star on the main grid and "CALLED" on the back end grid.
		//If this coordinate is a ship, it will reduce the number of ships remaining by 1 (Depending if it's user's ship or computer's ship.
		//If this coordinate is a grenade, a turn will be granted depending on who's grenade it is.
		//If the position was already called, the program will just print out that it has been called.
		
		//*** The main grid will be used only for the visual. The back end grid is where all the actions happen. 
		//If the computer hits a grenade( his or opponent), the user will get an extra turn. The same thing happends if the user hits a grenade. 
		
		if(game.backendGrid[row][col] == null) {
			game.backendGrid[row][col] = "CALLED";
			System.out.println("nothing");
			game.grid[row][col] = "*";
		}
		else if(game.backendGrid[row][col] == "g") {
			game.backendGrid[row][col] = "CALLED";
			computerTurn++;
			System.out.println("boom, grenade");
			game.grid[row][col] = "g";
				
		}else if(game.backendGrid[row][col] == "G") {
			game.backendGrid[row][col] = "CALLED";
			computerTurn++;
			System.out.println("boom, grenade");
			game.grid[row][col] = "G";
		}
		else if(game.backendGrid[row][col] == "s") {
			game.backendGrid[row][col] = "CALLED";
			System.out.println("You sunk your own ship!");
			user_ship_remaining-=1;
			game.grid[row][col] = "s";
		}
		else if(game.backendGrid[row][col] == "S") {
			game.backendGrid[row][col] = "CALLED";
			computer_ship_remaining-=1;
			System.out.println("ship hit!");
			game.grid[row][col] = "S";
		}
		else if(game.backendGrid[row][col] == "CALLED") {
			game.backendGrid[row][col] = "CALLED";
			System.out.println("position already called.");
		}
		System.out.println();
		game.printGrid();
		System.out.println();
		
		} // End of for loop for Humans
		
		if(!Battleship_TOOLS.isGameOn(user_ship_remaining, computer_ship_remaining, isGameOn)) {   //This checks if the number of remaining ships is equal to 0 mid-game. This will declare the winner immediately. 
			break; 
		}
		
		humanTurn=1; // This variable is used to reset the number of turns to 1 for the user.
		
		//Checking different situation based on the coordinate.
		//If the coordinate is represents null, it will print out a star on the main grid and "CALLED" on the back end grid.
		//If this coordinate is a ship, it will reduce the number of ships remaining by 1 (Depending if it's user's ship or computer's ship.
		//If this coordinate is a grenade, a turn will be granted depending on who's grenade it is.
		//If the position was already called, the program will just print out that it has been called.
		//After a ship or grenade or an empty location is called, we replace that location with a string "CALLED".
		// "*" represents a empty location has been hit.
		
		for(int currentTurnC = 0; currentTurnC<computerTurn; currentTurnC++) {
			System.out.println();
			
			int row = Battleship_TOOLS.randomNumberGenerator(); //Storing a random value between 1 and 8.
			int col = Battleship_TOOLS.randomNumberGenerator();
			String position_letter = Battleship_TOOLS.numberConverter(col);
			String position_number = String.valueOf(row);
			
			System.out.print("position of my rocket: " + position_letter+position_number);
			System.out.println();
			
			if(game.backendGrid[row][col] == null) {
				game.backendGrid[row][col] = "CALLED";
				System.out.println();
				System.out.println("nothing");
				game.grid[row][col] = "*";
			}
			else if(game.backendGrid[row][col] == "g") {
				game.backendGrid[row][col] = "CALLED";
				humanTurn++;
				System.out.println();
				System.out.println("boom, grenade");
				game.grid[row][col] = "g";
					
			}else if(game.backendGrid[row][col] == "G") {
				game.backendGrid[row][col] = "CALLED";
				humanTurn++;
				System.out.println();
				System.out.println("boom, grenade");
				game.grid[row][col] = "G";
			}
			else if(game.backendGrid[row][col] == "s") {
				game.backendGrid[row][col] = "CALLED";
				System.out.println();
				System.out.println("ship hit!");
				game.grid[row][col] = "s";
			}
			else if(game.backendGrid[row][col] == "S") {
				game.backendGrid[row][col] = "CALLED";
				System.out.println();
				System.out.println("I sunk my own ship!");
				game.grid[row][col] = "S";
			}
			else if(game.backendGrid[row][col] == "CALLED") {
				game.backendGrid[row][col] = "CALLED";
				System.out.println();
				System.out.println("position already called.");
			}
			System.out.println();
			game.printGrid();
			System.out.println();
			
			} // End of for loop for computer
		
	}//End of main while loop
	
	//Printing the final grid
	//This block reveals the ships and grenades that has not been hit from the main grid. 
	System.out.println();
	
	for (int row=1; row<=8; row++) {
		for(int col=1; col<=8; col++) {
			if(game.backendGrid[row][col] == "s" ) {
				game.grid[row][col] = "s";
			}
			else if(game.backendGrid[row][col] == "S" ) {
				game.grid[row][col] = "S";
			}
			else if(game.backendGrid[row][col] == "G" ) {
				game.grid[row][col] = "G";
			}
			else if(game.backendGrid[row][col] == "g" ) {
				game.grid[row][col] = "g";
			}
			else if(game.grid[row][col] == "*") {
				game.grid[row][col] = "_";
			}
		}
	}
		game.printGrid(); //Printing the final grid 
		getPosition.close();	//Closing the scanner. 
	}
}








