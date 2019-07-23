import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Startup {

	private static int row[] = {-1, 0, 0, 1};
	private static int col[] = {0, -1, 1, 0};
	
	public static void main(String args[]) throws IOException, InterruptedException
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
		
		var distance = search(maze, rocket).trace.distance;
		
		
		
		Coordinate coordinate = search(maze, rocket).trace.coordinates;
		List<Coordinate> coordinates = new ArrayList<Coordinate>(); 
		for(int i = 0; i < distance; i++)
		{
			coordinates.add(coordinate);
			coordinate = coordinate.parent;
		}
		
		Collections.reverse(coordinates);
				
		Scanner scanner = new Scanner(System.in);
		Coordinate previousCoord = rocket.trace.coordinates;

		for(var coord : coordinates)	
		{
			PrintMatrix(maze);
			scanner.nextLine();
			maze[previousCoord.x][previousCoord.y] = ".";
			if(maze[coord.x][coord.y] == "&")
				maze[coord.x][coord.y] = "@";
			else
				maze[coord.x][coord.y] = "~";
		    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			PrintMatrix(maze);
		    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			previousCoord = coord;		
		}
		PrintMatrix(maze);
		scanner.close();
		if(distance != 0)
			System.out.printf("\n Distance traveled: %d", distance);
		else
			System.out.println("\n Cannot reach robot!");
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
				return current;
			}
			
			
			for(int i = 0; i < 4; i++)
			{
				if(isValid(maze, visited, current.posX + row[i], current.posY + col[i]))
				{
					visited[current.posX + row[i]][current.posY + col[i]] = true;
					Rocket rocket = new Rocket(current.posX + row[i], current.posY + col[i], current.trace.distance + 1);
					rocket.trace.coordinates = new Coordinate(current.posX + row[i], current.posY + col[i]);
					if(current.trace.coordinates != null)
						rocket.trace.coordinates.parent = current.trace.coordinates;
					queue.add(rocket);
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
		rocket.trace.coordinates = new Coordinate(i,j);
		return rocket;
	}
}

