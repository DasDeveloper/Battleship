
import java.util.HashMap;



//This class will be used as a tool to help the game run smoothly.
//It will help prevent repetitive line of codes in the main class.
public class Battleship_TOOLS  {
	
	//This methods checks the validity of a position entered by the user.
	//If it's not between A and H && 1 and 8.
	public static boolean PositionValidity(String position) { 
		String position_letter = position.substring(0, 1);
		String position_number = position.substring(1, 2);
		if((position_letter.equals("A") || (position_letter.equals("B")) || (position_letter.equals("C")) || (position_letter.equals("D"))
				|| (position_letter.equals("E")) || (position_letter.equals("F")) || (position_letter.equals("G")) || (position_letter.equals("H"))))
		{
				if(position_number.equals("1") || position_number.equals("2") || position_number.equals("3") || position_number.equals("4") 
						|| position_number.equals("5") || position_number.equals("6") || position_number.equals("7") || position_number.equals("8")){           	
					return true;
				}
				else {
					System.out.println("sorry, coordinate out of grid. try again.");
					return false;	
				}
			}
		else {
				System.out.println("sorry, coordinate out of grid. try again.");
				return false;
			}
       }
	
	//This method returns an integer between 1 and 8.
	public static Integer randomNumberGenerator() {
		int max = 8; 
        int min = 1; 
        int range = max - min + 1;
		int number = (int)(Math.random() * range) + min;
		return number;  
	}
	
	//This method checks if there's a winner. We take 3 inputs, the amount of ships remaning of the user and the computer and a boolean
	//If either of their ships remaining equals to 0, the method returns a boolean (false).
	public static boolean isGameOn(int user, int computer, boolean isGameOn) {
		if (user==0) {
			System.out.println("Computer wins!");
			isGameOn=false;
		}
		else if(computer==0) {
			System.out.println("You win!");
			isGameOn=false;
		}
		return isGameOn;
	}
	
	
	//This method converts a number to a letter(for coordinates) and returns the value.
	public static String numberConverter(int position_number) {
		HashMap<Integer, String> grid_index = new HashMap<Integer, String>();
		grid_index.put(1, "A");
		grid_index.put(2, "B");	
		grid_index.put(3, "C");
		grid_index.put(4, "D");
		grid_index.put(5, "E");
		grid_index.put(6, "F");
		grid_index.put(7, "G");
		grid_index.put(8, "H");
		
		return grid_index.get(position_number);
	}
	
	//This method converts a letter to a number(for coordinates) and returns the value.
	public static Integer letterConverter(String position_letter) {
		HashMap<String, Integer> coordinate_converter = new HashMap<String, Integer>();
		coordinate_converter.put("A", 1);
		coordinate_converter.put("B", 2);
		coordinate_converter.put("C", 3);
		coordinate_converter.put("D", 4);
		coordinate_converter.put("E", 5);
		coordinate_converter.put("F", 6);
		coordinate_converter.put("G", 7);
		coordinate_converter.put("H", 8);
		
		return coordinate_converter.get(position_letter);
	}
	
	
	
}
