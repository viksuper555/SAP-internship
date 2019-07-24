import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Startup {

	private static int row[] = {-1, 0, 0, 1};
	private static int col[] = {0, -1, 1, 0};
	
	public static void main(String args[]) throws IOException, InterruptedException
	{
		String maze[][] = 	   {{"#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
								{"#", ".", ".", ".", ".", ".", ".", ".", ".", "#"},
								{"#", ".", "#", ".", "#", "#", "#", "#", ".", "#"},
								{"#", ".", ".", "#", ".", "#", ".", "#", "&", "#"},
								{"#", ".", ".", ".", ".", ".", ".", "#", "#", "#"},
								{"#", ".", "#", "#", "#", "#", ".", "#", ".", "#"},
								{"#", ".", "#", ".", ".", ".", ".", "#", ".", "#"},
							 	{"#", "#", "#", "#", "#", ".", "#", "#", ".", "#"},
							 	{"#", "~", ".", ".", ".", ".", ".", ".", ".", "#"},
							 	{"#", "#", "#", "#", "#", "#", "#", "#", "#", "#"}};
		
		Rocket rocket = findRocket(maze);
		var distance = search(maze, rocket).trace.distance;
		int distanceTraveled = 0;
		Scanner scanner = new Scanner(System.in);
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		PrintMatrix(maze);
		if(distance != 0)
		{
			
			while(findCharCoordinates(maze, "@") == null)
			{
				
				rocket = findRocket(maze);
				List<Coordinate> coordinates = GetCoordinatesTrace(maze);
				
				
				Coordinate previousCoord = rocket.trace.coordinates;
				Coordinate previousBotCoord = findCharCoordinates(maze, "&");			
				scanner.nextLine();
				for(int i = 0; i < 2; i ++)
				{
					Coordinate nextHop = coordinates.get(i);
					
					maze[previousCoord.x][previousCoord.y] = ".";
					if(maze[nextHop.x][nextHop.y] == "&")
					{
						maze[nextHop.x][nextHop.y] = "@";
						break;
					}
					else
						maze[nextHop.x][nextHop.y] = "~";
					
					distanceTraveled++;
					previousCoord = nextHop;
				}
				if(findCharCoordinates(maze, "@") == null && botRandomMove(maze) != null)
				{
					Coordinate botNextHop = botRandomMove(maze);
					maze[previousBotCoord.x][previousBotCoord.y] = ".";
					maze[botNextHop.x][botNextHop.y] = "&";
				}

				   new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				PrintMatrix(maze);
				
			}
		}
		else
			System.out.println("\n Cannot reach robot!");
		
		System.out.printf("\nDistance traveled: %d", distanceTraveled);

		scanner.close();
		
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
		Coordinate coord = findCharCoordinates(maze, "~");
		
		Rocket rocket = new Rocket(coord.x,coord.y,0);
		rocket.trace.coordinates = coord;
		return rocket;
	}
	
	private static Coordinate findCharCoordinates(String maze[][], String chr)
	{
		int i,j = 0;
		
		for(i = 0; i < maze.length-1; i++)
		{
			for(j = 0; j < maze[0].length-1; j++)
			{
				if(maze[i][j] == chr)
					return new Coordinate(i,j);
			}
		}
		
		return null;
	}
	
	private static List<Coordinate> GetCoordinatesTrace(String maze[][])
	{
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
		return coordinates;
	}

	private static Coordinate botRandomMove(String maze[][])
	{
		int posX = findCharCoordinates(maze, "&").x;
		int posY = findCharCoordinates(maze, "&").y;

		List<Coordinate> validCoordinates = new ArrayList<Coordinate>();
		
		for(int i = 0; i < 4; i++)
		{
			int x = posX + row[i];
			int y = posY + col[i];
			if((x >= 0) && (x < maze.length) && (y >= 0) && (y < maze[0].length)
					&& maze[x][y] == ".")
			{
				validCoordinates.add(new Coordinate(x,y));
			}
		}
		Random rand = new Random();
		if(validCoordinates.size() <= 0)
			return null;
		return validCoordinates.get(rand.nextInt(validCoordinates.size()));
	}

}

