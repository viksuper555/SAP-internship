
public class Seventh {
	public static void main(String args[]){		//Find multiplication of nums
												// below the main diagonal
	int arr[][] = {{1,2,3}, {5,6,7}, {2,3,5}}, multi = 1;
	
	int len = arr.length;
	for(int i = 1; i < len; i++)
	{
		for(int j = 0; j < i; j++)
		{
			multi *= arr[i][j];
		}
		
	}
	System.out.print(multi);
	}
}
