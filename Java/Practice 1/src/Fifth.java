public class Fifth {
	
	public static void main(String[] args)
	{
		int arr[][] = {{1,2,3,4}, {5,6,7,8}, {1,3,5,7}}, max = 0, maxpos = 0;
		
		for(int i = 0; i <arr.length; i++)
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
		for(int i = 0; i < arr[row].length; i++)
		{
			result += arr[row][i];
		}
			
		return result;
	}
}
