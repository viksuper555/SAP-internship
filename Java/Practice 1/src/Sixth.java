public class Sixth {
	public static void main(String[] args) //Print diagonals in matrix
	{
		int arr[][] = {{1,2,3,4}, {5,6,7,8}, {1,3,5,7}};
		int len = Math.min(arr.length, arr[0].length);
		
		for(int i = 0; i < len;i++)
		{
			System.out.print(arr[i][i]);		//Diagonal
		}
		System.out.println();
		for(int i = 0; i < len; i++)
		{
			System.out.print(arr[i][arr.length-i]); //Reverse diagonal
		}
	}
}
