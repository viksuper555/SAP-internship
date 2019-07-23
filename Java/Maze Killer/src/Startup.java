import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Startup {

	private static int row[] = {-1, 0, 0, 1};
	private static int col[] = {0, -1, 1, 0};
	
	public static void main(String args[])
	{
		String maze[][] = 	   {{"#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
								{"#", ".", ".", ".", ".", ".", ".", "&", ".", "#"},
								{"#", ".", "#", ".", "#", "#", "#", "#", ".", "#"},
								{"#", ".", ".", "#", ".", "#", ".", "#", ".", "#"},
								{"#", ".", ".", ".", ".", ".", ".", "#", "#", "#"},
								{"#", ".", "#", "#", "#", "#", ".", "#", ".", "#"},
								{"#", ".", "#", ".", ".", ".", ".", "#", ".", "#"},
							 	{"#", "#", "#", "#", "#", ".", "#", "#", ".", "#"},
							 	{"#", ".", "~", ".", ".", ".", ".", ".", ".", "#"},
							 	{"#", "#", "#", "#", "#", "#", "#", "#", "#", "#"}};
		
		Rocket rocket = findRocket(maze);
		
		System.out.println(search(maze, rocket).trace.distance);
		int i = 0;
		for(var coordinate : search(maze, rocket).trace.coordinates)
		{
			
			System.out.printf("%d x: %d y: %d \n",i,coordinate.x, coordinate.y);
			i++;
			
		}
		
	}
	
	public static Rocket search(String[][] maze, Rocket parent)
	{
		boolean visited[][] = new boolean[maze.length][maze[0].length];
		
		Queue<Rocket> queue = new LinkedList<Rocket>();
		
		visited[parent.posX][parent.posY] = true;
		
		queue.add(parent);
				
		while(queue.peek() != null)
		{
						
			Rocket current = queue.poll();
			if (maze[current.posX][current.posY] == "&") {
				for(var rocket : queue)
				{
					current.trace.coordinates.add(new Coordinate(rocket.posX,rocket.posY));
				}
				return current;
			}
			
			
			for(int i = 0; i < 4; i++)
			{
				if(isValid(maze, visited, current.posX + row[i], current.posY + col[i]))
				{
					visited[current.posX + row[i]][current.posY + col[i]] = true;
					queue.add(new Rocket(current.posX + row[i], current.posY + col[i], current.trace.distance + 1));
				}
			}
			
		}
		
		return parent;
	}
	
	
	public static boolean isValid(String maze[][], boolean visited[][], int x, int y)
	{
		return (x >= 0) && (x < maze.length) && (y >= 0) && (y < maze[0].length)
				&& maze[x][y] == "." &&  !visited[x][y] || maze[x][y] == "&";
	}
	
	/*public static ArrayList<Rocket> getAdjacent(String[][] maze, Rocket current) {
		
		ArrayList<Rocket> adjacent = new ArrayList<Rocket>();
		
		int posX = current.posX;
		int posY = current.posY;
		int dist = current.distance;
		
		//North
		if(posY > 0 && maze[posX][posY-1] != "#")
		{
			
			adjacent.add(new Rocket(posX, posY - 1,dist + 1));
		}
		
		//South
		if(posY < maze.length -1 && maze[posX][posY+1] != "#")
		{
			
			adjacent.add(new Rocket(posX, posY + 1,dist + 1));
		}
		
		//West
		if(posX > 0 && maze[posX-1][posY] != "#")
		{
			
			adjacent.add(new Rocket(posX - 1, posY,dist + 1));
		}
		
		//East
		if(posX < maze[0].length -1 && maze[posX+1][posY] != "#")
		{
			
			adjacent.add(new Rocket(posX + 1, posY,dist + 1));
		}
		
		return adjacent;
	}
	
	*/
	private static void PrintMatrix(String maze[][])
	{
		for(int i = 0; i < maze.length; i++)
		{
			for(int j = 0; j < maze.length; j++)
			{
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
	}
	
	private static Rocket findRocket(String maze[][])
	{
		int i,j = 0;
		outerloop:
		for(i = 0; i < maze.length-1; i++)
		{
			for(j = 0; j < maze[0].length-1; j++)
			{
				if(maze[i][j] == "~")
					break outerloop;
			}
		}
		
		Rocket rocket = new Rocket(i,j,0);
		return rocket;
	}
}
