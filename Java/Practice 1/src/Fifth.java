public class Fifth {
	
	public static void main(String[] args) //Find row with max sum in a matrix
	{
		int arr[][] = {{1,2,3,4}, {5,6,7,8}, {1,3,5,7}}, max = 0, maxpos = 0;
		
		for(int i = 0; i <arr.length; i++)		//Check sums of rows and get pos of max
		{
			if(max < countSum(i,arr))
			{
				maxpos = i;
				max = countSum(i,arr);
			}
		}
		System.out.print(maxpos);
	}
	public static int countSum(int row, int arr[][]){
		int result = 0;
		for(int i = 0; i < arr[row].length; i++)		//Count sum of a row
		{
			result += arr[row][i];
		}
			
		return result;
	}
}
