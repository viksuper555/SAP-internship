
public class Seventh {
	public static void main(String args[]){		//Find multiplication of nums
												// below the main diagonal
	int arr[][] = {{1,2,3,4}, {5,6,7,8}, {1,3,5,7}}, multi = 1;
	
	int len = Math.min(arr.length, arr[0].length);
	for(int i = 1; i < len; i++)
	{
		multi *= arr[i][i-1];
	}
	System.out.print(multi);
	}
}
