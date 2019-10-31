import java.util.ArrayList;

public class Maze {
	
	public static void main(String[] args) {
		ArrayList<String> route = findCheese(0,0);
		if (route == null) {
			System.out.println("Cheese not found :(");
		}
		else {
			for(String step : route) {
				System.out.println("Next step : " + step);
			}
		}
	}
	
	public static String pp(int[][] maze) {
		String result = "";
		for(int row=0; row<maze.length; row++) {
			for (int col=0; col<maze[row].length; col++) {
				result += maze[row][col]+" ";
			}
			result += "\n";
		}
		return result;
	}

	public static int[][] maze =  
		{ 
				{2, 2, 2, 0, 2, 0 },
				{0, 0, 2, 0, 2, 2 },
				{2, 2, 2, 2, 2, 2 },
				{0, 0, 2, 2, 2, 0 },
				{3, 2, 2, 2, 0, 0 }
		};

	/* Find and return path from position (x,y) to cheese.
	 * Path is an ArrayList<String> containing the sequence of positions (x,y) 
	 * that must be traversed to find the cheese.
	 * if not found return null.
	 */
	public static ArrayList<String> findCheese(int x, int y) {

		if ((x < 0) || (x > 5) || (y<0) || (y>4)) {
			return null;
		}
		// Mouse in inside the maze
		if ((maze[x][y] == 0) || (maze[x][y] == 1)) {
			return null;
		}
		
		if (maze[x][y] == 3) {
			ArrayList<String> resultCheese = new ArrayList<String>();
			resultCheese.add("("+x+","+y+")");
			return resultCheese;
		}
		
		// Mouse in open space
		maze[x][y] = 1; // Mark spacew visited
		
		// Try north route
		ArrayList<String> resultNorth = findCheese(x,  y-1);
		if (resultNorth != null) {
			resultNorth.add("("+x+","+y+")");
			return resultNorth;
		}
		
		// Try east route
		ArrayList<String> resultEast = findCheese(x+1,  y);
		if (resultEast != null) {
			resultEast.add("("+x+","+y+")");
			return resultEast;
		}
		
		// Try south route
		ArrayList<String> resultSouth = findCheese(x,  y+1);
		if (resultSouth != null) {
			resultSouth.add("("+x+","+y+")");
			return resultSouth;
		}

		// Try west route
		ArrayList<String> resultWest = findCheese(x-1,  y);
		if (resultWest != null) {
			resultWest.add("("+x+","+y+")");
			return resultWest;
		}
		return null;
		
	}
}

