import java.util.Scanner;

public class TaskEleven {			//Create a matrix from user input
	public static void main(String args[])
	{
		int n, m;
		Scanner scanner = new Scanner(System.in);
		do {	
		System.out.println("Enter N:");
		n = scanner.nextInt();
		}while(n < 0);
		
		do {
		System.out.println("Enter M:");
		m = scanner.nextInt();
		}while(n < 0);
		int arr[][] = new int[n][m];
		
		for(int i = 0; i < n; i ++)
		{
			for(int j = 0; j < m; j++)
			{
				do {
				arr[i][j] = scanner.nextInt();
				}while(arr[i][j] < Integer.MIN_VALUE || arr[i][j] > Integer.MAX_VALUE);
			}
		}
		
		for(int i = 0; i < n; i ++)
		{
			for(int j = 0; j < m; j++)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		scanner.close();
	}
}
